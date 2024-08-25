package com.example.relationonetooneex.Controller;

import com.example.relationonetooneex.DTO.AddressDTO;
import com.example.relationonetooneex.Model.Address;
import com.example.relationonetooneex.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/address")

public class AddressController {
private final AddressService addressService;
@GetMapping("/get")
public ResponseEntity getAllAddress() {
    return ResponseEntity.status(200).body(addressService.getAllAddress());
}
@PostMapping("/add")
public ResponseEntity addAddressToTeacher(@Valid @RequestBody AddressDTO addressDTO) {
    addressService.addAddressToTeacher(addressDTO);
    return  ResponseEntity.status(200).body("Address added successfully");
}
@PutMapping("/update")
public ResponseEntity updateAddressToTeacher(@Valid @RequestBody AddressDTO addressDTO) {
    addressService.updateAddress(addressDTO);
    return  ResponseEntity.status(200).body("Address updated successfully");

}
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddressFromTeacher(@PathVariable Integer id) {
    addressService.deleteAddress(id);
    return  ResponseEntity.status(200).body("Address deleted successfully");
}

}

