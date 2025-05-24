package com.tekpyramid.MovieRater.repository;

import com.tekpyramid.MovieRater.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findTopByOrderByImdbRatingDesc();
    List<Movie> findByLanguage_Name(String languageName);
    List<Movie> findByImdbRatingBetween(double startRating, double endRating);
    Optional<Movie> findByTitleAndReleaseYear(String title, int releaseYear);
}
