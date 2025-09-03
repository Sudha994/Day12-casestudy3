package com.example.hospital.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="doctors")
public class Doctor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int age;
	
	private String specialization;
	
	private String email;
	
	private String phone;
	
	@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
	
	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(Long id, String name, int age, String specialization, String email, String phone) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.specialization = specialization;
		this.email = email;
		this.phone = phone;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
