package resources;

import JaxbParser.JaxbParser;
import serviceElements.Cinema;
import serviceElements.Film;
import serviceElements.ReservationPlace;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Vladislav on 03.04.2017.
 */
@Path("cinema")
public class CinemaResource {
    private Cinema cinema;
    private File file;
    private JaxbParser parser;

    private void saveUpdate() {
        try {
            parser.saveObject(file, cinema);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Cinema getCinema() {
        file = new File("D:\\workspace\\WebService\\cinema.xml");
        parser = new JaxbParser();
        try {
            cinema = (Cinema) parser.getObject(file, Cinema.class);
        } catch (Exception e) {
            cinema = new Cinema();
            e.printStackTrace();
        }
        return new Cinema();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public ReservationPlace getPlaceById(@PathParam("id") int id) throws Exception {
        ReservationPlace place = cinema.getPlaceById(id);
        if (place == null) {
            throw new Exception("Place not found");
        }
        return place;
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Film getFilmById(@PathParam("id") int id) throws Exception {
        Film film = cinema.getFilmById(id);
        if (film == null)
            throw new Exception("Film not found!");
        return film;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void addFilm(Film film) {
        ArrayList<Film> filmList = cinema.getAllFilms();
        int id = 1;
        if (filmList.size() != 0)
            id = filmList.get(filmList.size() - 1).getId() + 1;
        cinema.addFilm(new Film(id, film.getName(), film.getTime(), film.getPrice(), film.getCountPlace()));
        saveUpdate();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void addPlace(ReservationPlace place) {
        ArrayList<ReservationPlace> places = cinema.getPlaces();
        int id = 1;
        if (places.size() != 0)
            id = places.get(places.size() - 1).getId() + 1;
        try {
            cinema.addPlace(new ReservationPlace(id, place.getFilm(), place.getFullName(), place.getCount()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        saveUpdate();
    }

    @DELETE
    @Path("{id}")
    public void removeReservationPlace(@PathParam("id") int id) {
        cinema.removeReservationPlaceById(id);
        try {
            parser.saveObject(file, cinema);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("{id}")
    public void removeFilm(@PathParam("id") int id) {
        cinema.removeFilmById(id);
        saveUpdate();
    }

}
