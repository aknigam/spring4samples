package dev.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.beans.MyService;
import dev.beans.impl.ComponentAnnotatedService;
import dev.beans.impl.MembershipServiceImpl;

public class MainStart {

	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class , ComponentAnnotatedService.class);
		
		MembershipServiceImpl service = (MembershipServiceImpl) ctx.getBean("membershipServiceImpl");
		service.enrollMembership();
//		service.startTxn();
	}
	
	public static void run(String[] args) {
	    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class , ComponentAnnotatedService.class);
	    
	    MyService myService = (MyService) ctx.getBean("myServiceA");
	    myService.doStuff();
	    
	    myService = (MyService) ctx.getBean("myServiceB");
	    myService.doStuff();
	    
	    myService = (MyService) ctx.getBean("myServiceB");
	    myService.doStuff();
	    
	    myService = (MyService) ctx.getBean("myServiceC");
	    myService.doStuff();
	    
	    myService = (MyService) ctx.getBean("ComponentAnnotatedService");
	    myService.doStuff();	    
	    
	    myService = (MyService) ctx.getBean("ScannedMyService");
	    myService.doStuff();
	}
}
