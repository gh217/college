package com.example.doctorClinic.repository;

import com.example.doctorClinic.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<Professor,Long> {
}
