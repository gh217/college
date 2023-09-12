package com.example.college.mapper;

import com.example.college.dto.StudentCourseResponseDto;
import com.example.college.model.StudentCourse;
import org.springframework.stereotype.Component;

@Component
public class StudentCourseMapper {


    private final CourseMapper courseMapper;

    public StudentCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public StudentCourseResponseDto toStudentCourseResponseDto(StudentCourse studentCourse){
        StudentCourseResponseDto studentCourseResponseDto=new StudentCourseResponseDto();

        studentCourseResponseDto.setDegree(studentCourse.getDegree());
        studentCourseResponseDto.setStudentCourseStatus(studentCourse.getStudentCourseStatus());
        studentCourseResponseDto.setCourseName(studentCourse.getCourse().getName());
        studentCourseResponseDto.setCourseId(studentCourse.getCourse().getId());
        return studentCourseResponseDto;
    }
}
