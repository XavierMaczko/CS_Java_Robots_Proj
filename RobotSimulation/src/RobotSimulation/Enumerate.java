package RobotSimulation;

import java.util.Random;

public class Enumerate {
	NORTH, EAST, SOUTH, WEST;
	
	// Random returning of any direction
	public static Direction getRandomDirection() {
		Random rand = new Random();
		return values()[rand.nextInt(values().length);]
	}
	
	public Direction getNextDirection() {
		Direction[] direction = Direction.values();
		return direction[(this.ordinal()+ 1) % directions.length];
	}

}
