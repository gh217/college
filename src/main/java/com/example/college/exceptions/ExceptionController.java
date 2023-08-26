package com.example.college.exceptions;

import com.example.college.exceptions.model.DublicateException;
import com.example.college.exceptions.model.ErrorResponseApiException;
import com.example.college.exceptions.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseApiException>notFound(NotFoundException notFoundException){
        ErrorResponseApiException errorResponseApiException =new ErrorResponseApiException();
        errorResponseApiException.setError(notFoundException.getMessage());
        return new ResponseEntity<>(errorResponseApiException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponseApiException>dublicate(DublicateException dublicateException){
        ErrorResponseApiException errorResponseApiException =new ErrorResponseApiException();
        errorResponseApiException.setError(dublicateException.getMessage());
        return new ResponseEntity<>(errorResponseApiException, HttpStatus.NOT_FOUND);
    }
}
