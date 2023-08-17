package com.example.doctorClinic.repository;

import com.example.doctorClinic.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
