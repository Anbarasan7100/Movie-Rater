package com.tekpyramid.MovieRater.service;

import com.tekpyramid.MovieRater.dto.MovieDto;
import com.tekpyramid.MovieRater.dto.MovieLanguageDto;
import com.tekpyramid.MovieRater.dto.TopMovieDto;
import com.tekpyramid.MovieRater.entity.Movie;

import java.util.List;

public interface MovieService {

    String saveMovieDetail(MovieDto movieDto);
    TopMovieDto getHighestRatedMovie();
    List<MovieLanguageDto> getMoviesByLanguage(String languageName);
    List<MovieDto> getMoviesByRatingRange(double minRating, double maxRating);

}
