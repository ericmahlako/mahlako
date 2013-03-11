package za.multichoice.astart.common;

import java.util.Comparator;

public class TileComparator implements Comparator<Tile> { 

	public int compare(Tile arg0, Tile arg1) {
		float f = arg0.getEstimatedCost() + arg0.getPathCost();
		float of = arg1.getEstimatedCost() + arg1.getPathCost();

		if (f < of) {
			return -1;
		} else if (f > of) {
			return 1;
		} else {
			return 0;
		}
	}
}
