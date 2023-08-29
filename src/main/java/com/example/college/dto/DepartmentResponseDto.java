package com.example.college.dto;

import com.example.college.model.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class DepartmentResponseDto {
    private Long id;
    private String name;
    private College college;
    private Set<Professor> professorSet=new HashSet<>();
    private Set<Assistant> assistantSet =new HashSet<>();
    private Set<Course> courseSet=new HashSet<>();
    private Set<Student> studentSet=new HashSet<>();
}
