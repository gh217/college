package com.example.college.service;

import com.example.college.dto.StudentRequestDto;
import com.example.college.dto.StudentResponseDto;
import com.example.college.dto.StudentUpdateRequestDto;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.StudentMapper;
import com.example.college.model.Student;
import com.example.college.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return studentMapper.toStudentResponse(student);
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

        return studentMapper.toStudentResponse(student.get());
    }

    public StudentResponseDto findById(long id){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())throw new NotFoundException("This id "+ id+" not found");
        return studentMapper.toStudentResponse(student.get());
    }

    public List<StudentResponseDto> findAll(){
        return studentRepo.findAll()
                .stream()
                .map(studentMapper::toStudentResponse)
                .toList();
    }
}
