package com.example.college.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int birthday;

    private int birthmonth;

    private int birthyear;

    @ManyToOne
    private Department department;

    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> studentCourses = new HashSet<>();
}
