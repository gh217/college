package com.example.college.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class AssistantRequestDto {

    @NotNull
    private String name;
}
