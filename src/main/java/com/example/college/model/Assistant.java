package com.example.college.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Assistant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(
            name = "department_assistant",
            joinColumns = @JoinColumn(name = "Assisatnt_id"),
            inverseJoinColumns = @JoinColumn(name = "Department_id"))
    private List<Department> departmentList =new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Assisatnt_course",
            joinColumns = @JoinColumn(name = "Assisatnt_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private List<Course> courseList = new ArrayList<>();

}
