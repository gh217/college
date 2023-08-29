package com.example.college.dto;

import com.example.college.model.Course;
import com.example.college.model.Department;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public abstract class AssistantDoctor {

    private Long id;
    private String name;
    private Set<Course> courseSet = new HashSet<>();
    private Set<Department> departmentSet = new HashSet<>();
}
