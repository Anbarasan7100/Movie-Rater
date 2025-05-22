package com.tekpyramid.MovieRater.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languageId;

    @NotBlank(message = "Enter the Name of the Language")
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
    private List<Movie> movieList;

}
