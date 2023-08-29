package com.example.college.controller;

import com.example.college.dto.AssistantRequest;
import com.example.college.dto.AssistantResponse;
import com.example.college.service.AssistantService;
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
    public AssistantResponse AddAssistant(@RequestBody AssistantRequest assistantRequest){
        return assistantService.addAssistant(assistantRequest);
    }

    @PutMapping("/{id}")
    public AssistantResponse AddAssistant(@PathVariable Long id ,@RequestBody AssistantRequest assistantRequest){
        return assistantService.updateAssistant(id,assistantRequest);
    }

    @GetMapping("/{id}")
    public AssistantResponse AddAssistant(@PathVariable Long id ){
        return assistantService.findAssistantById(id);
    }


    @GetMapping()
    public List<AssistantResponse> findAllAssistant(){
        return assistantService.findAllAssistant();
    }

}
