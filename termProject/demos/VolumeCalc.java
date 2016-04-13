import edu.jsu.mcis.*;

public class VolumeCalc{

	private static Parser p;
	private static XmlTool x;
	
	public static void main(String[] args){
		float l, w, h, volume;
		p = new Parser();
		x = new XmlTool();
		p = x.load("../src/test/java/edu/jsu/mcis/loadFile.xml");
		System.out.println("type = " + p.getOptionalValue("type"));
		p.parseValues(args);
		h = Float.parseFloat(p.getValue("height"));
		w = Float.parseFloat(p.getValue("width"));
		l = Float.parseFloat(p.getValue("length"));
		volume = l*w*h;
		System.out.println(Float.toString(volume));
		System.out.println("type = " + p.getOptionalValue("type"));
	}
}