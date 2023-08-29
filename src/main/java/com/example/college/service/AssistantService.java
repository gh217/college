package com.example.college.service;

import com.example.college.dto.AssistantRequest;
import com.example.college.dto.AssistantResponse;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.AssistantMapper;
import com.example.college.model.Assistant;
import com.example.college.repository.AssistantRepo;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssistantService {

    private final AssistantRepo assistantRepo;
    private final AssistantMapper assistantMapper;


    public AssistantService(AssistantRepo assistantRepo, AssistantMapper assistantMapper) {
        this.assistantRepo = assistantRepo;
        this.assistantMapper = assistantMapper;
    }

    public AssistantResponse addAssistant(AssistantRequest assistantRequest){
        Assistant assistant=assistantRepo.save(assistantMapper.toAssistant(assistantRequest));
        return assistantMapper.toAssistantResponse(assistant);
    }

    public AssistantResponse updateAssistant(Long id , AssistantRequest assistantRequest){
        Assistant assistant=checkAssistantById(id);
        assistant.setName(assistantRequest.getName());
        assistant= assistantRepo.save(assistant);

        return assistantMapper.toAssistantResponse(assistant);
    }

    public AssistantResponse findAssistantById(Long id){
        Assistant assistant=checkAssistantById(id);
        return assistantMapper.toAssistantResponse(assistant);
    }

    public List<AssistantResponse> findAllAssistant(){
        List<Assistant>assistants=assistantRepo.findAll();
        if(assistants.isEmpty())throw new NotFoundException("Empty");
        return assistants.stream()
                .map(assistantMapper::toAssistantResponse)
                .toList();
    }

    private Assistant checkAssistantById(Long id){
        Optional<Assistant> assistant=assistantRepo.findById(id);
        if(assistant.isEmpty())throw new NotFoundException("Id "+id+" Not Found");
        return assistant.get();
    }
}
