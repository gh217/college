package com.example.college.repository;

import com.example.college.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface StudentCourseRepo extends JpaRepository<StudentCourse,Long> {
}
