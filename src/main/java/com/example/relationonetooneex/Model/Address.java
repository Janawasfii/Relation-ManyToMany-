package com.example.relationonetooneex.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity

public class Address {

     @Id
     private Integer id;


     @NotEmpty(message = "Area must not be empty")
     @Column(columnDefinition = "varchar(50) not null")
     private String area;

     @NotEmpty(message = "Street must not be empty")
     @Column(columnDefinition = "varchar(50) not null")
     private String street;

     @NotNull(message = "Building number must not be null")
     @Column(columnDefinition = "int not null")
     private Integer buildingNumber;


     @OneToOne
     @MapsId
     @JsonIgnore
     private Teacher teacher;


}
