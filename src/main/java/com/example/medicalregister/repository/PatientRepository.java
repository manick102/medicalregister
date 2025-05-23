package com.example.medicalregister.repository;

import com.example.medicalregister.model.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @EntityGraph(attributePaths = "medicalHistories")
    Optional<Patient> findById(Long id);

    @EntityGraph(attributePaths = "medicalHistories")
    List<Patient> findAll();
}