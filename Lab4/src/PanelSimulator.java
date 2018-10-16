/**
 * file: PanelSimulator.java
 * language: java
 * author: Adam Wolf
 */

import java.util.*;

public class PanelSimulator {

    /**
     * Read user input and distinguish between different types of input
     */
    public static void runSimulation() {
        boolean breakLoop = false;
        Scanner sc = new Scanner(System.in);
        while (breakLoop != true) {
            String currentLine [] = sc.nextLine().split(" ");
            switch (currentLine[0]) {
                case "A":
                    switch (currentLine[1]) {
                        case "C":
                            System.out.println(currentLine[0] + " " + currentLine[1] + " " + currentLine[2] + " " + currentLine[3] + " " + currentLine[4]);
                            break;
                        case "R":
                            System.out.println(currentLine[0] + " " + currentLine[1] + " " + currentLine[2] + " " + currentLine[3] + " " + currentLine[4]);
                            break;
                        case "A":
                            System.out.println(currentLine[0] + " " + currentLine[1] + " " + currentLine[2] + " " + currentLine[3] + " " + currentLine[4]);
                            break;
                    }
                    break;
                case "D":
                    System.out.println(currentLine[0] + " " + currentLine[1]);
                    break;
                case "T":
                    System.out.println(currentLine[0] + " " + currentLine[1]);
                    break;
                case "Q":
                    breakLoop = true;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }

    /**
     * Call runSimulation method
     * @param args
     */
    public static void main (String [] args) {
        runSimulation();
    }
}
