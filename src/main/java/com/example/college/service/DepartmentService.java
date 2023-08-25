package com.example.college.service;

import com.example.college.dto.DepartmentRequest;
import com.example.college.dto.DepartmentResponse;
import com.example.college.exceptions.model.NotFound;
import com.example.college.mapper.DepartmentMapper;
import com.example.college.model.Department;
import com.example.college.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
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

        if(department.isEmpty())throw new NotFound("This Id "+id+" Not Found");

        department.get().setName(departmentRequest.getName());

        department= Optional.of(departmentRepo.save(department.get()));

        return departmentMapper.toDepartmentResponse(department.get());
    }

    public DepartmentResponse findById(Long id){
        if(id==null)throw new NotFound("Null Id");
        Optional<Department> department=departmentRepo.findById(id);
        if(department.isEmpty())throw new NotFound("This Id "+id+" Not Found");
        return departmentMapper.toDepartmentResponse(department.get());
    }

    public void deleteById(Long id ){
        if(id==null)throw new NotFound("Null Id");
        Optional<Department> department=departmentRepo.findById(id);
        if(department.isEmpty())throw new NotFound("This Id "+id+" Not Found");
        departmentRepo.deleteById(id);
    }

    public List<DepartmentResponse> findAll(){
        List<Department>departmentList=departmentRepo.findAll();
        if(departmentList.isEmpty())throw new NotFound("No Department");

        return departmentList
                .stream()
                .map(departmentMapper::toDepartmentResponse).toList();
    }
}
