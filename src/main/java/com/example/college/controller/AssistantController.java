package com.example.college.controller;

import com.example.college.dto.AssistantRequestDto;
import com.example.college.dto.AssistantResponseDto;
import com.example.college.service.AssistantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistant")
public class AssistantController {

    public final AssistantService assistantService;

    public AssistantController(AssistantService assistantService) {
        this.assistantService = assistantService;
    }

    @PostMapping
    public AssistantResponseDto AddAssistant(@Valid @RequestBody AssistantRequestDto assistantRequestDto){
        return assistantService.addAssistant(assistantRequestDto);
    }

    @PutMapping("/{id}")
    public AssistantResponseDto updateAssistant(@PathVariable Long id , @RequestBody AssistantRequestDto assistantRequestDto){
        return assistantService.updateAssistant(id, assistantRequestDto);
    }

    @GetMapping("/{id}")
    public AssistantResponseDto AddAssistant(@PathVariable Long id ){
        return assistantService.findAssistantById(id);
    }


    @GetMapping()
    public List<AssistantResponseDto> findAllAssistant(){
        return assistantService.findAllAssistant();
    }

}
