package com.example.college.dto;

import com.example.college.model.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class DepartmentResponseDto {
    private Long id;
    private String name;
    private College college;
    private List<Professor> professorList=new ArrayList<>();
    private List<Assistant> assistantList =new ArrayList<>();
    private List<Course> courseList=new ArrayList<>();
    private List<Student> studentList=new ArrayList<>();
}
