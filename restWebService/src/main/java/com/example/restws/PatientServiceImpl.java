package com.example.restws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

	Map<Long, Patient> patientMap = new HashMap<>();

	public PatientServiceImpl() {
		init();
	}

	public void init() {
		Patient patient1 = new Patient(1L, "TEST1");
		Patient patient2 = new Patient(2L, "TEST2");
		patientMap.put(patient1.getId(), patient1);
		patientMap.put(patient2.getId(), patient2);
		
		
	}

	@Override
	public List<Patient> getAllPatients() {
		return new ArrayList<>(patientMap.values());
	}

	@Override
	public Patient getPatient(Long id) {
		return patientMap.get(id);		
	}

	@Override
	public Response addPatient(Patient patient) {
		Patient existingPatient = patientMap.get(patient.getId());
		Response response = null;

		if (existingPatient != null) {
			response = Response.notModified().build();
		} else {
			patientMap.put(patient.getId(), patient);
			response = Response.ok().build();
		}

		return response;
	}

	@Override
	public Response updatePatientInfo(Patient patient) {

		Response response;
		if (patientMap.get(patient.getId()) != null) {
			String name = patient.getName();
			patient.setName(name + "_NEW");
			patientMap.put(patient.getId(), patient);
			response = Response.ok(patient).build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

	@Override
	public Response deletePatient(Long id) {

		Response response;

		if (patientMap.get(id) != null) {
			patientMap.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}

		return response;
	}

}

