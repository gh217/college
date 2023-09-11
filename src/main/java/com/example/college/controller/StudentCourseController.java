package com.example.college.controller;

import com.example.college.model.StudentCourse;
import com.example.college.service.StudentCourseService;
import org.springframework.web.bind.annotation.*;

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


}