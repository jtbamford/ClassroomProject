package com.qa.service.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {
	
	@Inject
	private AccountRepository repo;

	public String getAllClassrooms() {
		return repo.getAllClassrooms();
	}
	
	public String createClassroom(String accout) {
		return repo.createClassroom(accout);
	}
	
	public String createTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}
	
	public String deleteClassroom(Long classroomID) {
		return repo.deleteClassroom(classroomID);
	}
	
	public Account retrieveClassroom(Long classroomID) {
		return repo.retrieveClassroom(classroomID);
	}
	
	public String updateClassroom(String accout, Long classroomID) {
		return repo.updateClassroom(accout, classroomID);
	}
	
}
