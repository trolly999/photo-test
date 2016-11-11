package com.springwoodcomputers.mapper;

import com.springwoodcomputers.dbObjects.Count;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by trolly on 24/04/16.
 */
public class CountMapper implements ResultSetMapper<Count> {


    public Count map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Count(r.getInt("count"));
    }
}
