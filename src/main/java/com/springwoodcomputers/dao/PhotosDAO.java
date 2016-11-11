package com.springwoodcomputers.dao;

import com.springwoodcomputers.dbObjects.Count;
import com.springwoodcomputers.dbObjects.PhotoDetails;
import com.springwoodcomputers.mapper.CountMapper;
import com.springwoodcomputers.mapper.PhotoDetailsMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Created by trolly on 24/04/16.
 */

public interface PhotosDAO {

    @SqlQuery("select count(*) as count from photos")
    @RegisterMapper(CountMapper.class)
    Count countPhotos();

    @SqlQuery("select id, name, location from photos where id = :id")
    @RegisterMapper(PhotoDetailsMapper.class)
    PhotoDetails getPhoto(@Bind("id") int id);

}
