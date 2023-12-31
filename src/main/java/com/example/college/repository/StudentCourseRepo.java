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
    List<StudentCourse> checkStudentCourse(@Param("studentId") Long studentId, @Param("courseId") Long courseId);

    @Query("SELECT COUNT(s) FROM StudentCourse s WHERE s.studentCourseStatus = 'PENDING' and s.student.id= :studentId")
    Integer countStudentsWithPendingCourseStatus(Long studentId);


    @Query("SELECT sc FROM StudentCourse sc WHERE sc.student.id = :studentId ORDER BY sc.StartCourse asc")
    List<StudentCourse> allStudentCourse(Long studentId);

    @Query("SELECT sc FROM StudentCourse sc WHERE sc.student.id = :studentId AND sc.course.id = :courseId and sc.studentCourseStatus='PENDING'")
    Optional<StudentCourse> studentCourseUpdate( Long studentId,Long courseId);


    @Query("SELECT sc FROM StudentCourse sc WHERE sc.studentCourseStatus = 'PENDING' and sc.student.id= :studentId")
    List<StudentCourse> studentCoursePending(Long studentId);

    @Query("SELECT sc FROM StudentCourse sc WHERE sc.studentCourseStatus = 'SUCCEED' and sc.student.id= :studentId")
    List<StudentCourse> studentCourseSucceed(Long studentId);

    @Query("SELECT sc FROM StudentCourse sc WHERE sc.studentCourseStatus = 'FAIL' and sc.student.id= :studentId")
    List<StudentCourse> studentCourseFailed(Long studentId);

//    @Override
//    @Query("SELECT e FROM StudentCourse e ORDER BY e.StartCourse asc ")
//    List<StudentCourse> findAll();
}
