package com.example.college.model;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "college",cascade = CascadeType.ALL)
    private Set<Department> departmentSet=new HashSet<>();

}
