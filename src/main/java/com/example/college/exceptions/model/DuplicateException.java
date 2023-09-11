package com.example.college.exceptions.model;

import lombok.Data;

@Data
public class DuplicateException extends RuntimeException{
    public DuplicateException(String message) {
        super(message);
    }

}
