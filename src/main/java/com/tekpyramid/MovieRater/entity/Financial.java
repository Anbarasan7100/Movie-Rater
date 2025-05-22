package com.tekpyramid.MovieRater.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Financial {

    @Id
    @Column(name = "movie_id")
    private int movieId;

    @NotNull(message = "Enter the budget")
    @Column(nullable = false)
    private double budget;

    @NotNull(message = "Enter the revenue")
    @Column(nullable = false)
    private double revenue;

    @NotBlank(message = "Enter the price unit")
    @Column(nullable = false)
    private String unit;

    @NotBlank(message = "Enter the currency type")
    @Column(nullable = false)
    private String currency;

    @OneToOne
    @MapsId   //Tells JPA to use the same ID as the Movie entity. This makes movie_id both a primary key and a foreign key.
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
}
