package com.example.doctorClinic.repository;

import com.example.doctorClinic.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Long> {
}
