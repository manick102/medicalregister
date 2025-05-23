package com.example.medicalregister.controller;

import com.example.medicalregister.model.MedicalHistory;
import com.example.medicalregister.model.Patient;
import com.example.medicalregister.service.MedicalHistoryService;
import com.example.medicalregister.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class PatientXhtmlController {

    @Autowired
    private PatientService service;

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    private final List<Patient> patientList = new ArrayList<>();

    @GetMapping("/registerPatient")
    public String showForm() {
        return "patient-register";
    }

    @PostMapping("/registerPatient")
    public String submitForm(@ModelAttribute Patient patient, Model model) {
        model.addAttribute("patient", patient);
        service.savePatient(patient);
        return "patient-success";
    }

    @GetMapping("/patientslist")
    public String viewPatients(Model model) {
        model.addAttribute("patients", service.getAllPatients());
        return "patient-list";
    }

    @GetMapping("/patients/{id}/medicalHistory/view")
    public String viewMedicalHistory(@PathVariable Long id, Model model) {
        Patient patient = service.getPatientById(id).get();
        Set<MedicalHistory> medicalHistories = patient.getMedicalHistories();
        List<MedicalHistory> historyList = new ArrayList<>(medicalHistories);
        model.addAttribute("patient", patient);
        model.addAttribute("historyList", historyList);
        return "view-medical-history";
    }

    @GetMapping("/patients/{id}/medicalHistory/create")
    public String showMedicalHistoryForm(@PathVariable Long id, Model model) {
        Patient patient = service.getPatientById(id).get();
        model.addAttribute("patient", patient);
        return "medical-history-create";
    }

    @PostMapping("/patients/{id}/medicalHistory/create")
    public String createMedicalHistory(@PathVariable Long id,
                                       @ModelAttribute MedicalHistory medicalHistory, Model model) {
        Patient patient = service.getPatientById(id).get();

        medicalHistory.setPatient(patient);

        medicalHistoryService.saveMedicalHistory(medicalHistory);

        return "redirect:/patients/" + id + "/medicalHistory/view"; // Redirect to view page
    }
}