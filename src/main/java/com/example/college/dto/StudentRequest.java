package com.example.college.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;


@Data
public class StudentRequest {
    private String name;
    private int birthday;
    private int birthmonth;
    private int birthyear;
}
