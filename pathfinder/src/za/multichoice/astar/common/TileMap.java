package za.multichoice.astar.common;

public interface TileMap {
	
	public int getWidth();
	public int getHeight();
	public void searchedLocation(int x, int y);
	public boolean walkable(int x, int y);
	public float getCost(int sx, int sy, int tx, int ty);
}
