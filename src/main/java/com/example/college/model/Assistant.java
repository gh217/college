package com.example.college.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Assistant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "department_assistant",
            joinColumns = @JoinColumn(name = "Assisatnt_id"),
            inverseJoinColumns = @JoinColumn(name = "Department_id"))
    private Set<Department> departmentSet =new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "Assisatnt_course",
            joinColumns = @JoinColumn(name = "Assisatnt_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private Set<Course> courseSet = new HashSet<>();

}
