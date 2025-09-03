package com.example.hospital.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="patients")
public class Patient {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private int age;
    
    private String gender;
    
    private String address;
    
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments;
    
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalRecord> medicalRecords;
    
    public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(Long id, String name, int age, String gender, String address, List<Appointment> appointments,
			List<MedicalRecord> medicalRecords) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.appointments = appointments;
		this.medicalRecords = medicalRecords;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
    
    
}