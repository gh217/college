package com.example.college.dto;

import com.example.college.model.Course;
import com.example.college.model.Department;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
public abstract class StudentCommonDto {
    private long id;
    private String name;
    private int birthday;
    private int birthmonth;
    private int birthyear;
    private Department department;
//    private Set<Course> courseSet = new HashSet<>();
}
