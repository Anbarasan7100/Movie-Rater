package com.tekpyramid.MovieRater.dto;


import lombok.*;

import java.util.List;

@Data
public class MovieDto {

        private String title;
        private String industry;
        private int releaseYear;
        private double imdbRating;
        private String studio;

        private LanguageDto languageDto;
        private List<ActorDto> actorDto;
        private FinancialDto financialDto;

    }
