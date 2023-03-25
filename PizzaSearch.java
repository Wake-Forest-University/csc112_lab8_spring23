/**
 * CSC 112 Lab8 (PizzaSearch) Spring 2023
 * This program simulates a grad student searching for pizza in
 * a randomly generated floor plan. The floor plan size and 
 * random number seed are user inputs.
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Mar. 25, 2023
 */
import java.util.Scanner;
import java.util.Random;


public class PizzaSearch {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // keyboard
        int seed = 0;      // seed for random number
        int matDimen = 0;  // number of rows and number of columns

        // read in the floor plan size and random number seed
        System.out.print("Enter size and seed -> ");
        matDimen = keyboard.nextInt();
        seed = keyboard.nextInt();

        // make certain user input is correct, otherwise fail gracefully
        if(matDimen < 2) {
           System.out.println("maze dimension is " + matDimen + ", must be >= 2 ");
           return;
        }
        else if(seed <= 0) {
           System.out.println("seed is " + seed + ", must be > 0 ");
           return;
        }

        // generate the random floor plan
        char[][] floor = generateFloorPlan(matDimen, seed);
        Stack<Move> steps = new LinkedList<Move>();  // stack for moves taken
        int numMoves = 0;  // total number of moves

        // search for that pizza...
        System.out.println("Original floor plan");  
        printFloorPlan(floor);  
        System.out.println("");  
        numMoves = findPath(floor, steps);
        printFinalPath(floor, steps, numMoves);  
    }


    /**
     * This method generates a random floor plan with dimensions 
     * matDimen by maxDimen.
     *
     * @param matDimen is the number of rows and number of columns
     * @param seed is the random number seed
     */
    public static char[][] generateFloorPlan(int matDimen, int seed) {
        char[][] floor = new char[matDimen][matDimen];
        Random random = new Random(seed);

        for(int i = 0; i < matDimen; i++)
            for(int j = 0; j < matDimen; j++)
                floor[i][j] = (random.nextInt()%2 == 0 ? '0' : '1');
        // make certain there is an entrance and exit
        floor[0][0] = floor[matDimen - 1][matDimen - 1] = '0';  
        return floor;
    }


    /**
     * This method will print the floor plan to the screen in matrix format.
     *
     * @param floor char matrix of the floor plan
     */
    public static void printFloorPlan(char[][] floor) {
    }


    /**
     * This method will attempt to find a path given a floor plan.
     *
     * @param floor char matrix of the floor plan
     * @param path Stack<Move> of the moves taken
     */
    public static int findPath(char[][] floor, Stack<Move> path) {
        int numMoves = 0;

        // a lot of code here, hear?  

        return numMoves;  
    }


    /**
     * This method will print the final floor plan and path (if it exists).  
     *
     * @param floor char matrix of the floor plan
     * @param path Stack<Move> of the moves taken
     * @param numMoves int for the number of moves taken
     */
    public static void printFinalPath(char[][] floor, Stack<Move> path, int numMoves) {
        System.out.println("solution at http://goo.gl/rxnHB1 ");  
    }


    /**
     * The method will pause the program until the user presses 
     * the "Return" key.
     */
    public static void pause() {
        System.out.println("Press Return key to continue... ");
        try {  System.in.read(); }  
        catch(Exception e){  } 
    }

}


/**
 * Class that stores a move (row and column indices)
 */
class Move {  
    private int row = 0;  // row location of a move
    private int col = 0;  // column location of a move
                          //
    public Move(int row, int col) {  this.row = row; this.col = col;  }
    public int getRow(){  return row;  }
    public int getCol(){  return col;  }

    @Override
    public String toString() {  return new String("(" + row + ", " + col + ")");  }
}


