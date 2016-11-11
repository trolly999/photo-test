package com.springwoodcomputers.resources;

import com.springwoodcomputers.app.RandomPhoto;
import com.springwoodcomputers.dao.PhotosDAO;
import com.springwoodcomputers.dbObjects.PhotoDetails;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by trolly on 24/04/16.
 */
@Path("/randomphoto")
public class GetRandomPhotoResource {

    private final PhotosDAO dao;
    private RandomPhoto randomPhoto = RandomPhoto.getInstance();

    public GetRandomPhotoResource(PhotosDAO dao) {
        this.dao = dao;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PhotoDetails getCount() {
        PhotoDetails photoDetails = null;
        while (true) {
            photoDetails = dao.getPhoto(randomPhoto.getRandom() + 1);
            if (photoDetails != null) {
                break;
            }

        }
        return photoDetails;
    }
}