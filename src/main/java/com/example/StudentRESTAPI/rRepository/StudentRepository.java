package com.example.StudentRESTAPI.rRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentRESTAPI.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
