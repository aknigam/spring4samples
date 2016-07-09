package dev.beans.impl;

import dev.beans.MyService;

public class MyServiceImpl implements MyService {

	private String name;
	
	public void init(){
		System.out.println(name+ " init");
	}
	
	public MyServiceImpl(String name) {
		this.name = name;
	}

	public void doStuff() {
		System.out.println(name+" doing stuff");
	}

}
