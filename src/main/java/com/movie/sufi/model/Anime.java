package com.movie.sufi.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@DiscriminatorValue("ANIME")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Anime extends Content {

    private String creator;

    @ElementCollection
    @Column(name = "cast_members")
    private Set<String> cast;

    private int episodes;

    private String language;

    private int releaseYear;

    private String thumbnailUrl;

    private String videoUrl;
}
