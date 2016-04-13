import edu.jsu.mcis.*;
public class Butt {
	Parser p;
	public Butt(){
		p = new Parser();
	}
	
	public static void main(String[] args){
		Butt butt = new Butt();
		String[] names = {"length", "width", "height"};
		String[] type = {"type", "box"};
		String[] values = {"--type", "ellipsoid", "7", "3", "2"};
		butt.p.addArguments(names);
		butt.p.addOptionalArgument(type);
		butt.p.setOptionalArgumentType("type", Argument.dataType.INT);
		
		
		butt.p.parseValues(values);
	}
}