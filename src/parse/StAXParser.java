package parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import mynamespace.*;

@SuppressWarnings("serial")
public class StAXParser extends XMLStreamException {
	private String filename = null;
	private XMLInputFactory XMLfactory = null;
	private XMLStreamReader reader = null;
	
	private static final ObjectFactory factory = new ObjectFactory();
	private Candy candyCollection = null;
	private CandyType curCandy = null;
	private Ingredients ingredients = null;
	private Value value = null;

	public StAXParser(String filename) {
		this.filename = filename;
		XMLfactory = XMLInputFactory.newInstance();
	}
	
	public void parse() {
		try {
			try {
				reader = XMLfactory.createXMLStreamReader(new FileInputStream(filename));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			analyse();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
	}
	
	private void analyse() {
		int event;
		try {
			while (reader.hasNext()) {
				event = reader.next();
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:

					if ("Candy".equals(reader.getLocalName())) {
						candyCollection = factory.createCandy();
					} else if ("candy".equals(reader.getLocalName())) {
						curCandy = factory.createCandyType();
						curCandy.setProduction(reader.getAttributeValue(0));
						candyCollection.getCandy().add(curCandy);
					}
					else if ("name".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						curCandy.setName(info);
					} else if ("energy".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						curCandy.setEnergy(info);
					} else if ("type".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						curCandy.setType(Type.valueOf(info));
					} else if ("ingredients".equals(reader.getLocalName())) {
						ingredients = factory.createIngredients();
						curCandy.setIngredients(ingredients);
					} else if ("water".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						BigDecimal water = new BigDecimal(info.replaceAll(",",
								""));
						ingredients.setWater(water);
					} else if ("sugar".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						BigDecimal sugar = new BigDecimal(info.replaceAll(",",
								""));
						ingredients.setSugar(sugar);
					} else if ("fructose".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						BigDecimal fructose = new BigDecimal(info.replaceAll(
								",", ""));
						ingredients.setFructose(fructose);
					} else if ("chocType".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						ingredients.setChocType(info);
					} else if ("vanillin".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						BigDecimal vanillin = new BigDecimal(info.replaceAll(
								",", ""));
						ingredients.setVanillin(vanillin);
					} else if ("value".equals(reader.getLocalName())) {
						value = factory.createValue();
						curCandy.setValue(value);
					} else if ("proteins".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						BigDecimal proteins = new BigDecimal(info.replaceAll(
								",", ""));
						value.setProteins(proteins);
					} else if ("fats".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						BigDecimal fats = new BigDecimal(info.replaceAll(",",
								""));
						value.setFats(fats);
					} else if ("carbohydrates".equals(reader.getLocalName())) {
						String info = new String(reader.getElementText().trim());
						BigDecimal carbohydrates = new BigDecimal(
								info.replaceAll(",", ""));
						value.setCarbohydrates(carbohydrates);
					}
					break;
				case XMLStreamConstants.START_DOCUMENT:
					candyCollection = factory.createCandy();
					break;
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
	
	public Candy getCandyCollection() {
		return candyCollection;
	}

	

}
