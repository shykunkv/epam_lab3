package parse;

import java.math.BigDecimal;

import org.xml.sax.helpers.DefaultHandler; 
import org.xml.sax.*; 

import mynamespace.*;

public class SAXParsH extends DefaultHandler {
	String filename = null;
	String thisElement = "";
	private static final ObjectFactory factory = new ObjectFactory();
	private CandyType curCandy = null;
	private Candy candyCollection = null;
	private Ingredients ingredients = null;
	private Value value = null;

	public SAXParsH(String filename) {
		this.filename = new String(filename);
	}

	@Override
	public void startDocument() throws SAXException {}

	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		thisElement = qName;
		if ("candy".equals(qName)) {
			System.out.println("production: " + atts.getValue("production"));
		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		thisElement = "";
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (thisElement.equals("water")) {
			String info = new String(ch, start, length).trim();
			BigDecimal water = new BigDecimal(info.replaceAll(",", ""));
			System.out.println("water: " + water);
		}
	}

	@Override
	public void endDocument() {
		curCandy = null;
		ingredients = null;
		value = null;
	}

	public Candy getCandyCollection() {
		return candyCollection;
	}

}