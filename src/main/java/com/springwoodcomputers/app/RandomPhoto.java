package com.springwoodcomputers.app;

import com.springwoodcomputers.PhotosAPIApplication;
import com.springwoodcomputers.resources.CountResource;

import java.util.Random;

/**
 * Created by trolly on 24/04/16.
 */
public class RandomPhoto {
    private static RandomPhoto ourInstance = null;

    public static RandomPhoto getInstance() {
        if (ourInstance == null) {
            ourInstance =  new RandomPhoto();

        }
        return ourInstance;
    }

    private RandomPhoto() {
    }

    Random randomGenerator = new Random();

    public int getRandom() {
        return randomGenerator.nextInt(PhotosAPIApplication.getMaxPhotoID());
    }
}
