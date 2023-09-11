package com.example.college.repository;

import com.example.college.model.StudentCourse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface StudentCourseRepo extends JpaRepository<StudentCourse,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM StudentCourse sc WHERE sc.student.id = :studentId" +
            " AND sc.course.id = :courseId")
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
    

}
