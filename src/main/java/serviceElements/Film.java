package serviceElements;

import JaxbParser.JaxbParser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;

/**
 * Created by Vladislav on 03.04.2017.
 */
@XmlRootElement(name = "film")
@XmlType(propOrder = {"id","name","time","price" ,"countPlace"})
public class Film {
    private int id;
    private String name, time;
    private double price;
    private int countPlace;

    public Film(){
    }
    public Film(int id, String name, String time, double price, int countPlace) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.price = price;
        this.countPlace = countPlace;
    }
    @XmlElement(name = "id")
    public void setId(int id){
        this.id = id;
    }
    @XmlElement(name = "name")
    public void setName(String name){
        this.name = name;
    }
    @XmlElement(name = "time")
    public void setTime(String time){
        this.time = time;
    }
    @XmlElement(name = "price")
    public void setPrice(double price){
        this.price = price;
    }
    @XmlElement(name = "countPlace")
    public void setCountPlace(int countPlace){
        this.countPlace = countPlace;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public int getCountPlace() {
        return countPlace;
    }
    @Override
    public String toString(){
        return id+"\t"+name+"\t"+time+"\t"+price;
    }
}
