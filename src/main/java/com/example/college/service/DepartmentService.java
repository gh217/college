package com.example.college.service;

import com.example.college.dto.DepartmentRequest;
import com.example.college.dto.DepartmentResponse;
import com.example.college.exceptions.model.NotFound;
import com.example.college.mapper.DepartmentMapper;
import com.example.college.model.Department;
import com.example.college.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepo departmentRepo, DepartmentMapper departmentMapper) {
        this.departmentRepo = departmentRepo;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentResponse addDepartment(DepartmentRequest departmentRequest){
        Department department =departmentRepo.save(departmentMapper.toDepartment(departmentRequest));
        return departmentMapper.toDepartmentResponse(department);
    }

    public DepartmentResponse updateDepartment(Long id ,DepartmentRequest departmentRequest){

        if(id==null)throw new NotFound("Null Id");

        Optional<Department> department=departmentRepo.findById(id);

        if(department.isEmpty())throw new NotFound("This Id "+id+"Not Found");

        department.get().setName(departmentRequest.getName());

        department= Optional.of(departmentRepo.save(department.get()));

        return departmentMapper.toDepartmentResponse(department.get());
    }

}
