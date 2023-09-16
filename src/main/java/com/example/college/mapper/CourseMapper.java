package com.example.college.mapper;

import com.example.college.dto.CourseRequestDto;
import com.example.college.dto.CourseResponseDto;
import com.example.college.model.Course;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseMapper {

    private final ProfessorMapper professorMapper;

    public CourseMapper(ProfessorMapper professorMapper) {
        this.professorMapper = professorMapper;
    }

    public Course toCourse(CourseRequestDto courseRequestDto){
        Course course=new Course();
        course.setCode(courseRequestDto.getCode());
        course.setName(courseRequestDto.getName());
        course.setPassedDegree(course.getPassedDegree());
        course.setTotalDegree(course.getTotalDegree());
        return course;
    }

    public CourseResponseDto toCourseResponseDto(Course course){
        CourseResponseDto courseResponseDto =new CourseResponseDto();
        courseResponseDto.setId(course.getId());
        courseResponseDto.setCode(course.getCode());
        courseResponseDto.setName(course.getName());
        courseResponseDto.setPassedDegree(course.getPassedDegree());
        courseResponseDto.setTotalDegree(course.getTotalDegree());

        courseResponseDto.setProfessorResponseDtos(course.getProfessorList()
                .stream()
                .map(professorMapper::professorResponseDto)
                .collect(Collectors.toList())
        );
        return courseResponseDto;
    }

}
