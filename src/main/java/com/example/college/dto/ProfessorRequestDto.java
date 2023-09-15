package com.example.college.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProfessorRequestDto {

    @NotNull
    private String name;

}
