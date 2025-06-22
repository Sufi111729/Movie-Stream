package com.movie.sufi.model.Season;

import com.movie.sufi.model.Content;
import jakarta.persistence.Entity;

@Entity
public class Season extends Content {
    private int seasonNumber;

    public Season() {
        // Default constructor
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
}
