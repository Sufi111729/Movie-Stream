
package com.movie.sufi.service.impl;

import com.movie.sufi.model.Content;
import com.movie.sufi.model.Movie;
import com.movie.sufi.model.WebSeries;
import com.movie.sufi.model.Episode.Episode;
import com.movie.sufi.model.Season.Season;
import com.movie.sufi.repository.ContentRepository;
import com.movie.sufi.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public Optional<Content> getContentById(Long id) {
        return contentRepository.findById(id);
    }

    @Override
    public void deleteContent(Long id) {
        contentRepository.deleteById(id);
    }

    @Override
    public List<Content> findByTitle(String title) {
        return contentRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Content> findByGenre(String genre) {
        return contentRepository.findByGenresIgnoreCase(genre);
    }

    @Override
    public List<Content> findByReleaseYearGreaterThan(int year) {
        return contentRepository.findByReleaseYearGreaterThan(year);
    }

    @Override
    public List<Content> getAllOrderByRatingsDesc() {
        return contentRepository.findAllByOrderByRatingsDesc();
    }

    @Override
    public List<Content> getAllOrderByReleaseYearDesc() {
        return contentRepository.findAllByOrderByReleaseYearDesc();
    }

    @Override
    public List<Content> getAllMovies() {
        return contentRepository.findByType(Movie.class);
    }

    @Override
    public List<Content> getAllWebSeries() {
        return contentRepository.findByType(WebSeries.class);
    }

    @Override
    public List<Content> getFeaturedTitles() {
        return contentRepository.findByFeaturedTrue();
    }

    @Override
    public List<Content> getRecentlyAddedEpisodes() {
        return contentRepository.findTop10ByClassOrderByCreatedAtDesc(Episode.class, PageRequest.of(0, 10));
    }

    @Override
    public List<Content> getRecentlyAddedSeasons() {
        return contentRepository.findTop10ByClassOrderByCreatedAtDesc(Season.class, PageRequest.of(0, 10));
    }

    @Override
    public List<Content> getTopMovies() {
        return contentRepository.findTop10ByClassOrderByRatingsDesc(Movie.class, PageRequest.of(0, 10));
    }

    @Override
    public List<Content> getTopTVShows() {
        return contentRepository.findTop10ByClassOrderByRatingsDesc(WebSeries.class, PageRequest.of(0, 10));
    }

    @Override
    public List<Content> findAllByOrderByRatingsDesc() {
        return contentRepository.findAllByOrderByRatingsDesc();
    }
}
