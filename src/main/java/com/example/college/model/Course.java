package com.example.college.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private Double PassedDegree;

    @Column(nullable = false)
    @NotNull
    @Min(value = 0)
    @Max(value = 100)
    private Double totalDegree;

    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(
            name = "department_Course",
            joinColumns = @JoinColumn(name = "Course_id"),
            inverseJoinColumns = @JoinColumn(name = "Department_id"))
    private List<Department> departmentList=new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Professor_course",
            joinColumns = @JoinColumn(name = "Course_id"),
            inverseJoinColumns = @JoinColumn(name = "Professor_id"))
    private List<Professor> professorList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Assisatnt_course",
            joinColumns = @JoinColumn(name = "Course_id"),
            inverseJoinColumns = @JoinColumn(name = "Assisatnt_id"))
    private List<Assistant> assistantList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.PERSIST)
    private List<StudentCourse> studentCourseList = new ArrayList<>();

}