package com.example.college.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    @Column(nullable = false)
    private Double PassedDegree;

    @Column(nullable = false)
    private Double totalDegree;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "department_Course",
            joinColumns = @JoinColumn(name = "Course_id"),
            inverseJoinColumns = @JoinColumn(name = "Department_id"))
    private Set<Department> departmentSet=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Professor_course",
            joinColumns = @JoinColumn(name = "Course_id"),
            inverseJoinColumns = @JoinColumn(name = "Professor_id"))
    private Set<Professor> professorSet = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Assisatnt_course",
            joinColumns = @JoinColumn(name = "Course_id"),
            inverseJoinColumns = @JoinColumn(name = "Assisatnt_id"))
    private Set<Course> courseSet = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    private Set<StudentCourse> studentCourses = new HashSet<>();

}