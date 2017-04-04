package core;

import org.glassfish.jersey.server.ResourceConfig;
import resources.CinemaResource;

/**
 * Created by Vladislav on 04.04.2017.
 */
public class MyApp extends ResourceConfig {
    public MyApp(){
        packages("core","resources","serviceElements");

        register(CinemaResource.class);

    }
}
