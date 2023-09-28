package com.example.college.service;

import com.example.college.dto.CollegeRequestDto;
import com.example.college.dto.CollegeResponseDto;
import com.example.college.dto.DepartmentRequestDto;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.CollegeMapper;
import com.example.college.mapper.DepartmentMapper;
import com.example.college.model.College;
import com.example.college.model.Department;
import com.example.college.repository.CollegeRepo;
import com.example.college.repository.DepartmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CollegeService {

    private final CollegeRepo collegeRepo;
    private final CollegeMapper collegeMapper;

    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

    public CollegeService(CollegeRepo collegeRepo, CollegeMapper collegeMapper, DepartmentRepo departmentRepo, DepartmentMapper departmentMapper) {
        this.collegeRepo = collegeRepo;
        this.collegeMapper = collegeMapper;
        this.departmentRepo = departmentRepo;
        this.departmentMapper = departmentMapper;
    }

    public void addCollege(CollegeRequestDto collegeRequestDto){
        collegeRepo.save(collegeMapper.toCollege(collegeRequestDto));
    }

    public void updateCollege(Long id, CollegeRequestDto collegeRequestDto){
        Optional<College> college=collegeRepo.findById(id);
        if(college.isEmpty())throw new NotFoundException("this id not found");
        log.info(college.get().getId()+"  here");
        college.get().setName(collegeRequestDto.getName());

        collegeRepo.save(college.get());
    }

    public CollegeResponseDto findCollegeById(Long collegeId ){
        Optional<College> college=collegeRepo.findById(collegeId);
        if(college.isEmpty())throw new NotFoundException("This is Not Found");
        return collegeMapper.toCollegeResponseDto(college.get());
    }

    // relation

    public CollegeResponseDto addDepartment(Long collegeId , DepartmentRequestDto departmentRequestDto){
        Optional<College> college=collegeRepo.findById(collegeId);
        if(college.isEmpty())throw new NotFoundException("This is Not Found");

        Department department=departmentMapper.toDepartment(departmentRequestDto);

        college.get().getDepartmentList().add(department);
        department.setCollege(college.get());

        return collegeMapper.toCollegeResponseDto(collegeRepo.save(college.get()));
    }
}
