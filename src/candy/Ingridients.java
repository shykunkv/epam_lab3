package candy;

public class Ingridients {
	
	private int water;
	private int sugar;
	private int fructose;
	
	
	public Ingridients() {}


	public Ingridients(int water, int sugar, int fructose) {
		this.water = water;
		this.sugar = sugar;
		this.fructose = fructose;
	}


	public int getWater() {
		return water;
	}


	public void setWater(int water) {
		this.water = water;
	}


	public int getSugar() {
		return sugar;
	}


	public void setSugar(int sugar) {
		this.sugar = sugar;
	}


	public int getFructose() {
		return fructose;
	}


	public void setFructose(int fructose) {
		this.fructose = fructose;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\t\tWater: " + this.water + "\n");
		sb.append("\t\tSugar: " + this.sugar + "\n");
		sb.append("\t\tFructose: " + this.fructose + "\n");
		
		return sb.toString();
	}
	
}
