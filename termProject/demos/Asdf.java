import edu.jsu.mcis.*;

public class Asdf{
	
	Parser p;
	
	public Asdf(){
		p = new Parser();
	}
	
	public static void main(String[] args){
		Asdf asdf = new Asdf();
		asdf.p.addArgument("length", Argument.dataType.FLOAT);
		asdf.p.addArgument("width", Argument.dataType.FLOAT);
		asdf.p.addArgument("height", Argument.dataType.FLOAT);
		String[] help = {"help", "false"};
		String[] boolean1 = {"boolean1", "false"};
		String[] boolean2 = {"boolean2", "false"};
		asdf.p.addOptionalArgument(help);
		asdf.p.addOptionalArgument(boolean1);
		asdf.p.addOptionalArgument(boolean2);
		System.out.println(asdf.p.getOptionalValue("help"));
		asdf.p.setShortForm("help", "h");
		asdf.p.setShortForm("boolean1", "b");
		asdf.p.setShortForm("boolean2", "o");
		System.out.println(asdf.p.shortForm("help"));
		asdf.p.setOptionalArgumentType("help", Argument.dataType.BOOLEAN);
		asdf.p.setOptionalArgumentType("boolean1", Argument.dataType.BOOLEAN);
		asdf.p.setOptionalArgumentType("boolean2", Argument.dataType.BOOLEAN);
		String[] digits = {"digits", "4"};
		asdf.p.addOptionalArgument(digits);
		String[] type = {"type", "box"};
		asdf.p.addOptionalArgument(type);
		asdf.p.setShortForm("digits", "d");
		asdf.p.setShortForm("type", "t");
		System.out.println(asdf.p.getOptionalValue("type"));
		System.out.println(asdf.p.getOptionalValue("digits"));
			asdf.p.parseValues(args);
			System.out.println(asdf.p.getOptionalValue("help"));
			System.out.println(asdf.p.getOptionalValue("type"));
			System.out.println(asdf.p.getOptionalValue("digits"));
			System.out.println(asdf.p.getOptionalValue("boolean1"));
			System.out.println(asdf.p.getOptionalValue("boolean2"));
			System.out.println("poop");
	}

}