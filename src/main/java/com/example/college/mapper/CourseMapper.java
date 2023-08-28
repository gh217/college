package com.example.college.mapper;

import com.example.college.dto.CourseRequest;
import com.example.college.dto.CourseResponse;
import com.example.college.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toCourse(CourseRequest courseRequest){
        Course course=new Course();
        course.setCode(courseRequest.getCode());
        course.setName(courseRequest.getName());
        return course;
    }

    public CourseResponse toCourseResponse(Course course){
        CourseResponse courseResponse=new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCode(course.getCode());
        courseResponse.setName(course.getName());
        return courseResponse;
    }
}
