package parse;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import mynamespace.*;

public class SAXPars {
	
	private String filename = null;
	private Candy candyCollection = null;
	public SAXPars(String filename) {
		this.filename = filename;
	}
	
	public void parse() {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            
            SAXParser saxParser = spf.newSAXParser();
            XMLReader reader = saxParser.getXMLReader();
            
            SAXParsH handler = new SAXParsH(filename);
            reader.setContentHandler(handler);
            reader.parse(filename);
            candyCollection = handler.getCandyCollection();
            
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.print("SAX parser error.");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.print("Configuration error.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("Input-output error.");
        }
    }
	
	public Candy getCandyCollection() {
		return candyCollection;
	}
}


