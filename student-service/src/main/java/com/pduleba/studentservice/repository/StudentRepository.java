package com.pduleba.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pduleba.studentservice.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
