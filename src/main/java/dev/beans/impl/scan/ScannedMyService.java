package dev.beans.impl.scan;

import org.springframework.stereotype.Component;

import dev.beans.MyService;

@Component(value="ScannedMyService")
public class ScannedMyService implements MyService {

	public void doStuff() {
		System.out.println("ScannedMyService doing stuff");
	}

}
