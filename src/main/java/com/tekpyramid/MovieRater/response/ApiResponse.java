package com.tekpyramid.MovieRater.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiResponse {

    private String message;
    private HttpStatus status;
    private Object data;

}
