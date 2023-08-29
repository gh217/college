package com.example.college.service;

import com.example.college.dto.ProfessorRequestDto;
import com.example.college.dto.ProfessorResponseDto;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.ProfessorMapper;
import com.example.college.model.Professor;
import com.example.college.repository.ProfessorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    private final ProfessorRepo professorRepo;
    private final ProfessorMapper professorMapper;

    public ProfessorService(ProfessorRepo professorRepo, ProfessorMapper professorMapper) {
        this.professorRepo = professorRepo;
        this.professorMapper = professorMapper;
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
}
