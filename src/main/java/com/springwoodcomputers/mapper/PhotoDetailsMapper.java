package com.springwoodcomputers.mapper;

import com.springwoodcomputers.dbObjects.PhotoDetails;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by trolly on 24/04/16.
 */
public class PhotoDetailsMapper implements ResultSetMapper<PhotoDetails> {
    @Override
    public PhotoDetails map(int i, ResultSet r, StatementContext statementContext) throws SQLException {
        return new PhotoDetails(r.getInt("id"), r.getString("name"), r.getString("location"));
    }
}
