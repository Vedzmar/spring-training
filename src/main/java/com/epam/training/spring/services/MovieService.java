package com.epam.training.spring.services;


import com.epam.training.spring.domains.Movie;
import com.epam.training.spring.domains.Rating;

import java.util.List;

public interface MovieService extends GenericService<Movie>{

    Movie createMovie(String name, long duration, float basePrice, Rating rating);
    void deleteMovie();

    List<Movie> getAllMovies();
    List<Movie> getMoviesByName(String name);
    List<Movie> getMoviesByRating(Rating rating);
}
