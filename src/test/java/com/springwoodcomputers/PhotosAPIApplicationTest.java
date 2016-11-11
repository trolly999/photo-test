package com.springwoodcomputers;

import com.springwoodcomputers.resources.HelloResource;
import io.dropwizard.testing.junit.ResourceTestRule;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by trolly on 23/04/16.
 */
public class PhotosAPIApplicationTest {

    /**
     * Do some setup in order to provide tests with javax.ws.rs.client.Client in
     * order to access resources from Java.
     */
    @Rule
    public ResourceTestRule resource = ResourceTestRule.builder()
            .addResource(new HelloResource()).build();

    /**
     * Greeting object to test resources returning JSON response.
     */
    //public static final Greeting GREETING = new Greeting("Hello world!");

    /**
     * Test of getGreeting method, of class HelloResource.
     */
    @Test
    public void testHelloWorld() {
        String expected = "Hello world!";
        //Obtain client from @Rule.
        Client client = resource.client();
        //Get WebTarget from client using URI of root resource.
        WebTarget helloTarget = client.target("http://localhost:8080/hello");
        //To invoke response we use Invocation.Builder
        //and specify the media type of representation asked from resource.
        Invocation.Builder builder = helloTarget.request(MediaType.TEXT_PLAIN);
        //Obtain response.
        Response response = builder.get();

        //Do assertions.
        assertEquals(Response.Status.OK, response.getStatusInfo());
        String actual = response.readEntity(String.class);
        assertEquals(expected, actual);

        //Same as above. Everything can be chained.
        actual = resource.client()
                .target("http://localhost:8080/hello")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertEquals(expected, actual);
    }

}
