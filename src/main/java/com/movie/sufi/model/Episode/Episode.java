package com.movie.sufi.model.Episode;

import com.movie.sufi.model.Content;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Episode extends Content {
    private int episodeNumber;
    private int seasonNumber;

    public Episode() {
        // Default constructor
    }
}
