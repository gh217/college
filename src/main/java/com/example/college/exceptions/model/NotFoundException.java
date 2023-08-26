package com.example.college.exceptions.model;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
