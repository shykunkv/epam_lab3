package parse;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.*;

public class XMLtoHTML {

	private String xml = null, xsl = null;

	public XMLtoHTML (String XML, String XSL) {
	this.xml = XML;
	this.xsl = XSL;
	}

	public void transform() {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory
					.newTransformer(new javax.xml.transform.stream.StreamSource(xsl));

			transformer.transform(new javax.xml.transform.stream.StreamSource(xml),
					new javax.xml.transform.stream.StreamResult(
					new FileOutputStream("Candy.html")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 /*public void transform()
	    {
	        try
	        {
	            TransformerFactory tFactory = TransformerFactory.newInstance();

	            Source xslDoc = new StreamSource(xsl);
	            Source xmlDoc = new StreamSource(xml);

	            String outputFileName = "Candy.html";
	            OutputStream htmlFile = new FileOutputStream(outputFileName);

	            Transformer transformer = tFactory.newTransformer(xslDoc);
	            transformer.transform(xmlDoc, new StreamResult(htmlFile));
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }*/
	
	
}
