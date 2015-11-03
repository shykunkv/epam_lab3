package parse;

import java.math.BigDecimal;

import org.xml.sax.helpers.DefaultHandler; 
import org.xml.sax.*; 

import mynamespace.*;

public class SAXParsHandle extends DefaultHandler {
	String filename = null;
	String thisElement = "";
	private static final ObjectFactory factory = new ObjectFactory();
	private CandyType curCandy = null;
	private Candy candyCollection = null;
	private Ingredients ingredients = null;
	private Value value = null;

	public SAXParsHandle(String filename) {
		this.filename = new String(filename);
	}

	@Override
	public void startDocument() throws SAXException {}

	@Override
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		thisElement = qName;
		if ("tns:Candy".equals(qName)) {
			candyCollection = factory.createCandy();
		} else if ("candy".equals(qName)) {
			curCandy = factory.createCandyType();
			curCandy.setProduction(atts.getValue("production"));
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
		if (thisElement.equals("name")) {
			String info = new String(ch, start, length).trim();
			curCandy.setName(info);
		}
		if (thisElement.equals("energy")) {
			String info = new String(ch, start, length).trim();
			curCandy.setEnergy(info);
		}
		if (thisElement.equals("type")) {
			String info = new String(ch, start, length).trim();
			curCandy.setType(Type.valueOf(info));
		}
		if (thisElement.equals("ingredients")) {
			ingredients = factory.createIngredients();
			curCandy.setIngredients(ingredients);
		}
		if (thisElement.equals("water")) {
			String info = new String(ch, start, length).trim();
			BigDecimal water = new BigDecimal(info.replaceAll(",", ""));
			ingredients.setWater(water);
		}
		if (thisElement.equals("sugar")) {
			String info = new String(ch, start, length).trim();
			BigDecimal sugar = new BigDecimal(info.replaceAll(",", ""));
			ingredients.setSugar(sugar);
		}
		if (thisElement.equals("fructose")) {
			String info = new String(ch, start, length).trim();
			BigDecimal fructose = new BigDecimal(info.replaceAll(",", ""));
			ingredients.setFructose(fructose);
		}
		if (thisElement.equals("chocType")) {
			String info = new String(ch, start, length).trim();
			ingredients.setChocType(info);
		}
		if (thisElement.equals("vanillin")) {
			String info = new String(ch, start, length).trim();
			BigDecimal vanillin = new BigDecimal(info.replaceAll(",", ""));
			ingredients.setVanillin(vanillin);
		}
		if (thisElement.equals("value")) {
			value = factory.createValue();
			curCandy.setValue(value);
		}
		if (thisElement.equals("proteins")) {
			String info = new String(ch, start, length).trim();
			BigDecimal proteins = new BigDecimal(info.replaceAll(",", ""));
			value.setProteins(proteins);
		}
		if (thisElement.equals("fats")) {
			String info = new String(ch, start, length).trim();
			BigDecimal fats = new BigDecimal(info.replaceAll(",", ""));
			value.setFats(fats);
		}
		if (thisElement.equals("carbohydrates")) {
			String info = new String(ch, start, length).trim();
			BigDecimal carbohydrates = new BigDecimal(info.replaceAll(",", ""));
			value.setCarbohydrates(carbohydrates);
			
			candyCollection.getCandy().add(curCandy);
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