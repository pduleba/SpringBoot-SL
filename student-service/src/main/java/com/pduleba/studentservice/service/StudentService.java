package com.pduleba.studentservice.service;

import org.springframework.stereotype.Service;

import com.pduleba.studentservice.dto.StudentDTO;
import com.pduleba.studentservice.model.Student;

public interface StudentService {

	public StudentDTO getStudentById(Long id);

	public void save(Student student);

}
