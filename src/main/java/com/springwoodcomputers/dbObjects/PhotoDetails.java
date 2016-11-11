package com.springwoodcomputers.dbObjects;

/**
 * Created by trolly on 24/04/16.
 */
public class PhotoDetails {

    private int photoID;
    private String name;
    private String path;

    public PhotoDetails() {}

    public PhotoDetails(int photoID, String name, String path) {
        this.photoID = photoID;
        this.name = name;
        this.path = path;
    }

    public int getPhotoID() {
        return photoID;
    }

    public void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
