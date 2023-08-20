package com.example.college.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "College_id")
    private College college;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "Department_Professor",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Professor_id"))
    private Set<Professor> professorSet=new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "department_assistant",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Assisatnt_id"))
    private Set<Assistant> assistantSet =new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "department_Course",
            joinColumns = @JoinColumn(name = "Department_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private Set<Course> courseSet=new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private Set<Student> studentSet=new HashSet<>();

}
