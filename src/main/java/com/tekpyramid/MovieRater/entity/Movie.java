package com.tekpyramid.MovieRater.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @NotBlank(message = "Enter the Movie title")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "Enter the Industry")
    @Column(nullable = false)
    private String industry;

    @NotNull(message = "Enter the movie release year")
    @Column(nullable = false)
    private int releaseYear;

    @NotNull(message = "Enter the IMDB rating")
    @Column(nullable = false)
    private double imdbRating;

    @NotBlank(message = "Enter the production studio")
    @Column(nullable = false)
    private String studio;


    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToMany
    @JoinTable(name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actorList;

    @OneToOne(mappedBy = "movie", cascade = CascadeType.ALL)
    private Financial financial;


}
