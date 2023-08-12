package com.example.doctorClinic.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "College_id")
    private College college=new College();

    @ManyToMany
    @JoinTable(
            name = "Department_Professor",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Professor_id"))
    private Set<Professor> professorSet=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "department_assistant",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Assisatnt_id"))
    private Set<Assisatnt> assisatntSet=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "department_Course",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private Set<Course> courseSet=new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Student> studentSet=new HashSet<>();

}
