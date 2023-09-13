package com.example.college.dto;

import com.example.college.model.Course;
import com.example.college.model.StudentCourseStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class StudentCourseResponseDto {

    private String CourseName ;
    private Long courseId;
    private Double degree;
    private StudentCourseStatus studentCourseStatus;
    private Date StartCourse;
    private Date endCourse;

}
