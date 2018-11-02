package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Trainee;
import com.qa.service.business.AccountService;
import com.qa.util.JSONUtil;

@Path("/account")
public class AccountEndPoint {
	
	@Inject
	private AccountService service;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllClassrooms();
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String createClassroom(String account) {
		return service.createClassroom(account);
	}
	
	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String trainee) {
		return service.createTrainee(trainee);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long classroomID) {
		return service.deleteClassroom(classroomID);
	}
	
	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long traineeID) {
		return service.deleteTrainee(traineeID);
	}
	
	@Path("/updateAccount/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(String accout,@PathParam("id") Long classroomID) {
		return service.updateClassroom(accout, classroomID);
	}


}
