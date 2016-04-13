import edu.jsu.mcis.*;


public class SaveTest {
	
	public SaveTest() {
		
	}
	
	public static void main(String[] args){
		Parser p = new Parser();
		XmlTool x = new XmlTool();
		p.addArgument("length", Argument.dataType.FLOAT);
		p.addArgument("width", Argument.dataType.FLOAT);
		p.addArgument("height", Argument.dataType.FLOAT);
		String[] values = {"1.0", "2.0", "3,0"};
		p.addOptionalArgument("type", "false", Argument.dataType.BOOLEAN, "t");
		p.addOptionalArgument("digits", "4");
		x.saveToXML("dingus.xml", p);
	}
}