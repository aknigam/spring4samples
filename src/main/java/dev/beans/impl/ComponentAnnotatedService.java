package dev.beans.impl;

import org.springframework.stereotype.Component;

import dev.beans.MyService;

@Component(value="ComponentAnnotatedService")
public class ComponentAnnotatedService implements MyService {

	public void doStuff() {
		System.out.println("ComponentAnnotatedService doing stuff");
	}

}
