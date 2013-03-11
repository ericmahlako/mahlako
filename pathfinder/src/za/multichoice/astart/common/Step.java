package za.multichoice.astart.common;

public class Step {
	private int x;
	private int y;

	public Step(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int hashCode() {
		return x * y;
	}

	public boolean equals(Step other) {

		Step o = other;
		return (o.x == x) && (o.y == y);
	}
}
