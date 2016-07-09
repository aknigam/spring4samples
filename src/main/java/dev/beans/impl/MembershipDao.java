package dev.beans.impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class MembershipDao {

	@Transactional(propagation = Propagation.REQUIRED)
	public void addTraveler() {
		System.out.println("MembershipDao.add traveler working... ");
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void addMember() {
		System.out.println("MembershipDao.addMember working... ");
//		throw new RuntimeException("Exception adding member...");
	}

}
