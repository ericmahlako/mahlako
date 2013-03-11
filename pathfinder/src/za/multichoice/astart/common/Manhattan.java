package za.multichoice.astart.common;

public class Manhattan {

	public float getCost(int x, int y, int tx,
			int ty) {
		return (Math.abs(x - tx) + Math.abs(y - ty));
	}
}
