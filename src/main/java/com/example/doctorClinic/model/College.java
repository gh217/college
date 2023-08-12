package com.example.doctorClinic.model;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;

import java.util.HashSet;
import java.util.Set;

@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "college")
    private Set<Department> departmentSet=new HashSet<>();

}
