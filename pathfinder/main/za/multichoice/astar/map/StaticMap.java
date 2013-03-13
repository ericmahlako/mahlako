package za.multichoice.astar.map;

import za.multichoice.astar.common.MapBuilder;
import za.multichoice.astar.common.obstacles.AmpersandFlatland;
import za.multichoice.astar.common.obstacles.CrossFlatland;
import za.multichoice.astar.common.obstacles.DotFlatland;
import za.multichoice.astar.common.obstacles.Forest;
import za.multichoice.astar.common.obstacles.Mountain;
import za.multichoice.astar.common.obstacles.Water;


public class StaticMap extends MapBuilder
{

	private final int WIDTH = 5;
	private final int HEIGHT = 5;

	public StaticMap() {

		super.init();
	}

	@Override
	public void beforeInit() {

		setWidth(WIDTH);
		setHeight(HEIGHT);
	}

	public void buildMap() {

		// Row 1
		addObstacleToMap(0, 0, new AmpersandFlatland());
		addObstacleToMap(0, 1, new Forest());
		addObstacleToMap(0, 2, new Mountain());
		addObstacleToMap(0, 3, new Mountain());
		addObstacleToMap(0, 4, new Mountain());

		// //Row 2
		addObstacleToMap(1, 0, new Water());
		addObstacleToMap(1, 1, new Water());
		addObstacleToMap(1, 2, new Forest());
		addObstacleToMap(1, 3, new Water());
		addObstacleToMap(1, 4, new DotFlatland());

		// Row 3
		addObstacleToMap(2, 0, new Forest());
		addObstacleToMap(2, 1, new Forest());
		addObstacleToMap(2, 2, new DotFlatland());
		addObstacleToMap(2, 3, new DotFlatland());
		addObstacleToMap(2, 4, new DotFlatland());

		// Row 4
		addObstacleToMap(3, 0, new Mountain());
		addObstacleToMap(3, 1, new DotFlatland());
		addObstacleToMap(3, 2, new DotFlatland());
		addObstacleToMap(3, 3, new Forest());
		addObstacleToMap(3, 4, new Water());

		// Row 5
		addObstacleToMap(4, 0, new Water());
		addObstacleToMap(4, 1, new Water());
		addObstacleToMap(4, 2, new Forest());
		addObstacleToMap(4, 3, new Water());
		addObstacleToMap(4, 4, new CrossFlatland());
	}
}
