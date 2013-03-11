package za.multichoice.astar.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import za.multichoice.astar.common.Manhattan;

public class UnitTest {

	@Test
	public void testManhattanCost() {
		assertEquals("Result",3, (int)new Manhattan().getCost(3, 1, 3, 4));
	}
}
