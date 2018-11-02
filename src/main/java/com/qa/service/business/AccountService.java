package com.qa.service.business;

import com.qa.persistence.domain.Account;

public interface AccountService {
	
	String getAllClassrooms();
	String createClassroom(String accout);
	String deleteClassroom(Long classroomID);
	Account retrieveClassroom(Long classroomID);
	String updateClassroom(String accout,Long classroomID);

}
