package com.pduleba.studentservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {

	private Long index;
	private String firstName;
	private String lastName;

}
