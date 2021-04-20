package com.MusicManager.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Document(collection = "song")
@Entity
@Table(name="song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@Column(name = "")
    private String name;
    private String genre;
    private Date timeUpdate;
    //private File file;

    public Song(){

    }

    public Song (Integer id, String name, String genre, Date timeUpdate){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.timeUpdate = timeUpdate;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public Date getTimeUpdate(){
        return timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate){
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(timeUpdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.timeUpdate = date;
    }

    @Override
    public String toString(){
        return name + " " + genre + " " + timeUpdate + " ";
    }

}
