package com.example.college.controller;


import com.example.college.dto.ProfessorRequestDto;
import com.example.college.dto.ProfessorResponseDto;
import com.example.college.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("professor")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }


    @PostMapping
    public ProfessorResponseDto AddProfessor(@RequestBody ProfessorRequestDto professorRequestDto){
        return professorService.addProfessor(professorRequestDto);
    }

    @PutMapping("/{id}")
    public ProfessorResponseDto updateProfessor(@PathVariable Long id , @RequestBody ProfessorRequestDto professorRequestDto){
        return professorService.updateProfessor(id, professorRequestDto);
    }

    @GetMapping("/{id}")
    public ProfessorResponseDto AddAssistant(@PathVariable Long id ){
        return professorService.findProfessorById(id);
    }


    @GetMapping()
    public List<ProfessorResponseDto> findAllAssistant(){
        return professorService.findAllProfessor();
    }

}