package com.example.college.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartmentRequestDto {
    @NotNull
    private String name;
}
