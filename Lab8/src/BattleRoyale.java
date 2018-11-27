import java.util.*;
import java.io.*;

public class BattleRoyale {

    public static void main (String [] args) throws InterruptedException {
        String file_name = "src/b1.txt";
        int round = 1;

        ArrayList<Instructor> instructors = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file_name));
            String input;

            while((input = bf.readLine()) != null) {
                String currLine[] = input.split(",");
                Instructor newInstructor = new Instructor(currLine[0].trim(), Integer.parseInt(currLine[1].trim()), Integer.parseInt(currLine[2].trim()), Integer.parseInt(currLine[3].trim()), Integer.parseInt(currLine[4].trim()));
                instructors.add(newInstructor);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        Battle battles [] = new Battle[instructors.size()-1];
        while (true) {
            System.out.println("The battle royal is about to begin");
            System.out.println("Round " + round + " is starting...");
            for (int i = 0; i < battles.length; i++) {
                System.out.println("The battle between " + instructors.get(i).getName() + " and " + instructors.get(i+1).getName() + " has begun!!!");
                battles[i] = new Battle(instructors.get(0), instructors.get(1));
                battles[i].start();
            }
            for (int i = 0; i < battles.length; i++) {
                    battles[i].join();
            }
        }
    }
}
