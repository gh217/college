package com.example.college.mapper;

import com.example.college.dto.DepartmentRequestDto;
import com.example.college.dto.DepartmentResponseDto;
import com.example.college.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public Department toDepartment(DepartmentRequestDto departmentRequestDto){
        Department department=new Department();
        department.setName(departmentRequestDto.getName());
        return department;
    }

    public DepartmentResponseDto toDepartmentResponse(Department department){
        DepartmentResponseDto departmentResponseDto =new DepartmentResponseDto();
        departmentResponseDto.setId(department.getId());
        departmentResponseDto.setName(department.getName());
        departmentResponseDto.setCollege(department.getCollege());
        departmentResponseDto.setProfessorSet(department.getProfessorSet());
        departmentResponseDto.setAssistantSet(department.getAssistantSet());
        departmentResponseDto.setCourseSet(department.getCourseSet());
        departmentResponseDto.setStudentSet(department.getStudentSet());
        return departmentResponseDto;
    }
}
