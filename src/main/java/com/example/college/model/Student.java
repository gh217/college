package com.example.college.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
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

    @JsonIgnore
    @OneToMany(mappedBy = "student",cascade = CascadeType.PERSIST)
    private Set<StudentCourse> studentCourses = new HashSet<>();


}
