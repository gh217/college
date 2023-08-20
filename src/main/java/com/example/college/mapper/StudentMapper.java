package com.example.college.mapper;

import com.example.college.dto.StudentRequest;
import com.example.college.dto.StudentResponse;
import com.example.college.dto.StudentUpdateRequest;
import com.example.college.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toStudent(StudentRequest studentRequest){
        Student student=new Student();
        student.setName(studentRequest.getName());
        student.setBirthday(studentRequest.getBirthday());
        student.setBirthmonth(studentRequest.getBirthmonth());
        student.setBirthyear(studentRequest.getBirthyear());
        return student;
    }

    public StudentResponse toStudentResponse(Student student){
        StudentResponse studentResponse=new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setName(student.getName());
        studentResponse.setBirthday(student.getBirthday());
        studentResponse.setBirthmonth(student.getBirthmonth());
        studentResponse.setBirthyear(student.getBirthyear());
        studentResponse.setDepartment(student.getDepartment());
        studentResponse.setCourseSet(student.getCourseSet());
        return studentResponse;
    }
    public Student toStudent(StudentUpdateRequest studentUpdateRequest){

        Student student=new Student();

        student.setId(studentUpdateRequest.getId());
        student.setName(studentUpdateRequest.getName());
        student.setBirthday(studentUpdateRequest.getBirthday());
        student.setBirthmonth(studentUpdateRequest.getBirthmonth());
        student.setBirthyear(studentUpdateRequest.getBirthyear());
        student.setDepartment(studentUpdateRequest.getDepartment());
        student.setCourseSet(studentUpdateRequest.getCourseSet());
        return student;
    }


}
