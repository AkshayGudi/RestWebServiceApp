package com.example.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Path("/patientservice")
public interface PatientService {

	@Path("/allpatients")
	@GET
	public List<Patient> getAllPatients();

	@Produces({MediaType.APPLICATION_JSON })
	@Path("/getpatient/{patientId}")
	@GET
	public Patient getPatient(@PathParam("patientId") Long id);

	@Path("/addpatient")
	@POST
	public Response addPatient(Patient patient);

	@Path("/updatepatient")
	@PUT
	public Response updatePatientInfo(Patient patient);

	@Path("/deletepatient/{patientId}")
	@DELETE
	public Response deletePatient(@PathParam("patientId") Long id);
}

