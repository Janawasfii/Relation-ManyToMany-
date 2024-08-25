package com.example.relationonetooneex.Service;

import com.example.relationonetooneex.API.APIException;
import com.example.relationonetooneex.DTO.AddressDTO;
import com.example.relationonetooneex.Model.Address;
import com.example.relationonetooneex.Model.Teacher;
import com.example.relationonetooneex.Repository.AddressRepository;
import com.example.relationonetooneex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public void addAddressToTeacher(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id()) ;
        if (teacher == null) {
            throw new APIException("Cannot Assign Address");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (address == null) {
            throw new APIException("Cannot Assign Address");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
      Address address = addressRepository.findAddressById(id);
      if (address == null) {
          throw new APIException("Cannot Delete Address");
      }
      addressRepository.delete(address);
    }


}




