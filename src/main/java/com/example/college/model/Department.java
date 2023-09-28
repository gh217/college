package com.example.college.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "College_id")
    private College college;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "Department_Professor",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Professor_id"))
    private List<Professor> professorList=new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "department_assistant",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Assisatnt_id"))
    private List<Assistant> assistantList =new ArrayList<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "department_Course",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private List<Course> courseList=new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Student> studentList=new ArrayList<>();

}
