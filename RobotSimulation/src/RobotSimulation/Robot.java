package RobotSimulation;

public class Robot {
	// setting attributes & static uniqueID
	private int x;
	private int y;
	private String uniqueID;
	private static int Robots = 1;
	private Direction direction; // adding the direction the robot is facing
	
	// Constructor for robot
	public Robot(int x, int y, Direction direction) {
		this.uniqueID = "R" +Robots++;
		this.x = x;
		this.y = y;
		this.direction = direction;
		
	}
	
	// Had to make getters for x and y for when checking if position is taken.
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public void move() {
		switch (direction) {
		case NORTH:
			y--;
			break;
		case EAST:
			x++;
			break;
		case SOUTH:
			y++;
			break;
		case WEST:
			x--;
			break;
		}
	}
	
	public void displayRobot(ConsoleCanvas c) {
		c.showIt(x, y, 'R');
	}
	
	// toString Method
	public String toString() {
		return "Robot " +uniqueID+ " is at (" +x+ ", " +y+ "), and is facing " +direction; 
	}
	
	public static void main(String[] args) {
		Robot d = new Robot(5, 3, Direction.EAST); // creates robot d at position 5, 3
		System.out.println(d.toString()); // prints the location of the robot
		
		Robot e = new Robot(6, 2, Direction.WEST); // testing for second robot (robot e)
		System.out.println(e.toString()); // its working ! <3
		
	}
}
