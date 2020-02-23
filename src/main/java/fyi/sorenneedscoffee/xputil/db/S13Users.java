/*
 * This file is generated by jOOQ.
 */
package fyi.sorenneedscoffee.xputil.db;


import fyi.sorenneedscoffee.xputil.db.tables.Users;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class S13Users extends SchemaImpl {

    private static final long serialVersionUID = -583032552;

    /**
     * The reference instance of <code>s13_users</code>
     */
    public static final S13Users S13_USERS = new S13Users();

    /**
     * The table <code>s13_users.users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private S13Users() {
        super("s13_users", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Users.USERS);
    }
}