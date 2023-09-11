package com.example.college.exceptions.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CoursePendingLimitedException extends RuntimeException{
    public CoursePendingLimitedException(String message) {
        super(message);
    }
}
