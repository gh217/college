package com.example.doctorClinic.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Assisatnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "department_assistant",
            joinColumns = @JoinColumn(name = "Assisatnt_id"),
            inverseJoinColumns = @JoinColumn(name = "Department_id"))
    private Set<Assisatnt> assisatntSet=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Assisatnt_course",
            joinColumns = @JoinColumn(name = "Assisatnt_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private Set<Course> courseSet = new HashSet<>();

}
