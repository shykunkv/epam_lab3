package parse;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class CheckXML {
	String filenameXML = null;
	String filenameXSD = null;
	
	public CheckXML(String filenameXML, String filenameXSD) {
		this.filenameXML = new String(filenameXML);
		this.filenameXSD = new String(filenameXSD);
	}
	public boolean check() {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(filenameXSD));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(filenameXML)));
		} catch (SAXParseException e) {
			System.out.println("SAX Parse Exception: line " + e.getLineNumber() + ".\n" + e.getMessage());
			return false;
		} catch (SAXException e) {
			System.out.print("Global SAX Exception:\n" + e.getMessage());    
		} catch (IOException e) {
			System.out.print("Input/Output Stream Exception:\n" + e.getMessage());
		}
		return true;
	}
	
}