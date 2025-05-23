package com.example.medicalregister;

import com.example.medicalregister.model.Patient;
import com.example.medicalregister.repository.PatientRepository;
import com.example.medicalregister.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

	@Mock
	private PatientRepository repository;

	@InjectMocks
	private PatientService service;

	public PatientServiceTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllPatients() {
		List<Patient> list = List.of(new Patient(), new Patient());
		when(repository.findAll()).thenReturn(list);
		assertEquals(2, service.getAllPatients().size());
	}

	@Test
	public void testGetPatientById() {
		Patient patient = new Patient();
		patient.setId(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(patient));
		assertTrue(service.getPatientById(1L).isPresent());
	}

	@Test
	public void testSavePatient() {
		Patient patient = new Patient();
		when(repository.save(patient)).thenReturn(patient);
		assertNotNull(service.savePatient(patient));
	}

	@Test
	public void testDeletePatient() {
		Long id = 1L;
		service.deletePatient(id);
		verify(repository, times(1)).deleteById(id);
	}
}
