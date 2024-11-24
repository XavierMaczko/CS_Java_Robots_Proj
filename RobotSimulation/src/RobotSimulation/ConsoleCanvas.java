package RobotSimulation;

public class ConsoleCanvas {
    // Attributes including arena 2D array
    private int canv_size_x;
    private int canv_size_y;
    private char[][] canv;
    private String Stud_ID;

    // Constructor for class
    public ConsoleCanvas(int canv_size_x, int canv_size_y, String Stud_ID) {
        this.canv_size_x = canv_size_x; // Plus 2 for the border
        this.canv_size_y = canv_size_y;
        this.Stud_ID = Stud_ID;

        // Initialises the canvas with correct dimensions
        canv = new char[this.canv_size_y][this.canv_size_x];

        // Fill the canvas / note I used ChatGPT as a reference for this section as it was fairly complicated 
        for (int i = 0; i < this.canv_size_y; i++) {
            for (int j = 0; j < this.canv_size_x; j++) {
                if (i == 0 || i == this.canv_size_y - 1) { // Top and bottom borders
                    if (i == 0 && j >= (this.canv_size_x - Stud_ID.length()) / 2 &&
                        j < (this.canv_size_x + Stud_ID.length()) / 2) {
                        // Puts student id at the centre of the top
                        canv[i][j] = Stud_ID.charAt(j - (this.canv_size_x - Stud_ID.length()) / 2);
                    } else {
                        canv[i][j] = '@';
                    }
                } else if (j == 0 || j == this.canv_size_x - 1) {
                    canv[i][j] = '@';
                } else { 
                    canv[i][j] = ' ';
                }
            }
        }
    }

    public void showIt(int x, int y, char symbol) {
        if (x > 0 && x < canv_size_x - 1 && y > 0 && y < canv_size_y - 1) {
            canv[y][x] = symbol;
        } else {
            throw new IllegalArgumentException("Robot out of bounds");
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (char[] row : canv) {
            builder.append(row).append('\n');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ConsoleCanvas c = new ConsoleCanvas(20, 5, "32002993"); 
        c.showIt(4, 3, 'R'); 
        System.out.println(c.toString()); 
    }
}