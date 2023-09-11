package com.example.college.controller;

import com.example.college.dto.StudentCourseResponseDto;
import com.example.college.service.StudentCourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentCourse")
public class StudentCourseController {
    private final StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping("/{studentId}/{courseId}")
    public void addCourseToStudent(@PathVariable Long studentId ,@PathVariable Long courseId) {
        studentCourseService.addCourse(studentId, courseId);
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public void deleteCourseFromStudent(@PathVariable Long studentId ,@PathVariable Long courseId) {
        studentCourseService.deleteByStudentIdAndCourseId(studentId, courseId);
    }


    @PutMapping("/{studentId}/{courseId}/{degree}")
    public void updateDegree(@PathVariable Long studentId ,@PathVariable Long courseId,
                                            @PathVariable Double degree){
         studentCourseService.updateDegree(studentId,courseId,degree);
    }

    @GetMapping("/{studentId}")
    public List<StudentCourseResponseDto> updateDegree(@PathVariable Long studentId ){
        return studentCourseService.studentCourseList(studentId);
    }



}