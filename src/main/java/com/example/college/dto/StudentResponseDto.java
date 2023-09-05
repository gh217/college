package com.example.college.dto;

import com.example.college.model.Course;
import com.example.college.model.StudentCourse;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Data
@Component
public class StudentResponseDto extends StudentCommonDto {

    private Set<CourseResponseDto> courseResponseDtos;

}