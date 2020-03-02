/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.squier.db.tables.records;


import fyi.sorenneedscoffee.squier.db.tables.Statistics;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.12.4"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class StatisticsRecord extends UpdatableRecordImpl<StatisticsRecord> implements Record2<Timestamp, Integer> {

    private static final long serialVersionUID = -1988625365;

    /**
     * Create a detached StatisticsRecord
     */
    public StatisticsRecord() {
        super(Statistics.STATISTICS);
    }

    /**
     * Create a detached, initialised StatisticsRecord
     */
    public StatisticsRecord(Timestamp date, Integer onlineusers) {
        super(Statistics.STATISTICS);

        set(0, date);
        set(1, onlineusers);
    }

    /**
     * Getter for <code>s13_statistics.statistics.Date</code>.
     */
    public Timestamp getDate() {
        return (Timestamp) get(0);
    }

    /**
     * Setter for <code>s13_statistics.statistics.Date</code>.
     */
    public void setDate(Timestamp value) {
        set(0, value);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * Getter for <code>s13_statistics.statistics.OnlineUsers</code>.
     */
    public Integer getOnlineusers() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * Setter for <code>s13_statistics.statistics.OnlineUsers</code>.
     */
    public void setOnlineusers(Integer value) {
        set(1, value);
    }

    @Override
    public Record1<Timestamp> key() {
        return (Record1) super.key();
    }

    @Override
    public Row2<Timestamp, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Timestamp, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Timestamp> field1() {
        return Statistics.STATISTICS.DATE;
    }

    @Override
    public Field<Integer> field2() {
        return Statistics.STATISTICS.ONLINEUSERS;
    }

    @Override
    public Timestamp component1() {
        return getDate();
    }

    @Override
    public Integer component2() {
        return getOnlineusers();
    }

    @Override
    public Timestamp value1() {
        return getDate();
    }

    @Override
    public Integer value2() {
        return getOnlineusers();
    }

    @Override
    public StatisticsRecord value1(Timestamp value) {
        setDate(value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    @Override
    public StatisticsRecord value2(Integer value) {
        setOnlineusers(value);
        return this;
    }

    @Override
    public StatisticsRecord values(Timestamp value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }
}
