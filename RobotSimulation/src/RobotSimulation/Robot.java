package RobotSimulation;

public class Robot {
	// setting attributes & static uniqueID
	private int x;
	private int y;
	private String uniqueID;
	private static int Robots = 1;
	
	// Constructor for robot
	public Robot(int x, int y) {
		this.uniqueID = "R" +Robots++;
		this.x = x;
		this.y = y;
	}
	
	// Had to make getters for x and y for when checking if position is taken.
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void displayRobot(ConsoleCanvas c) {
		c.showIt(x, y, 'R');
	}
	
	// toString Method
	public String toString() {
		return "Robot " +uniqueID+ " is at (" +x+ ", " +y+ ")"; 
	}
	
	public static void main(String[] args) {
		Robot d = new Robot(5, 3); // creates robot d at position 5, 3
		System.out.println(d.toString()); // prints the location of the robot
		
		Robot e = new Robot(6, 2); // testing for second robot (robot e)
		System.out.println(e.toString()); // its working ! <3
		
	}
}
