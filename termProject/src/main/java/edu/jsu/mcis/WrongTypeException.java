package edu.jsu.mcis;

public class WrongTypeException extends RuntimeException{
	String wrongTypeArg;
	
	public WrongTypeException(String wrongTypeArg, String type, String programName, String argList, String argName){
		super("usage: java " + programName + " " + argList + "\n" + programName + ".java: error: argument" + argName + ": invalid " + type + " value: " + wrongTypeArg);
		this.wrongTypeArg = wrongTypeArg;
	}
	
	public String getWrongTypeArg(){
		return wrongTypeArg;
	}
}