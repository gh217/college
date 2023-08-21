package com.example.college.controller;

import com.example.college.dto.StudentRequest;
import com.example.college.dto.StudentResponse;
import com.example.college.dto.StudentUpdateRequest;
import com.example.college.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController( StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentResponse add( @RequestBody StudentRequest studentRequest){
        return studentService.add(studentRequest);
    }

    @PutMapping("/{id}")
    public StudentResponse update(@PathVariable Long id, @RequestBody StudentUpdateRequest studentUpdateRequest){
        return studentService.update(id,studentUpdateRequest);
    }

    @GetMapping("/{id}")
    public StudentResponse findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping
    public List<StudentResponse> findAll(){
       return studentService.findAll();
    }

}
