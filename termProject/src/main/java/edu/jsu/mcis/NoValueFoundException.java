package edu.jsu.mcis;

public class NoValueFoundException extends RuntimeException{
	
	public NoValueFoundException(String arg){
		super("No value found for the argument: " + arg);
	}
	
}