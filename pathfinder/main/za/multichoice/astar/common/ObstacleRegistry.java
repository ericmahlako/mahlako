package za.multichoice.astar.common;

import java.util.HashMap;
import java.util.Map;

import za.multichoice.astar.common.obstacles.AmpersandFlatland;
import za.multichoice.astar.common.obstacles.CrossFlatland;
import za.multichoice.astar.common.obstacles.DotFlatland;
import za.multichoice.astar.common.obstacles.Forest;
import za.multichoice.astar.common.obstacles.Mountain;
import za.multichoice.astar.common.obstacles.Water;

public class ObstacleRegistry {

	private static Map<String, Class<? extends Obstacle>> obstacles;

	static {

		obstacles = new HashMap<String, Class<? extends Obstacle>>();
		obstacles.put("~", Water.class); 
		obstacles.put("@", AmpersandFlatland.class);
		obstacles.put("X", CrossFlatland.class);
		obstacles.put(".", DotFlatland.class);
		obstacles.put("*", Forest.class);
		obstacles.put("^", Mountain.class);
	}

	@SuppressWarnings("unchecked")
	public static <T extends Obstacle> T getInstance(String symbol) {

		T instance = null;
		try {
			if (instance == null) {
				instance = (T) obstacles.get(symbol).newInstance();
			}
		} catch (IllegalAccessException e) {
			// throw new SystemException(e);
		} catch (InstantiationException e) {
			// throw new SystemException(e);
		}
		return instance;
	}
}
