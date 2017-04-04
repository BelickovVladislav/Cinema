package serviceElements;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

/**
 * Created by Vladislav on 03.04.2017.
 */
@XmlRootElement(name = "cinema")
@XmlType(propOrder = {"allFilms","places"})
public class Cinema {
    private ArrayList<ReservationPlace> places;
    private ArrayList<Film> films;
    public Cinema(){
        films = new ArrayList<Film>();
        places = new ArrayList<ReservationPlace>();
    }

    @XmlElement(name = "places")
    @XmlElementWrapper
    public ArrayList<ReservationPlace> getPlaces() {
        return places;
    }
    public void addPlace(ReservationPlace place) throws Exception {
        if(getCountFreePlaces(place.getFilm().getId()) - place.getCount() < 0)
            throw new Exception("Нет столько мест!");
        this.places.add(place);
    }
    public void addFilm(Film film){
        films.add(film);
    }
    public  ReservationPlace getPlaceById(int id){
        for(ReservationPlace place : places)
            if (place.getId() == id)
                return place;
        return null;
    }
    private int getCountFreePlaces(int idFilm){
        int count = getFilmById(idFilm).getCountPlace();
        for (ReservationPlace place : places)
            if (place.getFilm().getId()== idFilm)
                count -= place.getCount();
        return count;
    }
    public void removeReservationPlaceById(int id){
        ReservationPlace place = getPlaceById(id);
        if(place == null)
            return;
        places.remove(place);
    }
    @XmlElement(name = "films")
    @XmlElementWrapper
    public ArrayList<Film> getAllFilms(){
        return this.films;
    }
    public Film getFilmById(int id){
        for(Film film : films)
            if(film.getId() == id)
                return film;
        return null;
    }
    public void removeFilmById(int id){
        Film film = getFilmById(id);
        if(film == null)
            return;
        films.remove(film);
    }
    @Override
    public String toString(){
        String result = "";
        for(Film film: films)
            result+= film+"\t"+getCountFreePlaces(film.getId())+"\n";
        return result;
    }
}
