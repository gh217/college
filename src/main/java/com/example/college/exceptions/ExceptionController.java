package com.example.college.exceptions;

import com.example.college.exceptions.model.ErrorResponseApi;
import com.example.college.exceptions.model.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseApi>notFound(NotFound notFound){
        ErrorResponseApi errorResponseApi =new ErrorResponseApi();
        errorResponseApi.setError(notFound.getMessage());
        return new ResponseEntity<>(errorResponseApi, HttpStatus.NOT_FOUND);
    }
}
