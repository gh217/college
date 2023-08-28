package com.example.college.controller;

import com.example.college.dto.CourseRequest;
import com.example.college.dto.CourseResponse;
import com.example.college.service.CourseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponse addCourse(@RequestBody CourseRequest courseRequest){
        return courseService.addCourse(courseRequest);
    }
    
}
