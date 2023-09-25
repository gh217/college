package com.example.college.dto;

import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CollegeResponseDto {

    private Long id;
    private String name;
    private List<DepartmentResponseDto>departmentResponseDtoList=new ArrayList<>();
}
