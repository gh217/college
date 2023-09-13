package com.example.college.service;

import com.example.college.dto.StudentCourseResponseDto;
import com.example.college.dto.StudentRequestDto;
import com.example.college.dto.StudentResponseDto;
import com.example.college.dto.StudentUpdateRequestDto;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.StudentMapper;
import com.example.college.model.Student;
import com.example.college.model.StudentCourse;
import com.example.college.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepo studentRepo, StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto add(StudentRequestDto studentRequestDto){
        Student student=studentRepo.save(studentMapper.toStudent(studentRequestDto));
        return studentMapper.toStudentResponseDto(student);
    }

    public StudentResponseDto update(Long id , StudentUpdateRequestDto studentUpdateRequest){

        if(id==null)throw new NotFoundException("id null");
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())throw new NotFoundException("this id "+id+" not found");

        student.get().setName(studentUpdateRequest.getName());
        student.get().setBirthmonth(studentUpdateRequest.getBirthmonth());
        student.get().setBirthyear(studentUpdateRequest.getBirthyear());
        student.get().setBirthday(studentUpdateRequest.getBirthday());
//        student.get().setDepartment(studentUpdateRequest.getDepartment());

        student= Optional.of(studentRepo.save(student.get()));

        return studentMapper.toStudentResponseDto(student.get());
    }

//    public StudentResponseDto findById(long id){
//        Optional<Student> student=studentRepo.findById(id);
//        if(student.isEmpty())throw new NotFoundException("This id "+ id+" not found");
//        return studentMapper.toStudentResponseDto(student.get());
//    }

    public StudentResponseDto findById(long id){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())throw new NotFoundException("This id "+ id+" not found");

        StudentResponseDto studentResponseDto= studentMapper.toStudentResponseDto(student.get());

        List<StudentCourseResponseDto>studentCourseResponseDtoList=
        studentResponseDto.
                getStudentCourseResponseDtoList()
                .stream()
                .sorted(Comparator.comparing(StudentCourseResponseDto::getStartCourse))
                .toList();

        for (StudentCourseResponseDto studentCourseResponseDto1 : studentCourseResponseDtoList){
            log.info(studentCourseResponseDto1.getCourseId()+"  \n");
        }

        studentResponseDto.setStudentCourseResponseDtoList(studentCourseResponseDtoList);
        return studentResponseDto;
    }

    public List<StudentResponseDto> findAll(){
        return studentRepo.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .toList();
    }
}
