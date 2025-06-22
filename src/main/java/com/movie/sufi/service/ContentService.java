
package com.movie.sufi.service;

import com.movie.sufi.model.Content;
import java.util.List;
import java.util.Optional;

public interface ContentService {
    Content saveContent(Content content);
    List<Content> getAllContent();
    Optional<Content> getContentById(Long id);
    void deleteContent(Long id);
    List<Content> findByTitle(String title);
    List<Content> findByGenre(String genre);
    List<Content> findByReleaseYearGreaterThan(int year);
    List<Content> getAllOrderByRatingsDesc();
    List<Content> getAllOrderByReleaseYearDesc();
    List<Content> getAllMovies();
    List<Content> getAllWebSeries();
    List<Content> getFeaturedTitles();
    List<Content> getRecentlyAddedEpisodes();
    List<Content> getRecentlyAddedSeasons();
    List<Content> getTopMovies();
    List<Content> getTopTVShows();
    List<Content> findAllByOrderByRatingsDesc();
}
