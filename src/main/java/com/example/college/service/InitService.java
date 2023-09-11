package com.example.college.service;

import com.example.college.model.*;
import com.example.college.repository.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitService implements CommandLineRunner {

    private final CollegeRepo collegeRepo;
    private final DepartmentRepo departmentRepo;
    private final ProfessorRepo professorRepo;
    private final AssistantRepo assistantRepo;
    private final CourseRepo courseRepo;

    private final StudentRepo studentRepo;

    public InitService(CollegeRepo collegeRepo, DepartmentRepo departmentRepo, ProfessorRepo professorRepo, AssistantRepo assistantRepo, CourseRepo courseRepo, StudentRepo studentRepo) {
        this.collegeRepo = collegeRepo;
        this.departmentRepo = departmentRepo;
        this.professorRepo = professorRepo;
        this.assistantRepo = assistantRepo;
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        init();
    }
    private void init(){
        addCollege();
        addDepartment();
        addProfessor();
        addAssistant();
        addCourses();
        addStudent();
    }
    private void addCollege(){
        College college=new College();
        college.setName("FCI");
        collegeRepo.save(college);
    }

    private void addDepartment(){
        List<String>list= Arrays.asList("IR","CS","IT","IS");
        for (String departmentName : list){
            Department department=new Department();
            department.setName(departmentName);
            departmentRepo.save(department);
        }
    }
    private void addProfessor(){
        List<String>list= Arrays.asList("mohamed Malhat","Arabi","Hatem","Sisi");
        for(String professorName :list){
            Professor professor=new Professor();
            professor.setName(professorName);
            professorRepo.save(professor);
        }
    }
    private void addAssistant(){
        List<String>list= Arrays.asList("Heba", "nesma","batanoni","nahas");

        for(String assistantName :list){
            Assistant assistant=new Assistant();
            assistant.setName(assistantName);
            assistantRepo.save(assistant);
        }
    }

    private void addCourses(){
        List<Pair<String,String>>pairs=new ArrayList<>();
        pairs.add(new Pair<>("c++","c++1"));
        pairs.add(new Pair<>("java","java2"));
        pairs.add(new Pair<>("pyp","pyp3"));
        pairs.add(new Pair<>("intro","intro1"));

        for (Pair<String,String> pair : pairs){
            Course course=new Course();
            course.setName(pair.getName());
            course.setCode(pair.getCode());
            courseRepo.save(course);
        }
    }

    private void addStudent(){
        Student student1=new Student();
        Student student2=new Student();
        Student student3=new Student();
        Student student4=new Student();

        student1.setName("mo1");
        student2.setName("mo2");
        student3.setName("mo3");
        student4.setName("mo4");

        student1.setBirthday(17);
        student1.setBirthmonth(1);
        student1.setBirthyear(2001);

        student2.setBirthday(17);
        student2.setBirthmonth(2);
        student2.setBirthyear(2002);

        student3.setBirthday(17);
        student3.setBirthmonth(3);
        student3.setBirthyear(2003);

        student4.setBirthday(17);
        student4.setBirthmonth(4);
        student4.setBirthyear(2004);

        studentRepo.save(student1);
        studentRepo.save(student2);
        studentRepo.save(student3);
        studentRepo.save(student4);

    }
    @Data
    @AllArgsConstructor
    private class Pair<T,T1>{
        T name;
        T1 code;
    }

}
