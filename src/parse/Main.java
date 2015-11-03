package parse;

import java.util.Collections;
import java.util.List;

import mynamespace.*;

public class Main {

	public static void main(String[] args) {
		String filenameXML = "Candy.xml";
		String filenameXSD = "Candy.xsd";
		String filenameXSL = "CandyXSL.xsl";
		CheckXML check = new CheckXML(filenameXML, filenameXSD);
		if (check.check()) {
			System.out.println("Checking XML completed successfully");
		} else
			System.out.println("Checking XML failed");
		
		/*DOMParser dom = new DOMParser(filenameXML);
		dom.parse();
		Candy candy = dom.getCandyCollection();*/
		//candy.print();
		
		SAXPars sax = new SAXPars(filenameXML);
		sax.parse();
		//Candy candy = sax.getCandyCollection();
		//candy.print();
		
		/*StAXParser stax = new StAXParser(filenameXML);
		stax.parse();
		Candy candy = stax.getCandyCollection();*/
		//candy.print();
		
		/*Sorts the array list using comparator*/
		/*List<CandyType> list = candy.getCandy();
		Collections.sort(list, new CandyType());
		for (CandyType c : list)
			c.print();*/
		
		XMLtoHTML html = new XMLtoHTML("CandyXML.xml", filenameXSL);
		html.transform();

	}


}
