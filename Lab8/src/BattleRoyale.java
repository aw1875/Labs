import java.util.*;
import java.io.*;

public class BattleRoyale {

    /**
     * Create list of instructors from given file (command line) and simulate battle royal
     * @param args
     * @throws InterruptedException
     */
    public static void main (String [] args) throws InterruptedException {
        String file_name = args[0];
        int round = 1;
        int currentBattles = 0;
        int counter = 0;
        boolean winner = false;
        String winnerName = null;

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
<<<<<<< HEAD
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
=======
        System.out.println("The battle royal is about to begin");
        System.out.println("Round " + round + " is starting...");


        while (winner != true) {
            for (int i = 0; i < battles.length; i++) {
                if (instructors.size() > 2) {
                    battles[counter] = new Battle(instructors.get(0), instructors.get(1));
                    System.out.println("The battle between " + instructors.get(0).getName() + " and " + instructors.get(1).getName() + " has begun!!!");
                    instructors.remove(0);
                    instructors.remove(0);
                    counter++;
                    currentBattles++;
                } else if (instructors.size() == 2) {
                    battles[counter] = new Battle(instructors.get(0), instructors.get(1));
                    System.out.println("The battle between " + instructors.get(0).getName() + " and " + instructors.get(1).getName() + " has begun!!!");
                    instructors.remove(0);
                    instructors.remove(0);
                    counter++;
                    currentBattles++;
                } else {
                    if (instructors.size() == 0 && currentBattles == 1) {
                        battles[0].start();
                        battles[0].join();
                        winnerName = battles[0].getWinner().getName();
                        System.out.println("The battle royal has ended...");
                        winner = true;
                        break;
                    } else {
                        for (int j = 0; j < currentBattles; j++) {
                            battles[j].start();
                        }
                        for (int j = 0; j < currentBattles; j++) {
                            battles[j].join();
                            instructors.add(battles[j].getWinner());
                        }
                    }

                    round++;
                    counter = 0;
                    currentBattles = 0;
                    System.out.println("Round " + round + " is starting...");
                }
>>>>>>> dd56f85e6ecfc5dde4901fd80f5b92e36994b0d9
            }
        }
        System.out.println(winnerName + " is victorious!!!");
    }
}
