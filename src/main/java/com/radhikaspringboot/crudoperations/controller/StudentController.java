package com.radhikaspringboot.crudoperations.controller;

import com.radhikaspringboot.crudoperations.entity.Student;
import com.radhikaspringboot.crudoperations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

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

    @PostMapping("/addstudents")
    public List <Student> addStudents(@RequestBody List <Student> students) {
        return studentService.saveStudents(students);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentByID(id);
    }

    @DeleteMapping("/deleteall")
    public String deleteallStudents() {
       return studentService.deleteAll();
    }

    @PutMapping("update")
    public Student updateStudentById(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

}
