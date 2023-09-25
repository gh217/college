package com.example.college.service;

import com.example.college.dto.CollegeRequestDto;
import com.example.college.mapper.CollegeMapper;
import com.example.college.repository.CollegeRepo;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

    private final CollegeRepo collegeRepo;
    private final CollegeMapper collegeMapper;

    public CollegeService(CollegeRepo collegeRepo, CollegeMapper collegeMapper) {
        this.collegeRepo = collegeRepo;
        this.collegeMapper = collegeMapper;
    }

    public void addCollege(CollegeRequestDto collegeRequestDto){
        collegeRepo.save(collegeMapper.toCollege(collegeRequestDto));
    }
}
