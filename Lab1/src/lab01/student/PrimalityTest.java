package lab01.student;

import java.util.*;

public class PrimalityTest
{
    public static boolean isPrime(int number)
    {
        for (int i = 2; i <= Math.sqrt(number); i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main (String [] args)
    {
        /* Initiate input scanner */
        Scanner sc = new Scanner(System.in);

        /* Create a boolean to determine whether the program should repeat or not */
        boolean end = false;

        /* Create a boolean for the result */
        boolean result;

        /* While end is false, repeat the loop */
        while (end != true)
        {
            System.out.println("Enter a number (0 to quit): ");
            int number = sc.nextInt();

            /* Check if number is above 1 */
            if (number < 1)
            {
                end = true;
                System.out.println("Goodbye!");
            }
            else if (number > 1)
            {
                result = isPrime(number);
                if (result == true)
                {
                    System.out.println(number + " is prime!");
                }
                else
                {
                    System.out.println(number + " is not prime.");
                }
            }
            else
            {
                System.out.println(number + " is not prime.");
            }
        }
    }

}
