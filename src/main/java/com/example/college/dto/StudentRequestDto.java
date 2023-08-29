package com.example.college.dto;

import lombok.Data;


@Data
public class StudentRequestDto {
    private String name;
    private int birthday;
    private int birthmonth;
    private int birthyear;
}
