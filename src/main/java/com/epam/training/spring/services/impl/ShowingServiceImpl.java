package com.epam.training.spring.services.impl;

import com.epam.training.spring.domains.Movie;
import com.epam.training.spring.domains.Showing;
import com.epam.training.spring.domains.Theatre;
import com.epam.training.spring.services.AvailabilityException;
import com.epam.training.spring.services.ShowingService;
import org.joda.time.Interval;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ShowingServiceImpl implements ShowingService {

    public static final long INTERMISSION_DURATION = 20 * 60 * 1000;
    private List<Showing> showings = new ArrayList<>();

    @Override
    public Showing createShowing(Movie movie, Theatre theatre, Date date) throws AvailabilityException {
        if (date.before(new Date())) 
            throw new IllegalArgumentException("Showing date cannot be created with date in past time");
        
        if ( !checkAvailability(theatre, movie, date) )
            throw new AvailabilityException("Theatre is not available for current time");

        Showing showing = new Showing(movie, theatre, date);

        showings.add(showing);

        return showing;
    }

    @Override
    public void removeShowing(Showing showing) {
        Iterator<Showing> i = showings.iterator();
        while (i.hasNext()){
            if (i.next().getId() == showing.getId()){
                i.remove();
            }
        }
    }

    @Override
    public List<Showing> getAllShowing() {
        return showings;
    }

    @Override
    public List<Showing> getShowingsByMovie(Movie movie) {
        List<Showing> showingsByMovie = new ArrayList<>();

        for (Showing showing : showings){
            if (showing.getMovie().getId() == movie.getId()){
                showingsByMovie.add(showing);
            }
        }

        return showingsByMovie;
    }

    @Override
    public List<Showing> getShowingByTheatre(Theatre theatre) {
        List<Showing> showingsByTheatre = new ArrayList<>();

        for (Showing showing : showings){
            if (showing.getTheatre().getId() == theatre.getId()){
                showingsByTheatre.add(showing);
            }
        }

        return showingsByTheatre;
    }

    @Override
    public List<Showing> getShowingByTheatreAndDate(Theatre theatre, Date from, Date to) {
        if (to.before(from)) throw new IllegalArgumentException("'to' date cannot be before 'from' date");

        List<Showing> showingsByTheatreAndDate = new ArrayList<>();

        for (Showing showing : getShowingByTheatre(theatre)){
            if (isShowingStartsBetweenDates(showing, from, to)) {
                showingsByTheatreAndDate.add(showing);
            }
        }

        return showingsByTheatreAndDate;
    }

    @Override
    public List<Showing> getShowingByTheatreAndDate(Theatre theatre, Date to) {
        if (to.before(new Date())) return new ArrayList<>();

        return getShowingByTheatreAndDate(theatre, new Date(), to);
    }

    @Override
    public Showing getById(long id) {
        for (Showing showing : showings){
            if (showing.getId() == id){
                return showing;
            }
        }

        return null;
    }

    private boolean isShowingStartsBetweenDates(Showing showing, Date from, Date to) {
        return showing.getDate().before(to) && showing.getDate().after(from);
    }

    private boolean checkAvailability(Theatre theatre, Movie movie, Date date) {
        Date movieEndDate = new Date(date.getTime() + movie.getDuration() + INTERMISSION_DURATION);

        for(Showing showing : getShowingByTheatreAndDate(theatre, date)){
            if (isShowingInInterval(showing, date, movieEndDate)) return false;
        }
        
        return true;
    }

    private boolean isShowingInInterval(Showing showing, Date movieStartDate, Date movieEndDate) {
        Date showingStart = showing.getDate();
        Date showingEnd = new Date(showingStart.getTime() + showing.getMovie().getDuration() + INTERMISSION_DURATION);

        Interval movieInterval = new Interval(movieStartDate.getTime(), movieEndDate.getTime());
        Interval showingInterval = new Interval(showingStart.getTime(), showingEnd.getTime());

        return movieInterval.overlaps(showingInterval);
    }
}
