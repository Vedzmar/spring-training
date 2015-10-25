package com.epam.training.spring.services;

import com.epam.training.spring.domains.Movie;
import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.Theatre;

import java.util.Date;
import java.util.List;


public interface ShowingService extends GenericService<Showing> {

    Showing createShowing(Movie movie, Theatre theatre, Date date);
    void removeShowing(Showing showing);

    List<Showing> getAllShowing();

    List<Showing> getShowingByMovie(Movie movie);
    List<Showing> getShowingByTheatre(Theatre theatre);
    List<Showing> getShowingByTheatreAndDate(Theatre theatre, Date from, Date to);
    List<Showing> getShowingByTheatreAndDate(Theatre theatre, Date to);
}
