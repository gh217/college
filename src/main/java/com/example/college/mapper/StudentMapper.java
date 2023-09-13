package com.example.college.mapper;

import com.example.college.dto.StudentRequestDto;
import com.example.college.dto.StudentResponseDto;
import com.example.college.dto.StudentUpdateRequestDto;
import com.example.college.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@Slf4j
public class StudentMapper {


    private final StudentCourseMapper studentCourseMapper;

    public StudentMapper(StudentCourseMapper studentCourseMapper) {
        this.studentCourseMapper = studentCourseMapper;
    }

    public Student toStudent(StudentRequestDto studentRequestDto){
        Student student=new Student();
        student.setName(studentRequestDto.getName());
        student.setBirthday(studentRequestDto.getBirthday());
        student.setBirthmonth(studentRequestDto.getBirthmonth());
        student.setBirthyear(studentRequestDto.getBirthyear());
        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student){
        StudentResponseDto studentResponse=new StudentResponseDto();
        studentResponse.setId(student.getId());
        studentResponse.setName(student.getName());
        studentResponse.setBirthday(student.getBirthday());
        studentResponse.setBirthmonth(student.getBirthmonth());
        studentResponse.setBirthyear(student.getBirthyear());

        studentResponse.setDepartment(student.getDepartment());

        studentResponse.setStudentCourseResponseDtoList(student.getStudentCourseList()
                .stream()
                .map(studentCourseMapper::toStudentCourseResponseDto)
                .collect(Collectors.toList()));

        return studentResponse;
    }
    public Student toStudent(StudentUpdateRequestDto studentUpdateRequest){

        Student student=new Student();

        student.setId(studentUpdateRequest.getId());
        student.setName(studentUpdateRequest.getName());
        student.setBirthday(studentUpdateRequest.getBirthday());
        student.setBirthmonth(studentUpdateRequest.getBirthmonth());
        student.setBirthyear(studentUpdateRequest.getBirthyear());
        student.setDepartment(studentUpdateRequest.getDepartment());
        return student;
    }


}
