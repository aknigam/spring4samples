package dev.beans.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class MembershipServiceImpl implements ApplicationContextAware{
	
	private MembershipDao dao;
	private ApplicationContext ctx;

	public MembershipServiceImpl(MembershipDao dao ) {
		this.dao = dao;
	}
	
	public void enrollMembership()
	{
		System.out.println("MembershipServiceImpl.startConversation() - started");
		MembershipServiceImpl service = (MembershipServiceImpl) ctx.getBean("membershipServiceImpl");
		service.enrollInTransaction();
		notifiyListeners();
		System.out.println("MembershipServiceImpl.startConversation() - finished");
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void enrollInTransaction(){
		System.out.println("MembershipServiceImpl.enrollInTransaction working... ");
		dao.addTraveler();
		dao.addMember();
	}
	
	private void notifiyListeners() {
		System.out.println("Listeners notified...");
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;
	}

}
