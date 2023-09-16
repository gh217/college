package com.example.college.service;

import com.example.college.dto.ProfessorRequestDto;
import com.example.college.dto.ProfessorResponseDto;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.ProfessorMapper;
import com.example.college.model.Course;
import com.example.college.model.Professor;
import com.example.college.repository.CourseRepo;
import com.example.college.repository.ProfessorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Professor professor=checkProfessorById(id);
        professor.setName(professorRequestDto.getName());
        return professorMapper.professorResponseDto(professorRepo.save(professor));
    }

    public ProfessorResponseDto findProfessorById(Long id){
        Professor professor=checkProfessorById(id);
        return professorMapper.professorResponseDto(professor);
    }

    public List<ProfessorResponseDto> findAllProfessor(){

        List<Professor>professorList=professorRepo.findAll();
        if(professorList.isEmpty())throw new NotFoundException("Professor Not Found");

        return professorList.stream()
                .map(professorMapper::professorResponseDto)
                .toList();
    }

    private Professor checkProfessorById(Long id){
        Optional<Professor> professor=professorRepo.findById(id);
        if(professor.isEmpty())throw new NotFoundException("this id "+id +" Not Found");
        return professor.get();
    }

    public void addCourseToProfessor(Long professorId , Long courseId){
        Optional<Professor> professor=professorRepo.findById(professorId);
        Optional<Course> course=courseRepo.findById(courseId);

        if(professor.isEmpty())throw new NotFoundException("prof id not found");
        if(course.isEmpty())throw new NotFoundException("student id not found");

        professor.get().getCourseList().add(course.get());
        course.get().getProfessorList().add(professor.get());

        professorRepo.save(professor.get());
//        courseRepo.save(course.get());
    }
}
