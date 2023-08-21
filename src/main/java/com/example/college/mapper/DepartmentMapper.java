package com.example.college.mapper;

import com.example.college.dto.DepartmentRequest;
import com.example.college.dto.DepartmentResponse;
import com.example.college.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public Department toDepartment(DepartmentRequest departmentRequest){
        Department department=new Department();
        department.setName(departmentRequest.getName());
        return department;
    }

    public DepartmentResponse toDepartmentResponse(Department department){
        DepartmentResponse departmentResponse=new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setName(department.getName());
        departmentResponse.setCollege(department.getCollege());
        departmentResponse.setProfessorSet(department.getProfessorSet());
        departmentResponse.setAssistantSet(department.getAssistantSet());
        departmentResponse.setCourseSet(department.getCourseSet());
        departmentResponse.setStudentSet(department.getStudentSet());
        return departmentResponse;
    }
}
