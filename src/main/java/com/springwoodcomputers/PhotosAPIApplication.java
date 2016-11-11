package com.springwoodcomputers;


import com.springwoodcomputers.dao.PhotosDAO;
import com.springwoodcomputers.resources.CountResource;
import com.springwoodcomputers.resources.GetRandomPhotoResource;
import com.springwoodcomputers.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

/**
 * Created by trolly on 23/04/16.
 */
public class PhotosAPIApplication extends Application<PhotosAPIConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PhotosAPIApplication().run(args);
    }

    private static int maxPhotoID;

    public static int getMaxPhotoID() {
        return maxPhotoID;
    }

    @Override
    public void initialize(Bootstrap<PhotosAPIConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(final PhotosAPIConfiguration configuration,
                     final Environment environment) {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
        final PhotosDAO dao = jdbi.onDemand(PhotosDAO.class);

        environment.jersey().register(new CountResource(dao));
        maxPhotoID = dao.countPhotos().getCount();

        environment.jersey().register(new HelloResource());
        environment.jersey().register(new GetRandomPhotoResource(dao));
    }

}
