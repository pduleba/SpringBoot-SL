package com.pduleba.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pduleba.studentservice.dto.StudentDTO;
import com.pduleba.studentservice.model.Student;
import com.pduleba.studentservice.repository.StudentRepository;

import lombok.AllArgsConstructor;

//@Transactional
@AllArgsConstructor(onConstructor=@__({@Autowired}))
@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;

	@Override
	public StudentDTO getStudentById(Long id) {
		Student result = studentRepository.getOne(id);

		if (result != null) {
			return StudentDTO.builder().firstName(result.getFirstName()).lastName(result.getLastName()).index(result.getIndex()).build();
		} else {
			return null;
		}
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

}
