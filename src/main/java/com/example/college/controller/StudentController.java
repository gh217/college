package com.example.college.controller;

import com.example.college.dto.StudentRequestDto;
import com.example.college.dto.StudentResponseDto;
import com.example.college.dto.StudentUpdateRequestDto;
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
    public StudentResponseDto add(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.add(studentRequestDto);
    }

    @PutMapping("/{id}")
    public StudentResponseDto update(@PathVariable Long id, @RequestBody StudentUpdateRequestDto studentUpdateRequest){
        return studentService.update(id,studentUpdateRequest);
    }

    @GetMapping("/{id}")
    public StudentResponseDto findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping
    public List<StudentResponseDto> findAll(){
       return studentService.findAll();
    }

}
