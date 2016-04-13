import edu.jsu.mcis.*;
import java.util.*;

public class VolumeCalculator{
	
	private String[] nameList = {"length", "width", "height"};
	private Parser p;
	
	public VolumeCalculator(){
		p = new Parser();
		p.insertNames(nameList);
	}
	
	public String calculateVolume(){
		float volume;
		float h = Float.parseFloat(p.getValue("height"));
		float w = Float.parseFloat(p.getValue("width"));
		float l = Float.parseFloat(p.getValue("length"));
		volume = l*w*h;
		return Float.toString(volume);
	}
	
	public void setDimensions(String[] args){
		p.parseValues(args);
	}
	
	public String returnValue(String arg){
		return p.getValue(arg);
	}
	
	public static void main(String[] args){
		VolumeCalculator VC = new VolumeCalculator();
		float a;
		
		for(int i = 0; i < args.length; i++){
			try{
				a = Float.parseFloat(args[i]);	
			}catch(NumberFormatException nfe){
				System.err.print("VolumeCalculatorulator.java: error: unrecognized arguments:");
				System.err.print(" " + args[i]);
			}
		}
		
		//try{
			VC.setDimensions(args);
			if(args.length < 3)
				throw new IndexOutOfBoundsException();
		//	}
			
		/*}catch(IndexOutOfBoundsException ex){
			System.err.println("VolumeCalculatorulator.java: error: the following arguments are required:");
			if(args.length == 2)
				System.out.print(" height");
			else if(args.length == 1)
				System.out.print(" width, height");
			else
				System.out.print(" length, width, height");
			
		}*/
		
		try{
			System.out.println("The volume is: " + VC.calculateVolume());
		}catch(NumberFormatException ex){
			
		}
	}
}
