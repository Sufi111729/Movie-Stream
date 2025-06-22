package com.movie.sufi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int score;

    private String review;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Content content;
}
