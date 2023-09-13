package com.example.college.mapper;

import com.example.college.dto.StudentCourseResponseDto;
import com.example.college.model.StudentCourse;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StudentCourseMapper {


    public StudentCourseResponseDto toStudentCourseResponseDto(StudentCourse studentCourse){
        StudentCourseResponseDto studentCourseResponseDto=new StudentCourseResponseDto();

        studentCourseResponseDto.setDegree(studentCourse.getDegree());
        studentCourseResponseDto.setStudentCourseStatus(studentCourse.getStudentCourseStatus());
        studentCourseResponseDto.setCourseName(studentCourse.getCourse().getName());
        studentCourseResponseDto.setCourseId(studentCourse.getCourse().getId());
        studentCourseResponseDto.setStartCourse(studentCourse.getStartCourse());
        studentCourseResponseDto.setEndCourse(studentCourse.getEndCourse());
        return studentCourseResponseDto;
    }

//    private String dateFormat(Date date){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return dateFormat.format(date);
//    }
}
