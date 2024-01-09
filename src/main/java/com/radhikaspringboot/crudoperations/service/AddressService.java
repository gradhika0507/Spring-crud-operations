package com.radhikaspringboot.crudoperations.service;

import com.radhikaspringboot.crudoperations.repository.AddressRepository;
import com.radhikaspringboot.crudoperations.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    //save address
    public Address saveAddress(Address address)
    {
      return addressRepository.save(address);
    }
    //Save all addresses
    public List<Address> saveAll(List<Address> address)
    {
        return addressRepository.saveAll(address);
    }

    //Get Address
    public Address getAddress(int id)
    {
        return addressRepository.findById(id).orElse(null);
    }

}
