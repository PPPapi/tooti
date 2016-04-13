package edu.jsu.mcis;

public class TooFewArgsException extends RuntimeException{
	private String extraArgs;
	
	public TooFewArgsException(String extraArgs){
		super("the following arguments are required: " + extraArgs);
		this.extraArgs = extraArgs;
	}
		
	public String getExtraArgs() { 
		return extraArgs; 
	}
}