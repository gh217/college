package com.example.college.service;

import com.example.college.exceptions.model.NotFoundException;
import com.example.college.model.Course;
import com.example.college.model.Student;
import com.example.college.model.StudentCourse;
import com.example.college.repository.CourseRepo;
import com.example.college.repository.StudentCourseRepo;
import com.example.college.repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentCourseService {

    private final StudentRepo studentRepository;
    private final CourseRepo courseRepository;

    private final StudentCourseRepo studentCourseRepo;


    public StudentCourseService(StudentRepo studentRepository, CourseRepo courseRepository, StudentCourseRepo studentCourseRepo) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseRepo = studentCourseRepo;
    }

    public void addCourse(Long studentId , Long courseId){
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

}
