package com.example.college.controller;

import com.example.college.dto.StudentCourseResponseDto;
import com.example.college.service.StudentCourseService;
import jakarta.validation.Valid;
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
    public void addCourseToStudent(@Valid  @PathVariable Long studentId , @PathVariable Long courseId) {
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
    public List<StudentCourseResponseDto> findStudentCourse(@PathVariable Long studentId ){
        return studentCourseService.studentCourseList(studentId);
    }

    @PutMapping
    public List<StudentCourseResponseDto> updateStatus(){
        return studentCourseService.updateStatus();
    }

    @GetMapping("/pending/{studentId}")
    public List<StudentCourseResponseDto> studentCoursePending(@PathVariable Long studentId){
        return studentCourseService.studentCourseResponsePending(studentId);
    }

    @GetMapping("/succeed/{studentId}")
    public List<StudentCourseResponseDto> studentCourseSucceed(@PathVariable Long studentId){
        return studentCourseService.studentCourseResponseSucceed(studentId);
    }

    @GetMapping("/failed/{studentId}")
    public List<StudentCourseResponseDto> studentCourseFailed(@PathVariable Long studentId){
        return studentCourseService.studentCourseResponseFailed(studentId);
    }

}