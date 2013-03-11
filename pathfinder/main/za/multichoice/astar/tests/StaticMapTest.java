package za.multichoice.astar.tests;

import za.multichoice.astar.common.Path;
import za.multichoice.astar.impl.AStarSeachAlgorithm;

public class StaticMapTest {

	private static final int MAX_PATH_LENGTH = 50;
	private static final int START_X = 0;
	private static final int START_Y = 0;
	private static final int GOAL_X = 4;
	private static final int GOAL_Y = 4;
	private static StaticMap map = new StaticMap();

	public static void main(String[] args) {
		AStarSeachAlgorithm pathFinder = new AStarSeachAlgorithm(map,
				MAX_PATH_LENGTH);
		Path path = pathFinder.findPath(START_X, START_Y, GOAL_X, GOAL_Y);

		int length = path.getLength();
		System.out.println("---------- |Original|-------------------");
		printMap();
		System.out.println("---------- |After Replacement|----------");
		replaceByBestPath(path, length);
		printMap();
		System.out.println("----------------------------------------");
	}

	private static void replaceByBestPath(Path path, int length) {
		for (int i = 0; i < length; i++) {
			map.getTerrain()[path.getX(i)][path.getY(i)].setSymbol("#");
		}
	}

	private static void printMap() {
		for (int xp = 0; xp < 5; xp++) {
			for (int yp = 0; yp < 5; yp++) {
				System.out.print(map.getTerrain()[xp][yp].getSymbol());
			}
			System.out.println("");
		}
	}
}
