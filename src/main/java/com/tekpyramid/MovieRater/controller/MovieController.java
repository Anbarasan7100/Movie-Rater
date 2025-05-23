package com.tekpyramid.MovieRater.controller;

import com.tekpyramid.MovieRater.dto.MovieDto;
import com.tekpyramid.MovieRater.dto.MovieLanguageDto;
import com.tekpyramid.MovieRater.dto.TopMovieDto;
import com.tekpyramid.MovieRater.response.ApiResponse;
import com.tekpyramid.MovieRater.service.MovieService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* @RestController Marks this class as a Spring MVC REST controller,
* It handles HTTP requests and returns JSON or other response bodies directly.
* @RequestMapping - Base URL path for all endpoints in this controller
* @RequiredArgsConstructor - Lombok annotation that generates a constructor with required arguments for all final fields*/

@RestController
@RequestMapping("/api/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService; //service dependency to handle business logic

    @PostMapping("/save")
    public ResponseEntity<?> saveMovie(@RequestBody MovieDto movieDto){

        String response = movieService.saveMovieDetail(movieDto);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.ACCEPTED);  //Created
        apiResponse.setMessage("Movie details added successfully");
        apiResponse.setData(response);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apiResponse);
    }

    @GetMapping("/topRated")
    public ResponseEntity<?> getTopRated(){
        TopMovieDto topMovie = movieService.getHighestRatedMovie();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setMessage("Top rated movie fetched successfully");
        apiResponse.setData(topMovie);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/language/{languageName}")
    public ResponseEntity<?> getByLanguage(@PathVariable String languageName){
        List<MovieLanguageDto> movies = movieService.getMoviesByLanguage(languageName);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setMessage("Movies by language fetched successfully");
        apiResponse.setData(movies);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/ratingRange")
    public ResponseEntity<?> getByRatingRange(@RequestParam @Min(0) double minRating, @RequestParam @Max(10) double maxRating){
        List<MovieDto> movies = movieService.getMoviesByRatingRange(minRating, maxRating);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatus(HttpStatus.OK);
        apiResponse.setMessage("Movies by rating range fetched successfully");
        apiResponse.setData(movies);

        return ResponseEntity.ok(apiResponse);
    }



}
