package edu.jsu.mcis;

import java.util.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.BufferedWriter;


public class XmlTool{
	
	public Parser load(String fileName){
		Parser p = new Parser();
		try{
			InputStream xmlFile = new FileInputStream(fileName);
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = parserFactory.newSAXParser();
			XmlHandler handler = new XmlHandler();
			saxParser.parse(xmlFile, handler);
			p = handler.getParser();
			return p;
		} catch (Exception ex){
			throw new XMLException("Something went wrong.");
		}
		
	}
	
	private String positional = null;
	private String named = null;
	private String name = null;
	private String position = null;
	private String type = null;
	private String shortName = null;
	private String Default = null;
	private ArrayList<String> argumentv;

	private class XmlHandler extends DefaultHandler{
		private String name, value, shortName, description;
		private Argument.dataType dataType;
		private int positionValue; 
		private Parser p;
		private boolean argumentsBool, positionalBool, namedBool, nameBool, typeBool, shortNameBool, defaultValueBool, positionBool, descriptionBool;
		
		public XmlHandler(){
			p = new Parser();
			name = "";
			description = "";
			value = "";
			shortName = "";
			descriptionBool = false;
			argumentsBool = false;
			positionalBool = false;
			namedBool = false;
			nameBool = false;
			typeBool = false;
			shortNameBool = false;
			defaultValueBool = false;
			positionBool = false;
		}
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			String currentTag = qName.toLowerCase();
			if(currentTag.equals("arguments"))
				argumentsBool = true;
			else if(currentTag.equals("positional"))
				positionalBool = true;
			else if(currentTag.equals("named"))
				namedBool = true;
			else if(currentTag.equals("name"))
				nameBool = true;
			else if(currentTag.equals("type"))
				typeBool = true;
			else if(currentTag.equals("shortname"))
				shortNameBool = true;
			else if(currentTag.equals("default"))
				defaultValueBool = true;
			else if(currentTag.equals("position"))
				positionBool = true;
			else if(currentTag.equals("description"))
				descriptionBool = true;
		}
		
		public void endElement(String uri, String localName, String qName){
			String currentTag = qName.toLowerCase();
			
			if(currentTag.equals("named")){
				if(shortName != "")
					p.addOptionalArgument(name, value, dataType, shortName);
				else
					p.addOptionalArgument(name, value, dataType);
				name = "";
				shortName = "";
				value = "";
			}
			else if(currentTag.equals("positional")){
				p.addArgument(name, dataType);
				name = "";
				dataType = Argument.dataType.STRING;
			}
			
			if(currentTag.equals("arguments"))
				argumentsBool = false;
			else if(currentTag.equals("positional"))
				positionalBool = false;
			else if(currentTag.equals("named"))
				namedBool = false;
			else if(currentTag.equals("name"))
				nameBool = false;
			else if(currentTag.equals("type"))
				typeBool = false;
			else if(currentTag.equals("shortname"))
				shortNameBool = false;
			else if(currentTag.equals("default"))
				defaultValueBool = false;
			else if(currentTag.equals("position"))
				positionBool = false;
			else if(currentTag.equals("description"))
				descriptionBool = true;
		}
		
		public void characters(char ch[], int start, int length) throws SAXException{
			if(argumentsBool){
				if(positionalBool){
					if(nameBool)
						name = new String(ch, start, length);
					else if(typeBool)
						dataType = dataTypeConversion(new String(ch, start, length));
					else if(descriptionBool)
						description = new String(ch, start, length);
					else if(positionBool)
						positionValue = Integer.parseInt(new String(ch, start, length));
				}
				else if(namedBool){
					if(nameBool)
						name = new String(ch, start, length);
					else if(typeBool)
						dataType = dataTypeConversion(new String(ch, start, length));
					else if(descriptionBool)
						description = new String(ch, start, length);
					else if(positionBool)
						positionValue = Integer.parseInt(new String(ch, start, length));
					else if(shortNameBool)
						shortName = new String(ch, start, length);
					else if(defaultValueBool)
						value = new String(ch, start, length);
				}
			}
		}
		
		public Parser getParser(){
			return p;
		}
		
		private Argument.dataType dataTypeConversion(String type) {
			if(type.equalsIgnoreCase("integer"))
				return Argument.dataType.INT;
			else if(type.equalsIgnoreCase("float"))
				return Argument.dataType.FLOAT;
			else if(type.equalsIgnoreCase("boolean"))
				return Argument.dataType.BOOLEAN;
			else
				return Argument.dataType.STRING;
		
		}
	}
	
	public void saveToXML(String fileName, Parser p) {
		BufferedWriter writer = null;
		String toBePrinted = "<arguments>\n";
		
		for (int i = 0; i < p.getNumOfPositionalArgs(); i++){
			toBePrinted += "\t<positional>\n";
			Argument a = p.getPositionalArg(i);
			toBePrinted += a.getPositionalXMLFormat() + "\n";
			toBePrinted += "\t\t<position>" + (i + 1) + "</position>\n";
			toBePrinted += "\t</positional>\n";
		}
		
		for (int i = 0; i < p.getNumOfNamedArgs(); i++){
			toBePrinted += "\t<named>\n";
			Argument a = p.getNamedArg(i);
			toBePrinted += a.getNamedXMLFormat() + "\n";
			toBePrinted += "\t</named>\n";
		}
		
		toBePrinted += "</arguments>";
		
		try
			{
				writer = new BufferedWriter( new FileWriter(fileName));
				writer.write(toBePrinted);

			}
		catch ( IOException e){
				System.out.println("IOException while trying to write file.");
			}
		finally
			{
				try
					{
						if ( writer != null)
						writer.close( );
					}
				catch ( IOException e){
					System.out.println("IOException while trying to close writer.");
					}
			}
		
	}
}