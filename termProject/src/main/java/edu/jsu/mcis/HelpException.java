package edu.jsu.mcis;

public class HelpException extends RuntimeException{
	
	public HelpException(String programName, String helpMessage){
		super("usage: java " + programName + " " + helpMessage);
	}
}