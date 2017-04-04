package serviceElements;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Vladislav on 03.04.2017.
 */
@XmlRootElement(name = "reservationPlace")
@XmlType(propOrder = {"id","film","fullName","count"})
public class ReservationPlace {
    private int id;
    private Film film;
    private String fullName;
    private int count;

    public ReservationPlace(int id,  Film film, String fullName, int count) {
        this.id = id;
        this.film = film;
        this.fullName = fullName;
        this.count = count;
    }
    public ReservationPlace(){

    }
    public int getId() {
        return id;
    }
    @XmlElement(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    @XmlElement(name = "fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCount() {
        return count;
    }
    @XmlElement(name = "counts")
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public String toString(){
        return id+"\t"+film.getName()+"\t"+fullName+"\t"+count;
    }

    public Film getFilm() {
        return film;
    }
    @XmlElement(name = "film")
    public void setFilm(Film film) {
        this.film = film;
    }
}
