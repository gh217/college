package com.example.college.controller;

import com.example.college.dto.CollegeRequestDto;
import com.example.college.dto.CollegeResponseDto;
import com.example.college.service.CollegeService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public void updateCollege(@PathVariable Long id,@RequestBody CollegeRequestDto collegeRequestDto){
        collegeService.updateCollege(id,collegeRequestDto);
    }
}
