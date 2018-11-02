package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public interface AccountRepository {
	
	String getAllClassrooms();
	String createClassroom(String accout);
	String deleteClassroom(Long classroomID);
	Account retrieveClassroom(Long classroomID);
	String updateClassroom(String accout,Long classroomID);
	String createTrainee(String trainee);
	String deleteTrainee(Long traineeID);

}
