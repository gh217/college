package com.example.college.mapper;

import com.example.college.dto.CourseRequestDto;
import com.example.college.dto.CourseResponseDto;
import com.example.college.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toCourse(CourseRequestDto courseRequestDto){
        Course course=new Course();
        course.setCode(courseRequestDto.getCode());
        course.setName(courseRequestDto.getName());
        return course;
    }

    public CourseResponseDto toCourseResponseDto(Course course){
        CourseResponseDto courseResponseDto =new CourseResponseDto();
        courseResponseDto.setId(course.getId());
        courseResponseDto.setCode(course.getCode());
        courseResponseDto.setName(course.getName());
        return courseResponseDto;
    }
}
