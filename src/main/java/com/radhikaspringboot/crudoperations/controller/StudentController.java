package com.radhikaspringboot.crudoperations.controller;

import com.radhikaspringboot.crudoperations.dto.StudentDto;
import com.radhikaspringboot.crudoperations.entity.Address;
import com.radhikaspringboot.crudoperations.entity.Student;
import com.radhikaspringboot.crudoperations.repository.AddressRepository;
import com.radhikaspringboot.crudoperations.repository.StudentRepository;
import com.radhikaspringboot.crudoperations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students")
    public List <Student> getAllStudents() {
        return studentService.getAllStudents();
    }

//    @PostMapping("/addstudentwithAddress")
//    public Student addStudents(@RequestBody StudentDto studentDto) {
//        return studentRepository.save(studentDto.getStudent());
//    }

    @PostMapping("/createstudent")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

//    @PostMapping("/addStudent")
//    public Student addStudent(@RequestBody Student student) {
//        return studentService.saveStudent(student);
//    }



    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentByID(id);
    }

    @DeleteMapping("/delete-all")
    public String deleteallStudents() {
       return studentService.deleteAll();
    }

    @PutMapping("/updateStudent")
    public Student updateStudentById(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @PutMapping("/updateAddress/{studentID}")
    public Address updateAddress(@PathVariable("studentID") int studentId,@RequestBody Address address)
    {
       return  studentService.updateStudentAddress(studentId,address);
    }
}
