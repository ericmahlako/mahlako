package za.multichoice.astar.tests;

import za.multichoice.astar.common.Obstacle;
import za.multichoice.astar.common.TileMap;
import za.multichoice.astar.common.obstacles.AmpersandFlatland;
import za.multichoice.astar.common.obstacles.CrossFlatland;
import za.multichoice.astar.common.obstacles.DotFlatland;
import za.multichoice.astar.common.obstacles.Forest;
import za.multichoice.astar.common.obstacles.Mountain;
import za.multichoice.astar.common.obstacles.Water;

public class StaticMap implements TileMap {
	
	private final int WIDTH = 5;
	private final int HEIGHT = 5;
	private Obstacle[][] terrain = new Obstacle[WIDTH][HEIGHT];
	private boolean[][] visited = new boolean[WIDTH][HEIGHT];

	public StaticMap() {
		// Row 1
		addObstacle(0, 0, 1, 1, new AmpersandFlatland());
		addObstacle(0, 1, 1, 1, new Forest());
		addObstacle(0, 2, 1, 1, new Mountain());
		addObstacle(0, 3, 1, 1, new Mountain());
		addObstacle(0, 4, 1, 1, new Mountain());

		// //Row 2
		addObstacle(1, 0, 1, 1, new Water());
		addObstacle(1, 1, 1, 1, new Water());
		addObstacle(1, 2, 1, 1, new Forest());
		addObstacle(1, 3, 1, 1, new Water());
		addObstacle(1, 4, 1, 1, new DotFlatland());

		// Row 3
		addObstacle(2, 0, 1, 1, new Forest());
		addObstacle(2, 1, 1, 1, new Forest());
		addObstacle(2, 2, 1, 1, new DotFlatland());
		addObstacle(2, 3, 1, 1, new DotFlatland());
		addObstacle(2, 4, 1, 1, new DotFlatland());

		// Row 4
		addObstacle(3, 0, 1, 1, new Mountain());
		addObstacle(3, 1, 1, 1, new DotFlatland());
		addObstacle(3, 2, 1, 1, new DotFlatland());
		addObstacle(3, 3, 1, 1, new Forest());
		addObstacle(3, 4, 1, 1, new Water());

		// Row 5
		addObstacle(4, 0, 1, 1, new Water());
		addObstacle(4, 1, 1, 1, new Water());
		addObstacle(4, 2, 1, 1, new Forest());
		addObstacle(4, 3, 1, 1, new Water());
		addObstacle(4, 4, 1, 1, new CrossFlatland());
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public void searchedLocation(int x, int y) {
		visited[x][y] = true;
	}

	@Override
	public boolean walkable(int x, int y) {
		return terrain[x][y].getCost() == 0;
	}

	@Override
	public float getCost(int sx, int sy, int tx, int ty) {
		return terrain[sx][sy].getCost();
	}

	public Obstacle[][] getTerrain() {
		return terrain;
	}
	
	private void addObstacle(int x, int y, int width, int height,
			Obstacle obstacle) {
		for (int xp = x; xp < x + width; xp++) {
			for (int yp = y; yp < y + height; yp++) {
				terrain[xp][yp] = obstacle;
			}
		}
	}
}
