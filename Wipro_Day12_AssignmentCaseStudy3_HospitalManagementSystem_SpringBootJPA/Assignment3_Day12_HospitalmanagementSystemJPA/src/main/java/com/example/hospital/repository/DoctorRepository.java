package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{

}
