package com.example.relationonetooneex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name must not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;

    @NotNull(message="age must not be null")
    @Positive(message = "Age must be a positive number")
    @Column(columnDefinition = "int not null")
    private Integer age;


    @NotEmpty(message = "Major must not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String major;


   @ManyToMany(mappedBy = "students")
    private Set<Course> course;


}
