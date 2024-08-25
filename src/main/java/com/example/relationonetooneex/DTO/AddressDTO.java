package com.example.relationonetooneex.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_id;


    @NotEmpty(message = "Area must not be empty")
    private String area;


    @NotEmpty(message = "Street must not be empty")
    private String street;

    @NotNull(message = "Building number must not be null")
    private Integer buildingNumber;
}
