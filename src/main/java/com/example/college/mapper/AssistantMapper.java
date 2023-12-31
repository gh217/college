package com.example.college.mapper;

import com.example.college.dto.AssistantRequestDto;
import com.example.college.dto.AssistantResponseDto;
import com.example.college.model.Assistant;
import org.springframework.stereotype.Component;

@Component
public class AssistantMapper {

    public Assistant toAssistant(AssistantRequestDto assistantRequestDto){
        Assistant assistant=new Assistant();
        assistant.setName(assistantRequestDto.getName());
        return assistant;
    }

    public AssistantResponseDto toAssistantResponseDto(Assistant assistant){
        AssistantResponseDto assistantResponseDto =new AssistantResponseDto();
        assistantResponseDto.setId(assistant.getId());
        assistantResponseDto.setName(assistant.getName());
        assistantResponseDto.setCourseList(assistant.getCourseList());
        return assistantResponseDto;
    }
}
