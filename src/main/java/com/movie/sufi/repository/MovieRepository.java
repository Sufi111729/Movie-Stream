package com.movie.sufi.repository;

import com.movie.sufi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByIsFeaturedTrue();
    List<Movie> findByIsTrendingTrue();
    List<Movie> findByCategory(String category);
    
    @Query("SELECT m FROM Movie m WHERE " +
           "LOWER(m.title) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
           "LOWER(m.description) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Movie> searchByTitleOrDescription(String query);
}