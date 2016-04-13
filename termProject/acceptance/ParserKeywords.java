import edu.jsu.mcis.*;
import java.util.*;

public class ParserKeywords{
	
	private Parser p;
	private String output;
	
	public void startProgramWithArguments(String[] args){
		p = new Parser();
		p.addArgument("length", Argument.dataType.FLOAT);
		p.addArgument("width", Argument.dataType.FLOAT);
		p.addArgument("height", Argument.dataType.FLOAT);
		p.addOptionalArgument("help", "false", Argument.dataType.BOOLEAN, "h", "length width height\nCalcuate the volume of a box.\npositional arguments:\n   length the length of the box (float)\n   width the width of the box(float)\n   height the height of the box(float)");
		try{
			p.parseValues(args);
		}
		catch(HelpException ex){
			output = "usage: java VolumeCalculator length width height\nCalcuate the volume of a box.\npositional arguments:\nlength the length of the box (float)\nwidth the width of the box(float)\nheight the height of the box(float)";
		}
		catch(WrongTypeException ex){
			output = "usage: java VolumeCalculator length width height\nVolumeCalcultor.java: error: argument width: invalid float value: " + ex.getWrongTypeArg();
		}
	}
	
	public void startVolumeCacluatorWithArguments(String[] args){
		p = new Parser();
		p.addArgument("length", Argument.dataType.FLOAT);
		p.addArgument("width", Argument.dataType.FLOAT);
		p.addArgument("height", Argument.dataType.FLOAT);
		p.addOptionalArgument("type", "box", Argument.dataType.STRING, "t");
		p.addOptionalArgument("digits", "4", Argument.dataType.INT, "d");
		try {
			p.parseValues(args);
			float volume;
			float h = Float.parseFloat(p.getValue("height"));
			float w = Float.parseFloat(p.getValue("width"));
			float l = Float.parseFloat(p.getValue("length"));
			volume = l*w*h;
			output = Float.toString(volume);
		}
		catch(TooManyArgsException ex) {
			output = "usage: java VolumeCalculator length width height\nVolumeCalcultor.java: error: unrecognized arguments: " + ex.getExtraArgs();
		}
	}
	
	public void startAbsurdProgramWithArguments(String[] args){
		p = new Parser();
		p.addArgument("pet");
		p.addArgument("number");
		p.addArgument("rainy");
		p.addArgument("bathrooms");
		p.parseValues(args);
	} 
	
	public String getType(){
		return p.getOptionalValue("type");
	}
	
	public String getDigits(){
		return p.getOptionalValue("digits");
	}
	
	public String getLength(){
		return p.getValue("length");
	}
	
	public String getWidth(){
		return p.getValue("width");
	}
	
	public String getHeight(){
		return p.getValue("height");
	}
	
	public String getRainy(){
		return p.getValue("rainy");
	}
	
	public String getPet(){
		return p.getValue("pet");
	}
	
	public String getBathrooms(){
		return p.getValue("bathrooms");
	}
	
	public String getNumber(){
		return p.getValue("number");
	}
	
	public String getProgramOutput(){
		return output;
	}
	
	
}