package za.multichoice.astar.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import za.multichoice.astar.common.Manhattan;
import za.multichoice.astar.common.Path;
import za.multichoice.astar.common.PathFinder;
import za.multichoice.astar.common.Tile;
import za.multichoice.astar.common.TileComparator;
import za.multichoice.astar.common.TileMap;

public class AStarSeachAlgorithm  implements PathFinder {
	private List<Tile> closed = new ArrayList<Tile>();
	private List<Tile> open = new ArrayList<Tile>();
	private TileMap map;
	private int maxSearchDistance;
	private Tile[][] tiles;
	private Manhattan costCalculator;

	public AStarSeachAlgorithm(TileMap map, int maxSearchDistance) {
		this(map, maxSearchDistance, new Manhattan());
	}

	public AStarSeachAlgorithm(TileMap map, int maxSearchDistance,
			Manhattan costCalculator) {
		this.costCalculator = costCalculator;
		this.map = map;
		this.maxSearchDistance = maxSearchDistance;

		tiles = new Tile[map.getWidth()][map.getHeight()];
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {
				tiles[x][y] = new Tile(x, y);
			}
		}
	}

	public Path findPath(int sx, int sy, int tx, int ty) {

		if (map.walkable(tx, ty)) {
			return null;
		}

		tiles[sx][sy].setPathCost(0);
		tiles[sx][sy].setSearchDepth(0);
		closed.clear();
		open.clear();
		addToOpen(tiles[sx][sy]);

		tiles[tx][ty].setParentTile(null);

		int maxDepth = 0;
		while ((maxDepth < maxSearchDistance) && (open.size() != 0)) {

			Tile current = getFirstInOpen();
			if (current == tiles[tx][ty]) {
				break;
			}

			removeFromOpen(current);
			addToClosed(current);

			// Searching the surrounding tiles for walkable choices
			for (int x = -1; x < 2; x++) {
				for (int y = -1; y < 2; y++) {

					// not a neighbour, its the current tile
					if ((x == 0) && (y == 0)) {
						continue;
					}

					// determine the location of the neighbour and evaluate it
					int xp = x + current.getX();
					int yp = y + current.getY();

					if (isValidLocation(sx, sy, xp, yp)) {
						
						//cost of movement = path cost so far, plus the cost to move to the tile being considered.
						float nextStepCost = current.getPathCost()
								+ getMovementCost(current.getX(),
										current.getY(), xp, yp);
						Tile neighbour = tiles[xp][yp];
						map.searchedLocation(xp, yp);

						//evaluate the best move
						if (nextStepCost < neighbour.getPathCost()) {
							if (isInOpenList(neighbour)) {
								removeFromOpen(neighbour);
							}
							if (isInClosedList(neighbour)) {
								removeFromClosed(neighbour);
							}
						}

						if (!isInOpenList(neighbour)
								&& !(isInClosedList(neighbour))) {
							neighbour.setPathCost(nextStepCost);
							neighbour.setEstimatedCost(getEstimatedCost(xp, yp,
									tx, ty));
							maxDepth = Math.max(maxDepth,
									neighbour.setParentDepth(current));
							addToOpen(neighbour);
						}
					}
				}
			}
		}

		// If openList is empty, return null, ran out of search
		if (tiles[tx][ty].getParentTile() == null) {
			return null;
		}

		// Path from target back to start location from parent.
		Path path = new Path();
		Tile target = tiles[tx][ty];
		while (target != tiles[sx][sy]) {
			path.prependStep(target.getX(), target.getY());
			target = target.getParentTile();
		}

		path.prependStep(sx, sy);
		return path;
	}

	protected Tile getFirstInOpen() {
		return open.get(0);
	}

	protected void addToOpen(Tile node) {
		open.add(node);
		Collections.sort(open, new TileComparator());
	}

	protected boolean isInOpenList(Tile node) {
		return open.contains(node);
	}

	protected void removeFromOpen(Tile node) {
		open.remove(node);
	}

	protected void addToClosed(Tile node) {
		closed.add(node);
	}

	protected boolean isInClosedList(Tile tile) {
		return closed.contains(tile);
	}

	protected void removeFromClosed(Tile tile) {
		closed.remove(tile);
	}

	protected boolean isValidLocation(int sx, int sy, int x, int y) {
		boolean invalid = (x < 0) || (y < 0) || (x >= map.getWidth())
				|| (y >= map.getHeight());

		if ((!invalid) && ((sx != x) || (sy != y))) {
			invalid = map.walkable(x, y);
		}

		return !invalid;
	}

	public float getMovementCost(int sx, int sy, int tx, int ty) {
		return map.getCost(sx, sy, tx, ty);
	}

	public float getEstimatedCost(int x, int y, int tx, int ty) {
		return costCalculator.getCost(x, y, tx, ty);
	}
}