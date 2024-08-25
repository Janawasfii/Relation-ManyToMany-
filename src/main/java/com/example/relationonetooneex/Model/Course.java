package com.example.relationonetooneex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name must not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String name;


    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @JsonIgnore
    private Teacher teacher;


    @ManyToMany
    @JsonIgnore
    private Set<Student> students;



}
