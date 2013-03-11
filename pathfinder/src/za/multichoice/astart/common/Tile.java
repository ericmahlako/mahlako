package za.multichoice.astart.common;


public class Tile{
	private float estimatedCost;
	private float pathCost;
	private int searchDepth;
	private int x;
	private int y;
	private Tile parentTile;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int setParentDepth(Tile parentTile) {
		searchDepth = parentTile.searchDepth + 1;
		this.parentTile = parentTile;
		return searchDepth;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getPathCost() {
		return pathCost;
	}

	public void setPathCost(float cost) {
		this.pathCost = cost;
	}

	public float getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(float heuristic) {
		this.estimatedCost = heuristic;
	}

	public int getSearchDepth() {
		return searchDepth;
	}

	public void setSearchDepth(int depth) {
		this.searchDepth = depth;
	}

	public Tile getParentTile() {
		return parentTile;
	}

	public void setParentTile(Tile parentTile) {
		this.parentTile = parentTile;
	}
}