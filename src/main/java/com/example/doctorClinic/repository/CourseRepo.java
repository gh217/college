package com.example.doctorClinic.repository;

import com.example.doctorClinic.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
