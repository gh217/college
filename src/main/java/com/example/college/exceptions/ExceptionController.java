package com.example.college.exceptions;

import com.example.college.exceptions.model.*;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
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
    public ResponseEntity<ErrorResponseApiException>dublicate(DuplicateException duplicateException){
        ErrorResponseApiException errorResponseApiException =new ErrorResponseApiException();
        errorResponseApiException.setError(duplicateException.getMessage());
        return new ResponseEntity<>(errorResponseApiException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<String> stringResponseEntity(DataIntegrityViolationException exception){
        return new ResponseEntity<>("duplicate Data", HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponseApiException>courseLimited(CoursePendingLimitedException coursePendingLimitedException){
        ErrorResponseApiException errorResponseApiException =new ErrorResponseApiException();
        errorResponseApiException.setError(coursePendingLimitedException.getMessage());
        return new ResponseEntity<>(errorResponseApiException, HttpStatus.BANDWIDTH_LIMIT_EXCEEDED);
    }

    //ConstraintViolationException

    @ExceptionHandler
    public ResponseEntity<ErrorResponseApiException>validation(ConstraintViolationException exception){

        ErrorResponseApiException errorResponseApiException=new ErrorResponseApiException();
        errorResponseApiException.setError(exception.getMessage());
        return new ResponseEntity<>(errorResponseApiException,HttpStatus.BAD_REQUEST);
    }

    //BadRequestException

    @ExceptionHandler
    public ResponseEntity<ErrorResponseApiException>badRequest(BadRequestException exception){

        ErrorResponseApiException errorResponseApiException=new ErrorResponseApiException();
        errorResponseApiException.setError(exception.getMessage());
        return new ResponseEntity<>(errorResponseApiException,HttpStatus.BAD_REQUEST);
    }

}
