package RobotSimulation;

import java.util.Random;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;

	// Randomly returns one direction
	public static Direction getRandomDirection() {
		Random rand = new Random();
		return values()[rand.nextInt(values().length)];
	}
	
	// Returns the next direction that robot will face
	public Direction getNextDirection() {
		Direction[] directions = Direction.values();
		return directions[(this.ordinal() + 1) % directions.length];
	}
}
