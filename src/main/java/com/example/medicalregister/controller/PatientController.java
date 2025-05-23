package com.example.medicalregister.controller;

import com.example.medicalregister.model.Patient;
import com.example.medicalregister.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping
    public List<Patient> getAll() {
        return service.getAllPatients();
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        Patient patient1 = service.savePatient(patient);

        return patient1;
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        updatedPatient.setId(id);
        return service.savePatient(updatedPatient);
    }

    @GetMapping("/{id}")
    public Optional<Patient> getById(@PathVariable Long id) {
        return service.getPatientById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletePatient(id);
    }
}