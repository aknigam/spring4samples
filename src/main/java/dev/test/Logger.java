package dev.test;

public class Logger {

	public static void log(String indent , String name, String log) {
		if(indent!=null)
			System.out.println(indent +name+" - "+log);
		else
			System.out.println(name+" - "+log);
	}
	
	public static void log(String name, String log) {
		log(null, name, log);
	}
	
	

}
