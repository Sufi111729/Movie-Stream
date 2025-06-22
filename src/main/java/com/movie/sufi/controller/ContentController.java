package com.movie.sufi.controller;

import com.movie.sufi.model.Content;
import com.movie.sufi.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping
    public Content addContent(@RequestBody Content content) {
        return contentService.saveContent(content);
    }

    @GetMapping("/featured")
    public List<Content> getFeaturedTitles() {
        return contentService.getFeaturedTitles();
    }

    @GetMapping("/movies")
    public List<Content> getAllMovies() {
        return contentService.getAllMovies();
    }

    @GetMapping("/webseries")
    public List<Content> getAllWebSeries() {
        return contentService.getAllWebSeries();
    }

    @GetMapping("/recent/seasons")
    public List<Content> getRecentlyAddedSeasons() {
        return contentService.getRecentlyAddedSeasons();
    }

    @GetMapping("/recent/episodes")
    public List<Content> getRecentlyAddedEpisodes() {
        return contentService.getRecentlyAddedEpisodes();
    }

    @GetMapping("/top/movies")
    public List<Content> getTopMovies() {
        return contentService.getTopMovies();
    }

    @GetMapping("/top/tvshows")
    public List<Content> getTopTVShows() {
        return contentService.getTopTVShows();
    }

    @GetMapping
    public List<Content> getAllContent() {
        return contentService.getAllContent();
    }

    @GetMapping("/{id}")
    public Optional<Content> getContentById(@PathVariable Long id) {
        return contentService.getContentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Long id) {
        contentService.deleteContent(id);
    }

    @GetMapping("/search")
    public List<Content> searchByTitle(@RequestParam String title) {
        return contentService.findByTitle(title);
    }

    @GetMapping("/genre")
    public List<Content> filterByGenre(@RequestParam String genre) {
        return contentService.findByGenre(genre);
    }

    @GetMapping("/releasedAfter")
    public List<Content> filterByReleaseYear(@RequestParam int year) {
        return contentService.findByReleaseYearGreaterThan(year);
    }

    @GetMapping("/sort/rating")
    public List<Content> sortByRatingDesc() {
        return contentService.getAllOrderByRatingsDesc();
    }

    @GetMapping("/sort/releaseYear")
    public List<Content> sortByReleaseYearDesc() {
        return contentService.getAllOrderByReleaseYearDesc();
    }
}
