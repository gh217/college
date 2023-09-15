package com.example.college.dto;

import com.example.college.model.Course;
import com.example.college.model.Department;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public abstract class AssistantDoctor {

    private Long id;
    @NotNull
    private String name;
    private List<Course> courseList = new ArrayList<>();
    private List<Department> departmentList = new ArrayList<>();
}
