package com.example.medicalregister.service;

import com.example.medicalregister.model.MedicalHistory;
import com.example.medicalregister.model.Patient;
import com.example.medicalregister.repository.MedicalHistoryRepository;
import com.example.medicalregister.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MedicalHistoryService {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

   public List<MedicalHistory> getMedicalHistoryByPatientId(Long patientId) {
        List<MedicalHistory> medicalHistories = medicalHistoryRepository.findAllByPatientId(patientId);
        log.info("Medical History for patient {} fetched successfully", patientId);
        return medicalHistories;
    }


    public MedicalHistory saveMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }
}
