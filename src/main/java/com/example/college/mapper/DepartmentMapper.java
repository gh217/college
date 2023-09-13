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

    public DepartmentResponseDto toDepartmentResponseDto(Department department){
        DepartmentResponseDto departmentResponseDto =new DepartmentResponseDto();
        departmentResponseDto.setId(department.getId());
        departmentResponseDto.setName(department.getName());
        departmentResponseDto.setCollege(department.getCollege());
        departmentResponseDto.setProfessorList(department.getProfessorList());
        departmentResponseDto.setAssistantList(department.getAssistantList());
        departmentResponseDto.setCourseList(department.getCourseList());
        departmentResponseDto.setStudentList(department.getStudentList());
        return departmentResponseDto;
    }
}
