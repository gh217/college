package com.example.college.service;

import com.example.college.dto.ProfessorRequestDto;
import com.example.college.dto.ProfessorResponseDto;
import com.example.college.exceptions.model.DuplicateException;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.ProfessorMapper;
import com.example.college.model.Course;
import com.example.college.model.Professor;
import com.example.college.repository.CourseRepo;
import com.example.college.repository.ProfessorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProfessorService {
    private final ProfessorRepo professorRepo;
    private final ProfessorMapper professorMapper;
    private final CourseRepo courseRepo;


    public ProfessorService(ProfessorRepo professorRepo, ProfessorMapper professorMapper, CourseRepo courseRepo) {
        this.professorRepo = professorRepo;
        this.professorMapper = professorMapper;
        this.courseRepo = courseRepo;
    }


    public ProfessorResponseDto addProfessor(ProfessorRequestDto professorRequestDto){
        Professor professor=professorRepo.save(professorMapper.toProfessor(professorRequestDto));
        return professorMapper.professorResponseDto(professorRepo.save(professor));
    }

    public ProfessorResponseDto updateProfessor(Long id , ProfessorRequestDto professorRequestDto){
        Professor professor=professorById(id);
        professor.setName(professorRequestDto.getName());
        return professorMapper.professorResponseDto(professorRepo.save(professor));
    }

    public ProfessorResponseDto findProfessorById(Long id){
        Professor professor=professorById(id);
        return professorMapper.professorResponseDto(professor);
    }

    public List<ProfessorResponseDto> findAllProfessor(){

        List<Professor>professorList=professorRepo.findAll();
        if(professorList.isEmpty())throw new NotFoundException("Professor Not Found");

        return professorList.stream()
                .map(professorMapper::professorResponseDto)
                .toList();
    }


    //start relation

    public void addCourseToProfessor(Long professorId , Long courseId){
        Professor professor=professorById(professorId);
        Course course=courseById(courseId);

        if(professor.getCourseList().contains(course))
            throw new DuplicateException("this course already exist");

        professor.getCourseList().add(course);
        course.getProfessorList().add(professor);

        professorRepo.save(professor);
        courseRepo.save(course);
    }

    public void deleteCourseToProfessor(Long professorId , Long courseId){
        Professor professor=professorById(professorId);
        Course course=courseById(courseId);

        if(!professor.getCourseList().contains(course))
            throw new NotFoundException("this course Not Register");

        professor.getCourseList().remove(course);
        course.getProfessorList().remove(professor);

        professorRepo.save(professor);
        courseRepo.save(course);
    }


    private  Professor professorById(Long professorId){
        Optional<Professor> professor=professorRepo.findById(professorId);
        if(professor.isEmpty())throw new NotFoundException("prof id not found");
        return professor.get();
    }

    private  Course courseById(Long courseId){
        Optional<Course> course=courseRepo.findById(courseId);
        if(course.isEmpty())throw new NotFoundException("course id not found");
        return course.get();
    }


}
