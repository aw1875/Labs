package lab01.student;

import java.util.*;

public class SieveOfEratosthenes {
    public static int[] makeSieve (int upperBound)
    {
        int [] table = new int[upperBound + 1];
        for (int i = 0; i < upperBound; i++)
        {
            table[i] = 0;
        }

        // Set 0 and 1 to not prime as they are not prime numbers
        table[0] = 1;
        table[1] = 1;

        // Set all multiples of i to not prime (set = 1) as they would be divisible but i
        for (int i = 2; i * i <= upperBound; i++)
        {
            if (table[i] == 0)
            {
                for (int j = i; i * j <= upperBound; j++)
                {
                    table[i*j] = 1;
                }
            }
        }
        return table;
    }

    public static void main (String [] args)
    {

        /* Initiate input scanner */
        Scanner sc = new Scanner (System.in);
        System.out.println("Please enter an upper bound: ");
        int upperBound = sc.nextInt();

        /* Create a boolean to determine whether the program should repeat or not */
        boolean end = false;

        /* Create a table for the results */
        int [] table = makeSieve(upperBound);

        while (end != true)
        {
            System.out.println("Please enter a positive number (0 to quit): ");
            int number = sc.nextInt();

            // Error checking to make sure given number is less than upperBound
            if (number > upperBound)
            {
                System.out.println("Number greater than upper bound given, please try again!");
            }

            else if (number < 1) // If number is 0 or negative, end the loop and say goodbye
            {
                end = true;
                System.out.println("Goodbye!");
            }
            else
            {
                if (table[number] == 0)
                {
                    System.out.println(number + " is prime!");
                }
                else
                {
                    System.out.println(number + " is not prime.");
                }
            }
        }
    }
}
