// File: src/main/java/com/movie/sufi/model/WebSeries.java
package com.movie.sufi.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@DiscriminatorValue("WEBSERIES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WebSeries extends Content {

    private String creator;

    @ElementCollection
    @Column(name = "cast_members")
    private Set<String> cast;

    private int seasons;

    private int episodes;

    private String language;

    private int releaseYear;

    private String thumbnailUrl;

    private String videoUrl;
}
