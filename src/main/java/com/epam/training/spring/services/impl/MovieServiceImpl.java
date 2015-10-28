package com.epam.training.spring.services.impl;

import com.epam.training.spring.domains.Movie;
import com.epam.training.spring.domains.Rating;
import com.epam.training.spring.services.MovieService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieServiceImpl implements MovieService {


    private List<Movie> movies = new ArrayList<>();

    @Override
    public Movie createMovie(String name, long duration, float basePrice, Rating rating) {
        Movie movie = new Movie(name, duration, basePrice, rating);

        movies.add(movie);

        return movie;
    }

    @Override
    public void deleteMovie(Movie movie) {
        Iterator<Movie> i = movies.iterator();
        while (i.hasNext()){
            if (i.next().getId() == movie.getId()){
                i.remove();
            }
        }
    }

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public List<Movie> getMoviesByName(String name) {
        List<Movie> moviesByName = new ArrayList<>();

        for (Movie movie : movies){
            if ( movie.getName().equals(name) ) {
                moviesByName.add( movie );
            }
        }

        return moviesByName;
    }

    @Override
    public List<Movie> getMoviesByRating(Rating rating) {
        List<Movie> moviesByRating = new ArrayList<>();

        for (Movie movie : movies){
            if (movie.getRating() == rating) {
                moviesByRating.add(movie);
            }
        }

        return moviesByRating;
    }

    @Override
    public Movie getById(long id) {

        for (Movie movie : movies){
            if (movie.getId() == id) {
                return movie;
            }
        }

        return null;
    }
}
