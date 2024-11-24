package RobotSimulation;

import java.util.Scanner;

/**
* Simple program to show arena with multiple Robots
* @author shsmchlr
* with a few addons from myself with the occasional assistance of ChatGPT
*/
public class RobotInterface {
	
	private Scanner s; 				// scanner used for input from user
	private RobotArena myArena; 	// arena in which Robots are shown
	
	/**
	 * constructor for RobotInterface
	 * sets up scanner used for input and the arena
	 * then has main loop allowing user to enter commands
	 */
	public RobotInterface() {
		s = new Scanner(System.in); // set up scanner for user input
		myArena = new RobotArena(30, 10); // create arena of size 26x6, note this is the external size
		
		char ch = ' ';
		do {
			System.out.print("Enter (A)dd Robot, get (I)nformation, (M)ove robots, , A(N)imate the robots, (D)isplay Arena, or e(X)it > ");
			ch = s.next().charAt(0);
			s.nextLine();
			
			switch (ch) {
				case 'A':
				case 'a':
					Direction randomDirection = Direction.getRandomDirection();
					Robot newRobot = new Robot(10, 5, randomDirection); 
					myArena.addRobot(); // add a new Robot to arena
					break;
					
				case 'I':
				case 'i':
					System.out.print(myArena.toString()); // display arena details
					break;
					
				case 'M':
				case 'm':
					myArena.moveAllRobots();
					System.out.println("Robots have moved:");
					System.out.println(myArena.toString());
					break;
					
				case 'N':
				case 'n':
					// moves the robots 10 times and displays the result
					for (int i = 0; i <10; i++) {
						myArena.moveAllRobots();
						System.out.println("Move " +(i+1)+ " of 10:");
						System.out.println(myArena.toString());
						doDisplay();
						try {
							Thread.sleep(200); // 200 ms delay before next display
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					break;
					
				case 'D':
				case 'd':
					doDisplay(); // display the arena visually
					break;
					
				case 'X':
				case 'x':
					ch = 'X'; // when X detected, program ends
					break;
					
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (ch != 'X'); // test if end
		
		s.close(); // close scanner
	}
	
	/**
	 * Display the Robot arena on the console
	 */
	private void doDisplay() {
		// Determine the arena size
		int width = myArena.getWidth(); // get the width of the arena
		int height = myArena.getHeight(); // get the height of the arena
		
		// Create a suitable sized ConsoleCanvas object
		ConsoleCanvas canvas = new ConsoleCanvas(width, height, "32002993");
		
		// Call each robot to display itself on the canvas
		for (Robot robot : myArena.getRobots()) {
			try {
				robot.displayRobot(canvas); // use the Robot's display method
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			}
		}
		
		// Use the ConsoleCanvas.toString method to print the arena
		System.out.println(canvas.toString());
	}
	
	public static void main(String[] args) {
		RobotInterface r = new RobotInterface(); // just call the interface
	}	
}
