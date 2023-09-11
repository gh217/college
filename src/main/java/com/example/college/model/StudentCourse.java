package com.example.college.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table( uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Double degree;

    @Enumerated(EnumType.STRING)
    StudentCourseStatus studentCourseStatus=StudentCourseStatus.PENDING;

}
