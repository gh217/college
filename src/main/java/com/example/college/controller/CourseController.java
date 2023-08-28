package com.example.college.controller;

import com.example.college.dto.CourseRequest;
import com.example.college.dto.CourseResponse;
import com.example.college.model.Course;
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
    public CourseResponse addCourse(@RequestBody CourseRequest courseRequest){
        return courseService.addCourse(courseRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }

    @GetMapping("/{id}")
    public CourseResponse findCourseById(@PathVariable Long id){
        return courseService.findCourseById(id);
    }

    @GetMapping()
    public List<CourseResponse> findAllCourses(){
        return courseService.findAllCourse();
    }

}
