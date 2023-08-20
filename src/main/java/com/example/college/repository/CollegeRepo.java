package com.example.college.repository;

import com.example.college.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College,Long> {

}
