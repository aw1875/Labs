package lab01.student;

import java.util.*;

public class SieveOfEratosthenes {
    public static int[] makeSieve(int upperBound)
    {
        int [] table = new int[upperBound];

        for (int i = 0; i < upperBound; i++)
        {
            table[i] = 0;
        }

        for (int i = 2; i < Math.sqrt(upperBound); i++)
        {
            if (table[i] == 0)
            {

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

            if (number < 1)
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
