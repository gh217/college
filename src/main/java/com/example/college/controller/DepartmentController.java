package com.example.college.controller;

import com.example.college.dto.DepartmentRequest;
import com.example.college.dto.DepartmentResponse;
import com.example.college.service.DepartmentService;
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
    public DepartmentResponse addDepartment(@RequestBody DepartmentRequest departmentRequest){
        return departmentService.addDepartment(departmentRequest);
    }

    @PutMapping("/{id}")
    public DepartmentResponse updateDepartment(@PathVariable Long id,@RequestBody DepartmentRequest departmentRequest){
        return departmentService.updateDepartment(id,departmentRequest);
    }

    @GetMapping("/{id}")
    public DepartmentResponse findById(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        departmentService.deleteById(id);
    }
    

}
