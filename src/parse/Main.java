package parse;

import java.util.Collections;
import java.util.List;
import candy.*;

public class Main {

	public static void main(String[] args) {
		String XML = "src/Candy.xml";
		String XSD = "src/Candy.xsd";
		String XSL = "src/Candy.xsl";
		
		
		Validate validate = new Validate(XML, XSD);
		
		if (validate.isValid()) {
			System.out.println("XML is valid with this XSD");
		} else
			System.out.println("ERROR: XML is invalid");
		
		//DOMParser dom = new DOMParser(filenameXML);
		//dom.parse();
		//CandyCollection candyCollection = dom.getCandyCollection();
		//System.out.println(candyCollection.toString());
		
//		SAXPars sax = new SAXPars(filenameXML);
//		sax.parse();
//		CandyCollection candyCollection = sax.getCandyCollection();
//		System.out.println(candyCollection.toString());
		
//		StAXParser stax = new StAXParser(filenameXML);
//		stax.parse();
//		CandyCollection candyCollection = stax.getCandyCollection();
//		System.out.println(candyCollection.toString());
		
		/*Sorts the array list using comparator*/
		//Collections.sort(candyCollection.getCandyList());
		//System.out.println(candyCollection.toString());
		
		XMLtoHTML html = new XMLtoHTML(XML, XSL);
		html.transform();

	}


}
