package com.example.college.service;

import com.example.college.dto.CourseRequest;
import com.example.college.dto.CourseResponse;
import com.example.college.exceptions.model.DublicateException;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.CourseMapper;
import com.example.college.model.Course;
import com.example.college.repository.CourseRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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

    public void deleteCourse(Long id){
        log.info(id+" "+"deleteCourse");
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty())throw new NotFoundException("this Course ID" + id +"Not found");
        courseRepo.deleteById(id);
    }

    public CourseResponse findCourseById(Long id){
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty())throw new NotFoundException("this Course ID "+id+" Not found");
        return courseMapper.toCourseResponse(course.get());
    }

    public List<CourseResponse> findAllCourse(){
        List<Course>courseList=courseRepo.findAll();
        if(courseList.isEmpty())throw new NotFoundException("No Course");
        return courseList
                .stream()
                .map(courseMapper::toCourseResponse)
                .toList();
    }

}
