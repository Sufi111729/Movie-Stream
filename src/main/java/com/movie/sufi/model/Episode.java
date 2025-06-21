// Episode.java
package com.movie.sufi.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
