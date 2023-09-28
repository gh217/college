package com.example.college.service;

import com.example.college.dto.CollegeRequestDto;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.CollegeMapper;
import com.example.college.model.College;
import com.example.college.repository.CollegeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
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

    public void updateCollege(Long id, CollegeRequestDto collegeRequestDto){
        Optional<College> college=collegeRepo.findById(id);
        if(college.isEmpty())throw new NotFoundException("this id not found");
        log.info(college.get().getId()+"  here");
        college.get().setName(collegeRequestDto.getName());

        collegeRepo.save(college.get());
    }
}
