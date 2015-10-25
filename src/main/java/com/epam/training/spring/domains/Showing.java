package com.epam.training.spring.domains;


import java.util.Date;

public class Showing extends GenericEntity {
    private Movie   movie;
    private Theatre theatre;
    private Date    date;

    public Showing( Movie movie, Theatre theatre, Date date) {
        super(System.currentTimeMillis());
        this.movie = movie;
        this.theatre = theatre;
        this.date = date;
    }
}
