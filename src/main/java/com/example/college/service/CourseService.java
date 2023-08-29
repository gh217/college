package com.example.college.service;

import com.example.college.dto.CourseRequestDto;
import com.example.college.dto.CourseResponseDto;
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

    public CourseResponseDto addCourse(CourseRequestDto courseRequestDto){

        try {
            Course course=courseRepo.save(courseMapper.toCourse(courseRequestDto));
            return courseMapper.toCourseResponseDto(course);
        }catch (Exception exception){
            throw new DublicateException("this code "+ courseRequestDto.getCode() +" exist");
        }
    }

    public void deleteCourse(Long id){
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty())throw new NotFoundException("this Course ID" + id +"Not found");
        courseRepo.deleteById(id);
    }

    public CourseResponseDto findCourseById(Long id){
        Optional<Course> course=courseRepo.findById(id);
        if(course.isEmpty())throw new NotFoundException("this Course ID "+id+" Not found");
        return courseMapper.toCourseResponseDto(course.get());
    }

    public List<CourseResponseDto> findAllCourse(){
        List<Course>courseList=courseRepo.findAll();
        if(courseList.isEmpty())throw new NotFoundException("No Assistant");
        return courseList
                .stream()
                .map(courseMapper::toCourseResponseDto)
                .toList();
    }

}
