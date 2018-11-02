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
import com.qa.util.JSONUtil;
import com.qa.service.business.AccountService;

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

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long classroomID) {
		return service.deleteClassroom(classroomID);
	}
	
	@Path("/updateAccount/{id}/{account}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("account") String accout,@PathParam("id") Long classroomID) {
		//Account acc=JSONUtil.getObjectForJSON(accountJSON,Account.class);
		return updateAccount(accout, classroomID);
	}


}
