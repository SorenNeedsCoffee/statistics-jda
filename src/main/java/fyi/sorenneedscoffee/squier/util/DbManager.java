package fyi.sorenneedscoffee.squier.util;

import fyi.sorenneedscoffee.squier.config.StatsDb;
import fyi.sorenneedscoffee.squier.util.data.DataSet;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static fyi.sorenneedscoffee.squier.db.tables.Statistics.STATISTICS;

public class DbManager {
    private final Logger log = LoggerFactory.getLogger("DbManager");
    private final String url;

    public DbManager(StatsDb db) {
        url = "jdbc:mariadb://" + db.getIp() + "/" + db.getDb() + "?"
                + "user=" + db.getUser() + "&password=" + db.getPass();
        log.info("Validating connection to " + db.getDb() + " at " + db.getIp() + "...");

        try (Connection connect = DriverManager.getConnection(url)) {
            if (connect.isValid(5))
                log.info("Success.");
            else
                log.error("Failed. Please check your configuration");
        } catch (SQLException e) {
            log.error("JDBC experienced the following error:" + ExceptionUtils.getMessage(e) + " Please see below for details");
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    public void saveTally(int tally) {
        Timestamp stamp = Timestamp.valueOf(TimeUtil.formatter.withZone(ZoneOffset.UTC).format(Instant.now()));

        try (Connection connect = DriverManager.getConnection(url)) {
            DSLContext context = DSL.using(connect, SQLDialect.MARIADB);

            context.insertInto(STATISTICS, STATISTICS.DATE, STATISTICS.ONLINEUSERS)
                    .values(stamp, tally)
                    .execute();

        } catch (SQLException e) {
            log.error("JDBC experienced the following error:" + ExceptionUtils.getMessage(e) + " Please see below for details");
            log.error(ExceptionUtils.getStackTrace(e));
        }
    }

    public DataSet getStatistics(String date, ZoneId timezone) {
        LocalDateTime localDate = LocalDateTime.parse(date + " 00:00:00", TimeUtil.parser);

        Timestamp min = Timestamp.valueOf(
                TimeUtil.formatter.withZone(ZoneOffset.UTC)
                        .format(TimeUtil.toUTC(localDate, timezone))
        );
        Timestamp max = Timestamp.valueOf(
                TimeUtil.formatter.withZone(ZoneOffset.UTC)
                        .format(TimeUtil.toUTC(localDate.plusDays(1), timezone))
        );

        try (Connection connect = DriverManager.getConnection(url)) {
            DSLContext context = DSL.using(connect, SQLDialect.MARIADB);

            Result<Record> result = context.select()
                    .from(STATISTICS)
                    .where(STATISTICS.DATE.greaterOrEqual(min))
                    .and(STATISTICS.DATE.lessThan(max))
                    .fetch();

            return new DataSet(result.intoResultSet());
        } catch (SQLException e) {
            log.error("JDBC experienced the following error:" + ExceptionUtils.getMessage(e) + " Please see below for details");
            log.error(ExceptionUtils.getStackTrace(e));
        } catch (DateTimeParseException e) {
            log.error(ExceptionUtils.getMessage(e));
            log.error(ExceptionUtils.getStackTrace(e));
        }

        return null;
    }
}
