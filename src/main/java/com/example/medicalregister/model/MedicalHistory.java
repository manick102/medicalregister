package com.example.medicalregister.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "MEDICAL_HISTORY")
public class MedicalHistory {

    @Id
    private Long id;

    @Column(name = "REASON")
    private String reason;

    @Column(name= "CREATED")
    private LocalDate created;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
