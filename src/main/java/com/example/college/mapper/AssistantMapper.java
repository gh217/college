package com.example.college.mapper;

import com.example.college.dto.AssistantRequest;
import com.example.college.dto.AssistantResponse;
import com.example.college.model.Assistant;
import org.springframework.stereotype.Component;

@Component
public class AssistantMapper {

    public Assistant toAssistant(AssistantRequest assistantRequest){
        Assistant assistant=new Assistant();
        assistant.setName(assistantRequest.getName());
        return assistant;
    }

    public AssistantResponse toAssistantResponse(Assistant assistant){
        AssistantResponse assistantResponse=new AssistantResponse();
        assistantResponse.setId(assistant.getId());
        assistantResponse.setName(assistant.getName());
        assistantResponse.setCourseSet(assistant.getCourseSet());
        return assistantResponse;
    }
}
