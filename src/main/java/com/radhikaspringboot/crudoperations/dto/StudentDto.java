package com.radhikaspringboot.crudoperations.dto;

import com.radhikaspringboot.crudoperations.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {

    private Student student;
}
