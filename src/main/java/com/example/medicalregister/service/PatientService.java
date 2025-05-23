package com.example.medicalregister.service;

import com.example.medicalregister.model.MedicalHistory;
import com.example.medicalregister.model.Patient;
import com.example.medicalregister.repository.MedicalHistoryRepository;
import com.example.medicalregister.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        log.info("Patient {} Detail fetching ", id );
        Optional<Patient> patient = repository.findById(id);
        if(patient.isEmpty()) {
            log.info("Patient {} Detail not present ", id );
        } else  {
            log.info("Patient {} Detail fetched successfully", id);
        }

        return patient;
    }

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }

    public void deletePatient(Long id) {
        repository.deleteById(id);
    }

    public void updateAllMedicalHistory(List<MedicalHistory> medicalHistories) {
        medicalHistoryRepository.saveAll(medicalHistories);
    }
}
