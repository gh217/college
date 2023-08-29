package com.example.college.controller;

import com.example.college.dto.CourseRequestDto;
import com.example.college.dto.CourseResponseDto;
import com.example.college.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponseDto addCourse(@RequestBody CourseRequestDto courseRequestDto){
        return courseService.addCourse(courseRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

    @GetMapping("/{id}")
    public CourseResponseDto findCourseById(@PathVariable Long id){
        return courseService.findCourseById(id);
    }

    @GetMapping()
    public List<CourseResponseDto> findAllCourses(){
        return courseService.findAllCourse();
    }

}
