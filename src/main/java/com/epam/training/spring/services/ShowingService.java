package com.epam.training.spring.services;

import com.epam.training.spring.domains.Movie;
import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.Theatre;

import java.util.Date;
import java.util.List;


/**
 * ShowingService - Manages movie events

 - createShowing - should create Showing with movie, theatre (movie theatre), date of event
 - removeShowing
 - getAllShowing
 - getShowingsByMovie(Movie) - returns all showing events with this movie
 - getShowingByTheatre(Theatre) - returns all showing events with this movie theatre
 - getShowingByTheatreAndDate(Theatre theatre, Date from, Date to) - returns all showing events with this movie theatre
 for particular date range
 - getShowingByTheatreAndDate(Theatre theatre, Date to) - same as getShowingByTheatreAndDate starting from now
 */
public interface ShowingService extends GenericService<Showing> {

    Showing createShowing(Movie movie, Theatre theatre, Date date) throws AvailabilityException;
    void removeShowing(Showing showing);

    List<Showing> getAllShowing();

    List<Showing> getShowingsByMovie(Movie movie);
    List<Showing> getShowingByTheatre(Theatre theatre);
    List<Showing> getShowingByTheatreAndDate(Theatre theatre, Date from, Date to);
    List<Showing> getShowingByTheatreAndDate(Theatre theatre, Date to);
}
