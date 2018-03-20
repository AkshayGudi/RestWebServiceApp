package com.example.restws;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "patient")
public class Patient {

	private Long id;
	private String name;

	public Patient() {

	}

	public Patient(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

