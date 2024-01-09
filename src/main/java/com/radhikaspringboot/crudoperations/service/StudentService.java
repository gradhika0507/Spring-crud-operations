package com.radhikaspringboot.crudoperations.service;

import com.radhikaspringboot.crudoperations.entity.Address;
import com.radhikaspringboot.crudoperations.entity.Student;
import com.radhikaspringboot.crudoperations.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.radhikaspringboot.crudoperations.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

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

    public Student createStudent(Student student) {
        // Ensure each address has a reference to the student
        for (Address address : student.getAddresses()) {
            address.setStudent(student);
        }

        return studentRepository.save(student);
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
    
    public Address updateStudentAddress(int studentID, Address address)
    {
        Student existingStudent = studentRepository.findById(studentID).orElse(null);
        List<Address> addresses = existingStudent.getAddresses();
        for (Address addrs : addresses) {
            if(addrs.getAddressType().toString().equals("Primary")) {
                addrs.setCity(address.getCity());
                addrs.setStreet(address.getStreet());
                addressRepository.save(addrs);

            }
        }
        return address;
    }


}
