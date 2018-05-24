package com.pduleba.studentservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {

	private static final long serialVersionUID = -8484824370182029136L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "index")
	private Long index;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

}
