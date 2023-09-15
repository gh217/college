package com.example.college.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class StudentRequestDto {

    @NotNull
    private String name;
    @NotNull
    private int birthday;
    @NotNull
    private int birthmonth;
    @NotNull
    private int birthyear;
}
