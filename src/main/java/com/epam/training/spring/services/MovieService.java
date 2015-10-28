package com.epam.training.spring.services;


import com.epam.training.spring.domains.Movie;
import com.epam.training.spring.domains.Rating;

import java.util.List;

/**
 * MovieService - Manages movies

 - createMovie - should create Movie with name, duration base price for tickets, rating (high, mid, low)
 - deleteMovie
 - getAllMovies
 - getMoviesByName
 - getMoviesByRating
 */
public interface MovieService extends GenericService<Movie>{

    Movie createMovie(String name, long duration, float basePrice, Rating rating);

    void deleteMovie(Movie movie);

    List<Movie> getAllMovies();
    List<Movie> getMoviesByName(String name);
    List<Movie> getMoviesByRating(Rating rating);
}
