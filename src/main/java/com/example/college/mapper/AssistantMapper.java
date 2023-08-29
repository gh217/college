package com.example.college.mapper;

import com.example.college.dto.AssistantRequestDto;
import com.example.college.dto.AssistantResponse;
import com.example.college.model.Assistant;
import org.springframework.stereotype.Component;

@Component
public class AssistantMapper {

    public Assistant toAssistant(AssistantRequestDto assistantRequestDto){
        Assistant assistant=new Assistant();
        assistant.setName(assistantRequestDto.getName());
        return assistant;
    }

    public AssistantResponse toAssistantResponse(Assistant assistant){
        AssistantResponse assistantResponseDto =new AssistantResponse();
        assistantResponseDto.setId(assistant.getId());
        assistantResponseDto.setName(assistant.getName());
        assistantResponseDto.setCourseSet(assistant.getCourseSet());
        return assistantResponseDto;
    }
}
