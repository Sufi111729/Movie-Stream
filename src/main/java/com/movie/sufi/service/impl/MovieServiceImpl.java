package com.movie.sufi.service.impl;

import com.movie.sufi.model.Movie;
import com.movie.sufi.repository.MovieRepository;
import com.movie.sufi.service.MovieService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getFeaturedMovies() {
        return movieRepository.findByIsFeaturedTrue();
    }

    @Override
    public List<Movie> getTrendingMovies() {
        return movieRepository.findByIsTrendingTrue();
    }

    @Override
    public List<Movie> getMoviesByCategory(String category) {
        return movieRepository.findByCategory(category);
    }

    @Override
    public List<Movie> searchMovies(String query) {
        return movieRepository.searchByTitleOrDescription(query);
    }

    @Override
    public Movie getMovieDetails(Long id) {
        return movieRepository.findById(id).orElseThrow();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}