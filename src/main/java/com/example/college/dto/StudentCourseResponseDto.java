package com.example.college.dto;

import com.example.college.model.Course;
import com.example.college.model.StudentCourseStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentCourseResponseDto {

    private String CourseName ;
    private Long courseId;
    private Double degree;
    StudentCourseStatus studentCourseStatus;
}
