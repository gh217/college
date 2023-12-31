package com.example.college.controller;

import com.example.college.dto.CollegeResponseDto;
import com.example.college.dto.DepartmentRequestDto;
import com.example.college.dto.DepartmentResponseDto;
import com.example.college.service.DepartmentService;
import com.example.college.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentResponseDto addDepartment(@Valid  @RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.addDepartment(departmentRequestDto);
    }

    @PutMapping("/{id}")
    public DepartmentResponseDto updateDepartment(@PathVariable Long id,@Valid @RequestBody DepartmentRequestDto departmentRequestDto){
        return departmentService.updateDepartment(id, departmentRequestDto);
    }

    @GetMapping("/{id}")
    public DepartmentResponseDto findById(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        departmentService.deleteById(id);
    }

    @GetMapping
    public List<DepartmentResponseDto> findAll(){
        return departmentService.findAll();
    }

    // relation with student
    @PostMapping("/{departmentId}/{studentId}")
    public void addStudentToDepartment(@PathVariable Long departmentId, @PathVariable Long studentId  ){
         departmentService.addStudentToDepartment(departmentId,studentId);
    }

    @PutMapping("/{departmentId}/{studentId}")
    public void updateStudentToDepartment(@PathVariable Long departmentId, @PathVariable Long studentId  ){
        departmentService.addStudentToDepartment(departmentId,studentId);
    }


}
