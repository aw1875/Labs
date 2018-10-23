package lab01.student;

<<<<<<< HEAD
public class HTree {
=======
import static turtle.Turtle.*;

public class HTree
{
    static int MAX_SEGMENT_LENGTH = 200;

    public static void init (int length, int depth)
    {
        Turtle.setWorldCoordinates(-length * 2, - length * 2, length * 2, length * 2);
        Turtle.title("H-Tree, depth: " + depth);
    }

    public static void drawHTree (double length, int depth)
    {
        Turtle.speed(10); /* Set to 10 as there is an issue that creates dots when set to 0*/
        if (depth > 0)
        {
            // Start in center of H, move to upper left
            Turtle.forward(length/2);
            Turtle.left(90);
            Turtle.forward(length/2);
            Turtle.right(90);

            // Recurse
            drawHTree(length/2, depth - 1);

            // Move to lower right of H
            Turtle.right(90);
            Turtle.forward(length);
            Turtle.left(90);

            // Recurse
            drawHTree(length/2, depth - 1);

            //Move to upper left of H
            Turtle.left(90);
            Turtle.forward(length/2);
            Turtle.left(90);
            Turtle.forward(length);
            Turtle.right(90);
            Turtle.forward(length/2);
            Turtle.right(90);

            // Recurse
            drawHTree(length/2, depth - 1);

            // Move to lower left of H
            Turtle.right(90);
            Turtle.forward(length);
            Turtle.left(90);

            // Recurse
            drawHTree(length/2, depth - 1);

            // Return to center of H
            Turtle.left(90);
            Turtle.forward(length/2);
            Turtle.right(90);
            Turtle.forward(length/2);

        }
    }

    public static void main (String [] args)
    {
        if (args.length < 2)
        {
            System.out.println("IDK WHAT IS SUPPOSED TO BE HERE");
            return;
        }

        // Check the depth is >= 0
        int depth = Integer.parseInt(args[1]);
        if (depth < 0)
        {
            System.out.println("The depth must be greater than or equal to 0");
            return;
        }

        // Initialize turtle
        init(MAX_SEGMENT_LENGTH, depth);

        // Draw the h-tree
        drawHTree(MAX_SEGMENT_LENGTH, depth);

        // Close window
        System.out.println("Turtle has finished, please close the window.");

    }

>>>>>>> 3fb821ad75724b2a68e07786a4a15e4ef7f3221b
}
