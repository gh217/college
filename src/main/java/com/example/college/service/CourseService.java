package com.example.college.service;

import com.example.college.dto.CourseRequest;
import com.example.college.dto.CourseResponse;
import com.example.college.exceptions.model.DublicateException;
import com.example.college.mapper.CourseMapper;
import com.example.college.model.Course;
import com.example.college.repository.CourseRepo;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    public CourseService(CourseRepo courseRepo, CourseMapper courseMapper) {
        this.courseRepo = courseRepo;
        this.courseMapper = courseMapper;
    }

    public CourseResponse addCourse(CourseRequest courseRequest){

        try {
            Course course=courseRepo.save(courseMapper.toCourse(courseRequest));
            return courseMapper.toCourseResponse(course);
        }catch (Exception exception){
            throw new DublicateException("this code "+ courseRequest.getCode() +" exist");
        }
    }
}
