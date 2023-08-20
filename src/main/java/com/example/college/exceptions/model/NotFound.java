package com.example.college.exceptions.model;

import lombok.Data;
import org.springframework.data.crossstore.ChangeSetPersister;


import java.rmi.NotBoundException;

@Data
public class NotFound extends RuntimeException {

    public NotFound(String message) {
        super(message);
    }
}
