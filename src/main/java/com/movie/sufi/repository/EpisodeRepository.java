package com.movie.sufi.repository;

import com.movie.sufi.model.Episode;
import com.movie.sufi.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    List<Episode> findByMovieOrderByIdAsc(Movie movie);
}