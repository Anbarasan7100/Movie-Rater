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
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;

    @NotBlank(message = "Enter Actor name")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Enter the Birth year")
    @Column(nullable = false)
    private int birthYear;

    @ManyToMany(mappedBy = "actorList", cascade = CascadeType.PERSIST)
    private List<Movie> movieList;

}
