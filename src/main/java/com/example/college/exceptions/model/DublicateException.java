package com.example.college.exceptions.model;

import lombok.Data;

@Data
public class DublicateException extends RuntimeException{
    public DublicateException(String message) {
        super(message);
    }

}
