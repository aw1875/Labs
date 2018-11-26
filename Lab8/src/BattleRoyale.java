import java.util.*;
import java.io.*;

public class BattleRoyale {

    public static void main (String [] args) throws InterruptedException {
        String file_name = "src/b1.txt";
        int round = 1;
        boolean winner = false;

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
        System.out.println("The battle royal is about to begin");
        System.out.println("Round " + round + " is starting...");
        while (winner != true) {


            for (int i = 0; i < battles.length; i++) {
                if (instructors.size() > 2) {
                    battles[i] = new Battle(instructors.get(0), instructors.get(1));
                    System.out.println("The battle between " + instructors.get(0).getName() + " and " + instructors.get(1).getName() + " has begun!!!");
                    instructors.remove(0);
                    instructors.remove(0);
                    battles[i].start();
                } else {
                    /*if (battles[i].isAlive()) {
                        battles[i].join();
                        instructors.add(battles[i].getWinner());
                    } else {
                        instructors.add(battles[i].getWinner());
                    }*/

                    try {
                        for (int j = 0; j < battles.length; j++) {
                            battles[i].join();
                        }
                    } catch (InterruptedException e) {
                        System.out.println("ERROR");
                    }

                    round++;
                    System.out.println("Round " + round + " is starting...");
                }
            }



            /*for (int i = 0; i < battles.length; i++) {
                while (instructors.size() > 2) {
                    battles[i] = new Battle(instructors.get(0), instructors.get(1));
                    System.out.println("The battle between " + instructors.get(0).getName() + " and " + instructors.get(1).getName() + " has begun!!!");
                    instructors.remove(0);
                    instructors.remove(0);
                    battles[i].start();
                }

                for (int j = 0; j < battles.length; j++) {
                    battles[j].join();
                    instructors.add(battles[j].getWinner());
                }



                while (instructors.size() == 1) {
                    try {
                        battles[0].join();
                        System.out.println("\n\n\nWAITING!!!\n\n\n");
                        instructors.add(battles[i].getWinner());
                        wait();
                        System.out.println("TEST");
                    } catch (InterruptedException e) {}
                }

                if (instructors.size() <= 1) {
                    for (int j = 0; j < battles.length; j++) {
                        battles[j].join();
                    }
                    instructors.add(battles[i].getWinner());
                }
            }*/
        }
    }
}
