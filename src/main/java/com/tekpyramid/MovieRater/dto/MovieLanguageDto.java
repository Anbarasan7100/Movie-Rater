package com.tekpyramid.MovieRater.dto;

import lombok.Data;

import java.util.List;

@Data
public class MovieLanguageDto {

    private String title;
    private String industry;
    private int releaseYear;
    private double imdbRating;
    private String studio;
    private LanguageDto languageDto;
    private List<ActorDto> actorDto;

}
