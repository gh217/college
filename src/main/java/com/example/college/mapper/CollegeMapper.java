package com.example.college.mapper;

import com.example.college.dto.CollegeRequestDto;
import com.example.college.dto.CollegeResponseDto;
import com.example.college.model.College;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CollegeMapper {

    private final DepartmentMapper departmentMapper;

    public CollegeMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public College toCollege(CollegeRequestDto collegeRequestDto){
        College college=new College();
        college.setName(collegeRequestDto.getName());
        return college;
    }

    public CollegeResponseDto toCollegeResponseDto(College college){
        CollegeResponseDto collegeResponseDto = new CollegeResponseDto();
        collegeResponseDto.setId(college.getId());
        collegeResponseDto.setName(college.getName());
        collegeResponseDto.setDepartmentResponseDtoList(
                college.getDepartmentList()
                        .stream()
                        .map(departmentMapper::toDepartmentResponseDto)
                        .collect(Collectors.toList()));
        return collegeResponseDto;
    }
}
