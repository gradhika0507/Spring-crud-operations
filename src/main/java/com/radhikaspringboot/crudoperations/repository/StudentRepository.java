package com.radhikaspringboot.crudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.radhikaspringboot.crudoperations.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
