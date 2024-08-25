package com.example.relationonetooneex.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity

public class Teacher {

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

    @Email
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;

    @NotNull(message="Salary must not be null")
    @Positive(message = "Salary must be a positive number")
    @Column(columnDefinition = "DOUBLE not null")
    private double salary;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;


   @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Set<Course> courses;
}
