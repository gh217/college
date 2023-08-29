package com.example.college.service;

import com.example.college.dto.DepartmentRequestDto;
import com.example.college.dto.DepartmentResponseDto;
import com.example.college.exceptions.model.NotFoundException;
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

    public DepartmentResponseDto addDepartment(DepartmentRequestDto departmentRequestDto){
        Department department =departmentRepo.save(departmentMapper.toDepartment(departmentRequestDto));
        return departmentMapper.toDepartmentResponseDto(department);
    }

    public DepartmentResponseDto updateDepartment(Long id , DepartmentRequestDto departmentRequestDto){

        if(id==null)throw new NotFoundException("Null Id");

        Optional<Department> department=departmentRepo.findById(id);

        if(department.isEmpty())throw new NotFoundException("This Id "+id+" Not Found");

        department.get().setName(departmentRequestDto.getName());

        department= Optional.of(departmentRepo.save(department.get()));

        return departmentMapper.toDepartmentResponseDto(department.get());
    }

    public DepartmentResponseDto findById(Long id){
        if(id==null)throw new NotFoundException("Null Id");
        Optional<Department> department=departmentRepo.findById(id);
        if(department.isEmpty())throw new NotFoundException("This Id "+id+" Not Found");
        return departmentMapper.toDepartmentResponseDto(department.get());
    }

    public void deleteById(Long id ){
        if(id==null)throw new NotFoundException("Null Id");
        Optional<Department> department=departmentRepo.findById(id);
        if(department.isEmpty())throw new NotFoundException("This Id "+id+" Not Found");
        departmentRepo.deleteById(id);
    }

    public List<DepartmentResponseDto> findAll(){
        List<Department>departmentList=departmentRepo.findAll();
        if(departmentList.isEmpty())throw new NotFoundException("No Department");

        return departmentList
                .stream()
                .map(departmentMapper::toDepartmentResponseDto).toList();
    }
}
