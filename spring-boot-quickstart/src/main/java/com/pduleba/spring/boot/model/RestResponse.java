package com.pduleba.spring.boot.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.*;

@Data
@XmlRootElement // for Accept = 'application/xml' header
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse {

	private String action;
}
