package com.springwoodcomputers.resources;

import com.springwoodcomputers.dbObjects.Count;
import com.springwoodcomputers.dao.PhotosDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by trolly on 24/04/16.
 */
@Path("/count")
public class CountResource {

    private final PhotosDAO dao;

    public CountResource(PhotosDAO dao) {
     this.dao = dao;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Count getCount() {
        return dao.countPhotos();
    }

}
