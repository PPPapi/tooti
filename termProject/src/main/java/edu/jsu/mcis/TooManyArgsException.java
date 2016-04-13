package edu.jsu.mcis;

public class TooManyArgsException extends RuntimeException{
	private String extraArgs;
	
	public TooManyArgsException(String extraArgs){
		super("unrecognized arguments: " + extraArgs);
		this.extraArgs = extraArgs;
	}
		
	public String getExtraArgs() { 
		return extraArgs; 
	}
}