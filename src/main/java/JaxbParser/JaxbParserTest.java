package JaxbParser;


import serviceElements.Cinema;
import serviceElements.Film;
import serviceElements.ReservationPlace;

import java.io.File;

/**
 * Created by Vladislav on 03.04.2017.
 */
public class JaxbParserTest {

    private Parser parser;
    private File file;
    public void setUp() throws Exception {
        parser = new JaxbParser();
        file = new File("cinema.xml");
    }
    public void testGetObject() throws Exception {
        Cinema cinema = (Cinema)parser.getObject(file,Cinema.class);
        System.out.println(cinema);
    }
    public void testSaveObject() throws Exception {
        Cinema cinema = new Cinema();
        cinema.addFilm(new Film(1,"Film1","15.20",5.0,120));
        cinema.addFilm(new Film(2,"Film2","16.20",6.0,120));
        cinema.addFilm(new Film(3,"Film3","17.20",7.0,120));
        cinema.addFilm(new Film(4,"Film4","18.20",8.0,120));
        cinema.addPlace(new ReservationPlace(1,cinema.getFilmById(1),"FullName1",4));
        cinema.addPlace(new ReservationPlace(2,cinema.getFilmById(2),"FullName2",4));
        cinema.addPlace(new ReservationPlace(3,cinema.getFilmById(3),"FullName3",4));
        parser.saveObject(file,cinema);
    }

}
