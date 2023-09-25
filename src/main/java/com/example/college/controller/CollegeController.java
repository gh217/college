package com.example.college.controller;

import com.example.college.dto.CollegeRequestDto;
import com.example.college.dto.CollegeResponseDto;
import com.example.college.service.CollegeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("college")
public class CollegeController {

    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping
    public void addCollege(@RequestBody CollegeRequestDto collegeRequestDto){
        collegeService.addCollege(collegeRequestDto);
    }
}
