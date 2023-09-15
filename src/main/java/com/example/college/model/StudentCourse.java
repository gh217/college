package com.example.college.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
//@Table( uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"student_id", "course_id"})
//})
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Double degree;

    @Temporal(TemporalType.TIMESTAMP)
    private Date StartCourse=new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date endCourse;

    @Enumerated(EnumType.STRING)
    StudentCourseStatus studentCourseStatus=StudentCourseStatus.PENDING;

}
