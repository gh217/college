package com.example.college.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "Department_Professor",
            joinColumns = @JoinColumn(name = "Professor_id"),
            inverseJoinColumns = @JoinColumn(name = "Department_id"))
    private Set<Department> departmentSet=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Professor_course",
            joinColumns = @JoinColumn(name = "Professor_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private Set<Course> courseSet = new HashSet<>();

}
