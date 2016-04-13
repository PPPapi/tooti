package edu.jsu.mcis;

public class OptionalArgumentDoesNotExistException extends RuntimeException {
	public OptionalArgumentDoesNotExistException(String argName, String programName) {
		super("usage: java " + programName + "\n" + programName + ".java: error: argument " + argName + " does not exist");
	}
}