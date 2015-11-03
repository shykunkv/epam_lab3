package parse;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import mynamespace.*;

public class DOMParser {
	 
    private DocumentBuilderFactory docFactory = null;
    private DocumentBuilder docBuilder = null;
    private Document doc = null;
    private String filename = null;
    
    private static final ObjectFactory factory = new ObjectFactory();
    private Candy candyCollection = null;
     
    public DOMParser(String filename) {
    	this.filename = new String(filename);
    }
    
    public void parse() {
    	try {
            docFactory = DocumentBuilderFactory.newInstance();    
            docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.parse(filename); 
            candyCollection = new Candy();
            analysis();         
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
    }
    
	private void analysis() {
		NodeList candyList = doc.getElementsByTagName("candy");
		for (int i = 0; i < candyList.getLength(); i++) {
			Node c = candyList.item(i);
			if (c.getNodeType() == Node.ELEMENT_NODE) {
				Element candy = (Element) c;
				CandyType candyType = factory.createCandyType();
				candyType.setProduction(candy.getAttribute("production"));
				NodeList featureList = candy.getChildNodes();
				for (int j = 0; j < featureList.getLength(); j++) {
					Node f = featureList.item(j);
					if (f.getNodeType() == Node.ELEMENT_NODE) {
						Element feature = (Element) f;
						switch (feature.getTagName()) {
						case "name":
							candyType.setName(feature.getTextContent());
							break;
						case "energy":
							candyType.setEnergy(feature.getTextContent());
							break;
						case "type":
							candyType.setType(Type.valueOf(feature.getTextContent()));
							break;
						case "ingredients":
							candyType
									.setIngredients(analyseIngredients(feature));
							break;
						case "value":
							candyType.setValue(analyseValue(feature));
							break;
						}
					}
				}
				candyCollection.getCandy().add(candyType);
			}
		}
	}
	
	private Ingredients analyseIngredients(Element feature) {
		Ingredients ingredients = new Ingredients();
		NodeList ingredList = feature.getChildNodes();
		for (int k = 0; k < ingredList.getLength(); k++) {
			Node in = ingredList.item(k);
			if (in.getNodeType() == Node.ELEMENT_NODE) {
				Element ingredient = (Element) in;
				switch (ingredient.getTagName()) {
				case "water":
					BigDecimal water = new BigDecimal(ingredient
							.getTextContent().replaceAll(",", ""));
					ingredients.setWater(water);
					break;
				case "sugar":
					BigDecimal sugar = new BigDecimal(ingredient
							.getTextContent().replaceAll(",", ""));
					ingredients.setSugar(sugar);
					break;
				case "fructose":
					BigDecimal fructose = new BigDecimal(ingredient
							.getTextContent().replaceAll(",", ""));
					ingredients.setFructose(fructose);
					break;
				case "chocType":
					ingredients.setChocType(ingredient.getTextContent());
					break;
				case "vanillin":
					BigDecimal vanillin = new BigDecimal(ingredient
							.getTextContent().replaceAll(",", ""));
					ingredients.setVanillin(vanillin);
					break;
				}
			}
		}
		return ingredients;
	}
	
	private Value analyseValue(Element feature) {
		Value value = new Value();
		NodeList valueList = feature.getChildNodes();
		for (int k = 0; k < valueList.getLength(); k++) {
			Node v = valueList.item(k);
			if (v.getNodeType() == Node.ELEMENT_NODE) {
				Element curValue = (Element) v;
				switch (curValue.getTagName()) {
				case "proteins":
					BigDecimal proteins = new BigDecimal(curValue
							.getTextContent().replaceAll(",", ""));
					value.setProteins(proteins);
					break;
				case "fats":
					BigDecimal fats = new BigDecimal(curValue.getTextContent()
							.replaceAll(",", ""));
					value.setFats(fats);
					break;
				case "carbohydrates":
					BigDecimal carbohydrates = new BigDecimal(curValue
							.getTextContent().replaceAll(",", ""));
					value.setCarbohydrates(carbohydrates);
					break;
				}
			}
		}
		return value;
	}
	
	public Candy getCandyCollection() {
		return candyCollection;
	}

}

