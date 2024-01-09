package com.radhikaspringboot.crudoperations.controller;

import com.radhikaspringboot.crudoperations.entity.Address;
import com.radhikaspringboot.crudoperations.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/createaddress")
    public Address saveAddress(@RequestBody Address address)
    {
        return  addressService.saveAddress(address);
    }

    @PostMapping("/addresslist")
    public List<Address> saveAll(@RequestBody List<Address> addressList)
    {
       return  addressService.saveAll(addressList);
    }

    @GetMapping("Address")
    public Address getAddress(@PathVariable int id)
    {
        return  addressService.getAddress(id);
    }



}
