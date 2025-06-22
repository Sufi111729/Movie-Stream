package com.movie.sufi.model;

import java.util.Set;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Movie.class, name = "movie")
    // Add other subtypes here if needed
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "content_type")
@Getter
@Setter
public abstract class Content {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean featured;

    private int releaseYear;

    @ElementCollection
    private Set<String> genres;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "content")
    private List<Rating> ratings;
}
