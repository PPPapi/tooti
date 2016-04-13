import edu.jsu.mcis.*;

public class Poop{

	public static void main(String[] args){
		Parser p = new Parser();
		XmlTool x = new XmlTool();
		
		p = x.load("./src/test/java/edu/jsu/mcis/loadFile.xml");
	}

}