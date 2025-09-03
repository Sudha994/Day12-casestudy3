package com.example.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.entity.Appointment;
import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.MedicalRecord;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.MedicalRecordRepository;
import com.example.hospital.repository.PatientRepository;

@RestController
@RequestMapping("/api")
public class HospitalController {
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    
    // Patient endpoints
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
    
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElseThrow();
    }
    
    @PutMapping("/patients/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setName(patientDetails.getName());
        patient.setAge(patientDetails.getAge());
        patient.setGender(patientDetails.getGender());
        patient.setAddress(patientDetails.getAddress());
        return patientRepository.save(patient);
    }
    
    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
    
    // Doctor endpoints
    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    @GetMapping("/doctors/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }
    
    @PutMapping("/doctors/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setName(doctorDetails.getName());
        doctor.setSpecialization(doctorDetails.getSpecialization());
        doctor.setEmail(doctorDetails.getEmail());
        doctor.setPhone(doctorDetails.getPhone());
        return doctorRepository.save(doctor);
    }
    
    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
    }
    
    // Appointment endpoints
    @PostMapping("/appointments")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    
    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    
    @GetMapping("/appointments/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentRepository.findById(id).orElseThrow();
    }
    
    @PutMapping("/appointments/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment appointmentDetails) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointment.setDate(appointmentDetails.getDate());
        appointment.setTime(appointmentDetails.getTime());
        appointment.setNotes(appointmentDetails.getNotes());
        appointment.setPatient(appointmentDetails.getPatient());
        appointment.setDoctor(appointmentDetails.getDoctor());
        return appointmentRepository.save(appointment);
    }
    
    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
    }
    
    // Medical Record endpoints
    @PostMapping("/medical-records")
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }
    
    @GetMapping("/medical-records")
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }
    
    @GetMapping("/patients/{id}/records")
    public List<Long> getPatientRecords(@PathVariable Long id) {
        return medicalRecordRepository.findByPatientId(id);
    }
    
    @PutMapping("/medical-records/{id}")
    public MedicalRecord updateMedicalRecord(@PathVariable Long id, @RequestBody MedicalRecord medicalRecordDetails) {
        MedicalRecord medicalRecord = medicalRecordRepository.findById(id).orElseThrow();
        medicalRecord.setDiagnosis(medicalRecordDetails.getDiagnosis());
        medicalRecord.setTreatment(medicalRecordDetails.getTreatment());
        medicalRecord.setDate(medicalRecordDetails.getDate());
        medicalRecord.setPatient(medicalRecordDetails.getPatient());
        return medicalRecordRepository.save(medicalRecord);
    }
    
    @DeleteMapping("/medical-records/{id}")
    public void deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordRepository.deleteById(id);
    }
}