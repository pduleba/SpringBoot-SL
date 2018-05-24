package com.pduleba.studentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pduleba.studentservice.dto.StudentDTO;
import com.pduleba.studentservice.model.Student;
import com.pduleba.studentservice.service.StudentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor=@__({@Autowired}))
@RequestMapping("/api")
@RestController
public class StudentRestController {

	private StudentService studentService;

	@GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentDTO getStudent(@PathVariable("id") Long id) {
		return studentService.getStudentById(id);
	}

    @RequestMapping("/save")
    public String process(){
    	studentService.save(new Student(1L, 101L, "Jack", "Smith"));
    	studentService.save(new Student(2L, 202L, "Adam", "Johnson"));
    	studentService.save(new Student(3L, 303L, "Kim", "Smith"));
        studentService.save(new Student(4L, 404L, "David", "Williams"));
        studentService.save(new Student(5L, 505L, "Peter", "Davis"));
        return "Done";
    }
}
