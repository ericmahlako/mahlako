package za.multichoice.astar.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import za.multichoice.astar.common.Manhattan;
import za.multichoice.astar.common.ObstacleRegistry;

public class UnitTest {

	@Test
	public void testManhattanCost() {
		assertEquals("Result",3, (int)new Manhattan().getCost(3, 1, 3, 4));
	}
	
	public void testObstacleInstance(){
		assertEquals("Result","*",ObstacleRegistry.getInstance("*").getSymbol());
	}
}
