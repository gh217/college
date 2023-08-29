package com.example.college.mapper;

import com.example.college.dto.ProfessorRequestDto;
import com.example.college.dto.ProfessorResponseDto;
import com.example.college.model.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper {

    public Professor toProfessor(ProfessorRequestDto professorRequestDto){
        Professor professor=new Professor();
        professor.setName(professorRequestDto.getName());
        return professor;
    }

    public ProfessorResponseDto professorResponseDto(Professor professor){
        ProfessorResponseDto assistantResponse =new ProfessorResponseDto();
        assistantResponse.setId(professor.getId());
        assistantResponse.setName(professor.getName());
        assistantResponse.setCourseSet(professor.getCourseSet());
        return assistantResponse;
    }

}
