import java.io.*;

public class EscapeIce {
    public static void constructGraph(File filename) {
        int height = 0;
        int width = 0;
        int escapeLine = 0;
        int x = 0;
        int y = 0;
        LinkedGraph g1 = new LinkedGraph();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            String input = bf.readLine();
            String[] currLine = input.split(" ");
            height = Integer.parseInt(currLine[0]);
            width = Integer.parseInt(currLine[1]);
            escapeLine = Integer.parseInt(currLine[2]);

            while ((input = bf.readLine()) != null) {
                //LinkedNode escapeNode = new LinkedNode("finish");
                currLine = input.split(" ");
                for (int i = 0; i < currLine.length; i++) {
                    if (!currLine[i].equals("*")) {
                        g1.makeNode(x + "," + y);
                    }
                    x += 1;
                }
                x = 0;
                y += 1;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static void main (String [] args) {
        File f1 = new File("src/t1.txt");
        constructGraph(f1);
    }
}
