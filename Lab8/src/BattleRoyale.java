import java.util.ArrayList;
import java.io.*;

public class BattleRoyale {
    private ArrayList<Instructor> instructors;

    public ArrayList<Instructor> instructors(String file_name) {
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
        return instructors;
    }


    public static void main (String [] args) {
        String file_name = args[0];

    }
}
