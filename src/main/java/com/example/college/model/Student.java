package com.example.college.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Setter
@Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Min(value = 1)
    @Max(value = 31)
    private int birthday;

    @Min(value = 1)
    @Max(value = 12)
    private int birthmonth;

    @Min(value = 1990)
    @Max(value = 2023)
    private int birthyear;

    @ManyToOne
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "student",cascade = CascadeType.PERSIST)
    private List<StudentCourse> studentCourseList = new ArrayList<>();


}
