/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.squier.db.tables;


import fyi.sorenneedscoffee.squier.db.Indexes;
import fyi.sorenneedscoffee.squier.db.Keys;
import fyi.sorenneedscoffee.squier.db.S13Statistics;
import fyi.sorenneedscoffee.squier.db.tables.records.StatisticsRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


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
public class Statistics extends TableImpl<StatisticsRecord> {

    /**
     * The reference instance of <code>s13_statistics.statistics</code>
     */
    public static final Statistics STATISTICS = new Statistics();
    private static final long serialVersionUID = -2131066965;
    /**
     * The column <code>s13_statistics.statistics.Date</code>.
     */
    public final TableField<StatisticsRecord, Timestamp> DATE = createField(DSL.name("Date"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");
    /**
     * The column <code>s13_statistics.statistics.OnlineUsers</code>.
     */
    public final TableField<StatisticsRecord, Integer> ONLINEUSERS = createField(DSL.name("OnlineUsers"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>s13_statistics.statistics</code> table reference
     */
    public Statistics() {
        this(DSL.name("statistics"), null);
    }

    /**
     * Create an aliased <code>s13_statistics.statistics</code> table reference
     */
    public Statistics(String alias) {
        this(DSL.name(alias), STATISTICS);
    }

    /**
     * Create an aliased <code>s13_statistics.statistics</code> table reference
     */
    public Statistics(Name alias) {
        this(alias, STATISTICS);
    }

    private Statistics(Name alias, Table<StatisticsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Statistics(Name alias, Table<StatisticsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Statistics(Table<O> child, ForeignKey<O, StatisticsRecord> key) {
        super(child, key, STATISTICS);
    }

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StatisticsRecord> getRecordType() {
        return StatisticsRecord.class;
    }

    @Override
    public Schema getSchema() {
        return S13Statistics.S13_STATISTICS;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.STATISTICS_PRIMARY);
    }

    @Override
    public UniqueKey<StatisticsRecord> getPrimaryKey() {
        return Keys.KEY_STATISTICS_PRIMARY;
    }

    @Override
    public List<UniqueKey<StatisticsRecord>> getKeys() {
        return Arrays.<UniqueKey<StatisticsRecord>>asList(Keys.KEY_STATISTICS_PRIMARY);
    }

    @Override
    public Statistics as(String alias) {
        return new Statistics(DSL.name(alias), this);
    }

    @Override
    public Statistics as(Name alias) {
        return new Statistics(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Statistics rename(String name) {
        return new Statistics(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Statistics rename(Name name) {
        return new Statistics(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Timestamp, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
