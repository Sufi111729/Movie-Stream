// ViewHistory.java
package com.movie.sufi.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class ViewHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
