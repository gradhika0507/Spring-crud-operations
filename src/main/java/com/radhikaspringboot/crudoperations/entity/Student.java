package com.radhikaspringboot.crudoperations.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import jakarta.persistence.OneToMany;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

//    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
//    @JoinColumn(name= "student_id", referencedColumnName = "id")
//    private List <Address> addressList;
}

