package com.example.college.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CourseRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String code;

    @Min(value = 0)
    @Max(value = 100)
    private Double PassedDegree;

    @Min(value = 0)
    @Max(value = 100)
    private Double totalDegree;
}
