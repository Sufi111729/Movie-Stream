package com.movie.sufi.controller;

import com.movie.sufi.model.Movie;
import com.movie.sufi.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/featured")
    public List<Movie> getFeaturedMovies() {
        return movieService.getFeaturedMovies();
    }

    @GetMapping("/trending")
    public List<Movie> getTrendingMovies() {
        return movieService.getTrendingMovies();
    }

    @GetMapping("/category/{category}")
    public List<Movie> getMoviesByCategory(@PathVariable String category) {
        return movieService.getMoviesByCategory(category);
    }

    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String query) {
        return movieService.searchMovies(query);
    }

    @GetMapping("/{id}")
    public Movie getMovieDetails(@PathVariable Long id) {
        return movieService.getMovieDetails(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}