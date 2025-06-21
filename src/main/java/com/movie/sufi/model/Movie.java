package com.movie.sufi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String hlsPath;
    private String thumbnailUrl;
    private String posterUrl;
    private String trailerUrl;

    @ElementCollection
    private List<String> genres;

    private String category;
    private String maturityRating;
    private Integer releaseYear;
    private LocalDate addedDate;
    private Integer durationMinutes;
    private String director;

    @ElementCollection
    private List<String> cast;

    private Double imdbRating;
    private Boolean isFeatured;
    private Boolean isTrending;
    private Boolean isOriginal;
    private String language;
    private String country;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Episode> episodes;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<ViewHistory> viewHistory;
}
