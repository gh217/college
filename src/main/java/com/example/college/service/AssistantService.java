package com.example.college.service;

import com.example.college.dto.AssistantRequestDto;
import com.example.college.dto.AssistantResponseDto;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.AssistantMapper;
import com.example.college.model.Assistant;
import com.example.college.repository.AssistantRepo;
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

    public AssistantResponseDto addAssistant(AssistantRequestDto assistantRequestDto){
        Assistant assistant=assistantRepo.save(assistantMapper.toAssistant(assistantRequestDto));
        return assistantMapper.toAssistantResponseDto(assistant);
    }

    public AssistantResponseDto updateAssistant(Long id , AssistantRequestDto assistantRequestDto){
        Assistant assistant=checkAssistantById(id);
        assistant.setName(assistantRequestDto.getName());
        assistant= assistantRepo.save(assistant);

        return assistantMapper.toAssistantResponseDto(assistant);
    }

    public AssistantResponseDto findAssistantById(Long id){
        Assistant assistant=checkAssistantById(id);
        return assistantMapper.toAssistantResponseDto(assistant);
    }

    public List<AssistantResponseDto> findAllAssistant(){
        List<Assistant>assistants=assistantRepo.findAll();
        if(assistants.isEmpty())throw new NotFoundException("Empty");
        return assistants.stream()
                .map(assistantMapper::toAssistantResponseDto)
                .toList();
    }

    private Assistant checkAssistantById(Long id){
        Optional<Assistant> assistant=assistantRepo.findById(id);
        if(assistant.isEmpty())throw new NotFoundException("Id "+id+" Not Found");
        return assistant.get();
    }
}
