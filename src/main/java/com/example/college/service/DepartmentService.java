package com.example.college.service;

import com.example.college.dto.DepartmentRequestDto;
import com.example.college.dto.DepartmentResponseDto;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.DepartmentMapper;
import com.example.college.mapper.StudentMapper;
import com.example.college.model.Department;
import com.example.college.model.Student;
import com.example.college.repository.DepartmentRepo;
import com.example.college.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public DepartmentService(DepartmentRepo departmentRepo, DepartmentMapper departmentMapper, StudentRepo studentRepo, StudentMapper studentMapper) {
        this.departmentRepo = departmentRepo;
        this.departmentMapper = departmentMapper;
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
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

    // relation with student

    public void addStudentToDepartment(Long departmentId , Long studentId){
        addUpdateStudentToCourse(departmentId,studentId);
    }

    public void updateStudentToDepartment(Long departmentId , Long studentId){
        addUpdateStudentToCourse(departmentId,studentId);
    }

    private void addUpdateStudentToCourse(Long departmentId , Long studentId){
        Optional<Department> department=departmentRepo.findById(departmentId);
        if(department.isEmpty())throw new NotFoundException("Department ID not found");
        Optional<Student> student=studentRepo.findById(studentId);
        if(student.isEmpty())throw new NotFoundException("Student ID not found");

        department.get().getStudentList().add(student.get());
        student.get().setDepartment(department.get());

        departmentRepo.save(department.get());
    }

}
