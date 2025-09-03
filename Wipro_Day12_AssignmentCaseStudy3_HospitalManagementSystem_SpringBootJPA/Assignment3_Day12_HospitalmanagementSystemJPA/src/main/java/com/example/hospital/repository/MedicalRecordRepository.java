package com.example.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.entity.MedicalRecord;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long>{

	List<Long> findByPatientId(Long id);

}
