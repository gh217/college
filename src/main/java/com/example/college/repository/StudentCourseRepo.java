package com.example.college.repository;

import com.example.college.model.StudentCourse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentCourseRepo extends JpaRepository<StudentCourse,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM StudentCourse sc WHERE sc.student.id = :studentId" +
            " AND sc.course.id = :courseId")
    void deleteByStudentIdAndCourseId(Long studentId, Long courseId);


    @Query("SELECT sc FROM StudentCourse sc WHERE sc.student.id = :studentId AND sc.course.id = :courseId")
    List<StudentCourse> studentCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    @Query("SELECT COUNT(s) FROM StudentCourse s WHERE s.studentCourseStatus = 'PENDING' and s.student.id= :studentId")
    Integer countStudentsWithPendingCourseStatus(Long studentId);


    @Query("SELECT sc FROM StudentCourse sc WHERE sc.student.id = :studentId")
    List<StudentCourse> studentCourse( Long studentId);

    @Query("SELECT sc FROM StudentCourse sc WHERE sc.student.id = :studentId AND sc.course.id = :courseId and sc.studentCourseStatus='PENDING'")
    Optional<StudentCourse> studentCourseUpdate( Long studentId,Long courseId);

}
