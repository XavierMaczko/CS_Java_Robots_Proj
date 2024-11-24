package RobotSimulation;

import java.util.ArrayList;
import java.util.Random;

public class RobotArena {
    // setting attributes
    private int size_x;
    private int size_y;
    private Random RandomInt; // for the random robot locations
    private ArrayList<Robot> robots_list;

    // Constructor for arena, modified for random initializations, then the robot array list.
    public RobotArena(int size_x, int size_y) {
        this.size_x = size_x;
        this.size_y = size_y;
        this.RandomInt = new Random();
        this.robots_list = new ArrayList<>();
    }
    
    // getWidth() to get the width for the interface
    public int getWidth() {
    	return size_x;
    }
    
    // same for the height
    public int getHeight() {
    	return size_y;
    }
    
    // to return robot list for robot interface
    public ArrayList<Robot> getRobots() {
    	return robots_list;
    }

    // addRobot() method to add the robot
    public void addRobot() {
        int ran_x;
        int ran_y;
        boolean isTaken;

        // This generates random positions within the playable area
        do {
            ran_x = RandomInt.nextInt(size_x); // Random x within arena bounds
            ran_y = RandomInt.nextInt(size_y); // Random y within arena bounds
            isTaken = false;

            for (Robot robot : robots_list) { // Check if position is already occupied
                if (robot.getX() == ran_x && robot.getY() == ran_y) {
                    isTaken = true;
                    break;
                }
            }
        } while (isTaken);
        Robot newRobot = new Robot(ran_x, ran_y, Direction.getRandomDirection()); 
        robots_list.add(newRobot);
    }

    // displayArena() method to show the arena and robots using ConsoleCanvas
    public void displayArena() {
        // Create a ConsoleCanvas with the arena dimensions and a student ID
        ConsoleCanvas canvas = new ConsoleCanvas(size_x, size_y, "12345678");
        
        // Place each robot on the canvas
        for (Robot robot : robots_list) {
            // Offset the robot coordinates by 1 to fit inside the canvas (account for borders)
            canvas.showIt(robot.getX() + 1, robot.getY() + 1, 'R');
        }
        
        // Print the canvas
        System.out.println(canvas.toString());
    }

    // toString() method to print arena size & robot locations
    public String toString() {
        StringBuilder string = new StringBuilder("Arena size is " + size_x + "x" + size_y);

        if (robots_list.isEmpty()) { // If no robots, append appropriate message
            string.append(" and there are no robots.");
        } else {    
            string.append("."); // Proper grammar
            for (Robot robot : robots_list) {
                string.append("\n").append(robot.toString());
            }
        }
        return string.toString();
    }

    public static void main(String[] args) {
        RobotArena a = new RobotArena(20, 10); // creating robot arena and setting size
        a.addRobot();
        a.addRobot();
        a.addRobot(); // hooray now I can add multiple robots !
        
        // Display the arena with robots
        a.displayArena();
    }
}
