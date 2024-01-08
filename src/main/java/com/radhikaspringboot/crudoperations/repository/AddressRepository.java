package com.radhikaspringboot.crudoperations.repository;

import com.radhikaspringboot.crudoperations.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
