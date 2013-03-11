package za.multichoice.astart.common;

public abstract class Obstacle {

	private String symbol;
	private int cost;
	
	public Obstacle(String symbol, int cost){
		this.symbol = symbol;
		this.cost = cost;
	}
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int type) {
		this.cost = type;
	}
}
