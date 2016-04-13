package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class ArgumentTest{
	
	private Argument a;
	

	@Test
	public void testThatNameIsCreated(){
		a = new Argument("length");
		assertEquals("length", a.getName());
	}
	
	@Test
	public void testThatdataTypeIsCreated(){
		a = new Argument("length", Argument.dataType.FLOAT);
		assertEquals(Argument.dataType.FLOAT, a.getDataType());
	}
	
	@Test
	public void testThatValueIsAdded(){
		a = new Argument("length", Argument.dataType.FLOAT);
		a.setValue("5");
		assertEquals("5", a.getValue());
	}
	
	@Test
	public void testThatShortFormIsSet(){
		a = new Argument("help", Argument.dataType.BOOLEAN);
		a.setShortForm("h");
		assertEquals("h", a.getShortForm());
	}
	
	@Test
	public void testThatDescriptionIsSet(){
		a = new Argument("help", Argument.dataType.BOOLEAN);
		a.setDescription("asdf");
		assertEquals("asdf", a.getDescription());
	}
	
	@Test
	public void TestThatDataTypeIsSet(){
		a = new Argument("help");
		a.setDataType(Argument.dataType.BOOLEAN);
		assertEquals(Argument.dataType.BOOLEAN, a.getDataType());
	}

}