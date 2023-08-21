package com.example.college.service;

import com.example.college.dto.StudentRequest;
import com.example.college.dto.StudentResponse;
import com.example.college.dto.StudentUpdateRequest;
import com.example.college.exceptions.model.NotFound;
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

    public StudentResponse add(StudentRequest studentRequest){
        Student student=studentRepo.save(studentMapper.toStudent(studentRequest));
        return studentMapper.toStudentResponse(student);
    }

    public StudentResponse update(Long id ,StudentUpdateRequest studentUpdateRequest){

        if(id==null)throw new NotFound("id null");
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())throw new NotFound("this id "+id+" not found");

        student.get().setName(studentUpdateRequest.getName());
        student.get().setBirthmonth(studentUpdateRequest.getBirthmonth());
        student.get().setBirthyear(studentUpdateRequest.getBirthyear());
        student.get().setBirthday(studentUpdateRequest.getBirthday());

        student= Optional.of(studentRepo.save(student.get()));

        return studentMapper.toStudentResponse(student.get());
    }

    public StudentResponse findById(long id){
        Optional<Student> student=studentRepo.findById(id);
        if(student.isEmpty())throw new NotFound("This id "+ id+" not found");
        return studentMapper.toStudentResponse(student.get());
    }

    public List<StudentResponse> findAll(){
        return studentRepo.findAll()
                .stream()
                .map(studentMapper::toStudentResponse)
                .toList();
    }
}
