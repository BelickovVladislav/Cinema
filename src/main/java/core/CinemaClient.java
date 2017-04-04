package core;


import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import serviceElements.Cinema;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by Vladislav on 03.04.2017.
 */
public class CinemaClient {
    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        Client client  = ClientBuilder.newClient(config);
        GenericType<Cinema> genericType = new GenericType<Cinema>(){};
        WebTarget service = client.target(getBaseURI());
        Cinema cinema = service.path("rest").path("cinema").request().accept(MediaType.APPLICATION_XML).get(genericType);
        System.out.println(cinema);

    }
    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/WebService").build();
    }
}
