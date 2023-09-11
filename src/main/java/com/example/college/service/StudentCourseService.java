package com.example.college.service;

import com.example.college.exceptions.model.CoursePendingLimitedException;
import com.example.college.exceptions.model.DuplicateException;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.model.Course;
import com.example.college.model.Student;
import com.example.college.model.StudentCourse;
import com.example.college.model.StudentCourseStatus;
import com.example.college.repository.CourseRepo;
import com.example.college.repository.StudentCourseRepo;
import com.example.college.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StudentCourseService {

    private final StudentRepo studentRepository;
    private final CourseRepo courseRepository;

    private final StudentCourseRepo studentCourseRepo;


    public StudentCourseService(StudentRepo studentRepository, CourseRepo courseRepository, StudentCourseRepo studentCourseRepo) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseRepo = studentCourseRepo;
    }

    public void addCourse(Long studentId , Long courseId) {


        // check duplicate succeed or fail or null to register this course
        checkStudentCourse(studentId,courseId);

        //check how many courses pending
        checkCountCourses(studentId);

        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);
        if(student.isEmpty())throw new NotFoundException("Id Student Not found");
        if(course.isEmpty())throw new NotFoundException("Id Course Not found");

        StudentCourse studentCourse=new StudentCourse();
        studentCourse.setCourse(course.get());
        studentCourse.setStudent(student.get());

        studentCourse=
               studentCourseRepo.save(studentCourse);
        course.get().getStudentCourses().add(studentCourse);
        student.get().getStudentCourses().add(studentCourse);

        studentCourseRepo.save(studentCourse);
        studentRepository.save(student.get());

    }

    private void checkStudentCourse(Long studentId, Long courseId){
        Optional<StudentCourse> studentCourse=
                studentCourseRepo.studentCourse(studentId,courseId);
        if(studentCourse.isEmpty())return ;

        if(studentCourse.get().getStudentCourseStatus()== StudentCourseStatus.PENDING)
            throw new DuplicateException("this course Pending");

        if(studentCourse.get().getStudentCourseStatus()== StudentCourseStatus.SUCCEED)
            throw new DuplicateException("this course Done");
    }

    private void checkCountCourses(Long studentId){
        Integer coursePending = studentCourseRepo.countStudentsWithPendingCourseStatus(studentId);
        if(coursePending>=6)throw new CoursePendingLimitedException("6 object already register");

    }
    public void deleteByStudentIdAndCourseId
            (Long studentId, Long courseId){
        Optional<Student> student = studentRepository.findById(studentId);
        Optional<Course> course = courseRepository.findById(courseId);
        if(student.isEmpty())throw new NotFoundException("Id Student Not found");
        if(course.isEmpty())throw new NotFoundException("Id Course Not found");

        studentCourseRepo.deleteByStudentIdAndCourseId(studentId,courseId);
    }

    public void updateDegree(Long studentId, Long courseId,Double degree){

        Optional<StudentCourse> studentCourse= studentCourseRepo.studentCourse(studentId,courseId);

        if(studentCourse.isEmpty())throw new NotFoundException("this id not found");
        if(studentCourse.get().getCourse().getId()!=courseId)throw new NotFoundException("this course not Register");

        studentCourse.get().setDegree(degree);

        studentCourseRepo.save(studentCourse.get());
    }
}
