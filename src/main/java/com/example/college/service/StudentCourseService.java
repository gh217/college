package com.example.college.service;

import com.example.college.dto.StudentCourseResponseDto;
import com.example.college.exceptions.model.CoursePendingLimitedException;
import com.example.college.exceptions.model.DuplicateException;
import com.example.college.exceptions.model.NotFoundException;
import com.example.college.mapper.StudentCourseMapper;
import com.example.college.model.Course;
import com.example.college.model.Student;
import com.example.college.model.StudentCourse;
import com.example.college.model.StudentCourseStatus;
import com.example.college.repository.CourseRepo;
import com.example.college.repository.StudentCourseRepo;
import com.example.college.repository.StudentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentCourseService {

    private final StudentRepo studentRepository;
    private final CourseRepo courseRepository;

    private final StudentCourseRepo studentCourseRepo;

    private final StudentCourseMapper studentCourseMapper;


    public StudentCourseService(StudentRepo studentRepository, CourseRepo courseRepository, StudentCourseRepo studentCourseRepo, StudentCourseMapper studentCourseMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.studentCourseRepo = studentCourseRepo;
        this.studentCourseMapper = studentCourseMapper;
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
        List<StudentCourse> studentCourseList=
                studentCourseRepo.checkStudentCourse(studentId,courseId);
        if(studentCourseList.isEmpty())return ;

        for(StudentCourse studentCourse : studentCourseList){
            if(studentCourse.getStudentCourseStatus().name().equals("PENDING")){
                throw new DuplicateException("this course Already Exist");
            }

            if(studentCourse.getStudentCourseStatus().name().equals("SUCCEED")){
                throw new DuplicateException("this course Passed");
            }
        }
        //fail
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

        Optional<StudentCourse> studentCourse= studentCourseRepo.studentCourseUpdate(studentId,courseId);

        if(studentCourse.isEmpty())throw new NotFoundException("this id not found");
        studentCourse.get().setDegree(degree);
        //check degree
        if(degree>=50){
            studentCourse.get().setStudentCourseStatus(StudentCourseStatus.SUCCEED);
        }else{
            studentCourse.get().setStudentCourseStatus(StudentCourseStatus.FAIL);
        }
        studentCourseRepo.save(studentCourse.get());
    }

    public List<StudentCourseResponseDto> studentCourseList(Long studentId){
        List<StudentCourse> studentCourseList= studentCourseRepo.studentCourse(studentId);
        return studentCourseList
                .stream()
                .map(studentCourseMapper::toStudentCourseResponseDto)
                .toList();
    }

    public List<StudentCourseResponseDto> updateStatus(){

        List<StudentCourse>studentCourseList=studentCourseRepo.findAll();
        for(StudentCourse studentCourse : studentCourseList){

            //pending
            if(studentCourse.getDegree()==null)continue;
            if(studentCourse.getDegree()>=50){
                studentCourse.setStudentCourseStatus(StudentCourseStatus.SUCCEED);
                continue;
            }
            studentCourse.setStudentCourseStatus(StudentCourseStatus.FAIL);
        }
        studentCourseRepo.saveAll(studentCourseList);

        return studentCourseList
                .stream()
                .map(studentCourseMapper::toStudentCourseResponseDto)
                .toList();
    }


    public List<StudentCourseResponseDto> studentCourseResponsePending(Long studentId){
        return studentCourseRepo.studentCoursePending(studentId)
                .stream()
                .map(studentCourseMapper::toStudentCourseResponseDto)
                .toList();
    }

    public List<StudentCourseResponseDto> studentCourseResponseSucceed(Long studentId){
        return studentCourseRepo.studentCourseSucceed(studentId)
                .stream()
                .map(studentCourseMapper::toStudentCourseResponseDto)
                .toList();
    }
}
