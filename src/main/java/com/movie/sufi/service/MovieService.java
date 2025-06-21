package com.movie.sufi.service;

import com.movie.sufi.model.Movie;
import java.util.List;

public interface MovieService {
    List<Movie> getFeaturedMovies();
    List<Movie> getTrendingMovies();
    List<Movie> getMoviesByCategory(String category);
    List<Movie> searchMovies(String query);
    Movie getMovieDetails(Long id);
    Movie saveMovie(Movie movie);
    void deleteMovie(Long id);
}