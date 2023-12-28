package com.radhikaspringboot.crudoperations.service;

import com.radhikaspringboot.crudoperations.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.radhikaspringboot.crudoperations.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    //Get student by Id
    public Student getStudentById(int id)
    {
      return studentRepository.findById(id).orElse(null);
    }

    //Get all students
    public List<Student> getAllStudents()
    {
       return studentRepository.findAll();
    }


    //save student
    public Student saveStudent(Student student)
    {
        return studentRepository.save(student);
    }



    //Save all students
    public List<Student> saveStudents(List<Student> students)
    {
        return  studentRepository.saveAll(students);
    }

    //Delete student
    public String deleteStudentByID(int id)
    {
        studentRepository.deleteById(id);
        return "student with id "+id+" is deleted";
    }

    //Delete all students

    public String deleteAll()
    {
        studentRepository.deleteAll();
        return "All students are removed";
    }

    //Update student info
    public Student updateStudent(Student student) {
       Student existing_student = studentRepository.findById(student.getId()).orElse(null);
        existing_student.setFirstName(student.getFirstName());
        existing_student.setLastName(student.getLastName());
        existing_student.setAddress(student.getAddress());
        return studentRepository.save(existing_student);

    }
}
