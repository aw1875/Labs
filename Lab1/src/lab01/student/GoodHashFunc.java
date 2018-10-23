package lab01.student;

import java.util.*;

public class GoodHashFunc
{
<<<<<<< HEAD
    public static int computeHash(String str)
=======
    public static int computeHash (String str)
>>>>>>> 3fb821ad75724b2a68e07786a4a15e4ef7f3221b
    {
        int [] hash = new int[str.length()];

        for (int i = 0; i < str.length(); i++)
        {
            hash[i] = (str.charAt(i)) * (int)(Math.pow(31, str.length() -i -1));
        }

        int sum = 0;
        int i = 0;

        while (i < hash.length)
        {
            sum += hash[i];
            i++;
        }
        return sum;
    }

    public static void main (String [] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("Please enter a string: ");
        String str = sc.nextLine();
        int sum = computeHash(str);
        System.out.println("The computed hash for the specified string is: " + sum);
    }
}
