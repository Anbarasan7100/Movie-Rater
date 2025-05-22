package com.tekpyramid.MovieRater.dto;

import lombok.Data;

@Data
public class TopMovieDto {
    private String title;
    private String industry;
    private int releaseYear;
    private double imdbRating;
    private String studio;

}
