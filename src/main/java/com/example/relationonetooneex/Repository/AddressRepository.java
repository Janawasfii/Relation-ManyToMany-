package com.example.relationonetooneex.Repository;

import com.example.relationonetooneex.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findAddressById(Integer id);


}
