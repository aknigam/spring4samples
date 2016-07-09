package dev.beans.impl;

import org.springframework.transaction.annotation.Transactional;

import dev.beans.MyService;

public class MyOtherService implements MyService {

	public MyOtherService(String name) {
		System.out.println("MyOtherService constructed...");
	}
	
	@Transactional
	public void doStuff() {
		System.out.println("MyOtherService do stuff");
	}

}
