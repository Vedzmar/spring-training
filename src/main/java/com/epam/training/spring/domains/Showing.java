package com.epam.training.spring.domains;


import java.util.Date;

public class Showing extends GenericEntity {
    private Movie   movie;
    private Theatre theatre;
    private Date    date;

    public Showing( Movie movie, Theatre theatre, Date date) {
        super(System.nanoTime());
        this.movie = movie;
        this.theatre = theatre;
        this.date = date;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "movie=" + movie +
                ", theatre=" + theatre +
                ", date=" + date +
                '}';
    }
}
