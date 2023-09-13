package com.example.college.dto;

import com.example.college.model.Department;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CourseResponseDto {
    private Long id;
    private String code;
    private String name;
    private Double PassedDegree;
    private Double totalDegree;
    private List<Department> departmentList=new ArrayList<>();
}
