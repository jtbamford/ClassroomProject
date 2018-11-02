package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountDBRepository implements AccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllClassrooms() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String createClassroom(String accout) {
		Account anAccount = util.getObjectForJSON(accout, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long classroomID) {
		Account accountInDB = retrieveClassroom(classroomID);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteTrainee(Long traineeID) {
		Trainee traineeInDB = retrieveTrainee(traineeID);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}
	

	public Account retrieveClassroom(Long classroomID) {
		return manager.find(Account.class, classroomID);
	}
	
	public Trainee retrieveTrainee(Long traineeID) {
		return manager.find(Trainee.class, traineeID);
	}
	

	@Transactional(REQUIRED)
	public String updateClassroom(String accout, Long classroomID) {
		Account account = util.getObjectForJSON(accout, Account.class);
		Account accountold=retrieveClassroom(classroomID);
		accountold.setClassroomID(account.getClassroomID());
		accountold.setTrainer(account.getTrainer());
		//accountold.setTrainee(account.getTrainee());
		return "{\"message\": \"account has been sucessfully updated\"}";
	}

}


