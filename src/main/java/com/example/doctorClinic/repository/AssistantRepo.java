package com.example.doctorClinic.repository;

import com.example.doctorClinic.model.Assistant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssistantRepo extends JpaRepository<Assistant,Long> {
}
