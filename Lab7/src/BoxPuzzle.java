import java.io.*;
import java.util.*;

public class BoxPuzzle implements Configuration {

    private int[][] box;
    private ArrayList<Item> items = new ArrayList<>();

    /**
     * Will take in a int height of box, int width of the box, and a string file name.
     * It will use the file name to obtain a list of items from the file. The width and
     * height is of the box currently trying to be solved for.
     *
     * @param height    - int height of box.
     * @param width     - int width of box.
     * @param file_name - string file_name with information of box.
     */
    public BoxPuzzle(int height, int width, String file_name) {
        this.box = new int[height][width];

        try {
            BufferedReader bf = new BufferedReader(new FileReader(file_name));
            String input;
            while ((input = bf.readLine()) != null) {
                String currLine[] = input.split(" ");
                Item currItem = new Item(currLine[0], Integer.parseInt(currLine[1]), Integer.parseInt(currLine[2]));
                this.items.add(currItem);

            }
            bf.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Please check the current directory.");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    /**
     * Copy constructor that will copy the BoxPuzzle passed in.
     *
     * @param box - BoxPuzzle to create copy of.
     */
    public BoxPuzzle(BoxPuzzle box) {
        this.box = new int[box.box.length][box.box[0].length];
        for (int i = 0; i < box.box.length; i++) {
            this.box[i] = box.box[i];
        }

    }

    /**
     * Get the collection of successors from the current one.
     *
     * @return All successors, valid and invalid.
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> successors = new ArrayList<>();
        int currItem = 0;
        int width = this.items.get(currItem).getWidth();
        int height = this.items.get(currItem).getHeight();
        for (int i = 0; i < (box.length - width); i++) {
            for (int j = 0; j < (box[i].length - height); j++) {
                if (box[i][j] == 0) {
                    BoxPuzzle successor = new BoxPuzzle(this);
                    while (i < width) {
                        while (i < height) {
                            successor.box[i][j] = Integer.valueOf(items.get(currItem).getName());
                            j++;
                            if (j == height) {
                                j = 0;
                                break;
                            }
                        }
                        i++;
                        if (i == width) {
                            i = 0;
                            break;
                        }
                    }
                    successors.add(successor);
                    return successors;
                }
            }
        }
        return successors;
    }

    /**
     * Is the current configuration valid or not?
     *
     * @return true if valid; false otherwise.
     */
    @Override
    public boolean isValid() {
        return false;
    }

    /**
     * Is the current configuration a goal?
     *
     * @return true if goal; false otherwise.
     */
    @Override
    public boolean isGoal() {
        for (Item n : items) {
            String name = n.getName();
            for (int i = 0; i < box.length; i++) {
                for (int j = 0; j < box[i].length; j++) {
                    if (String.valueOf(box[i][j]) == name) {
                        items.remove(n);
                    }
                }
            }
        }
        if (items.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print out the BoxPuzzle.
     *
     * @return string containing BoxPuzzle.
     */
    @Override
    public String toString() {
        String result = "";
        for (int[] row : box) {
            for (int col : row) {
                result += (col + " ");
            }
            result += "\n";
        }
        return result;
    }

    /**
     * Obtain file name from command line.
     * Use Backtracker and BoxPuzzle class to find the smallest box the items will fit in.
     * Print the solution when found and tell if it worked or not.
     *
     * @param args - command line arguments.
     */
    public static void main(String[] args) {
        int height = 1;
        int width  = 1;
        String file_name = args[0];

        BoxPuzzle b1 = new BoxPuzzle(7, 7, file_name);
        Backtracker bt = new Backtracker(true);
        Optional<Configuration> result = bt.solve(b1);
        if (!result.isPresent()) {
            System.out.println("No solution found for this size.\n");
        } else {
            System.out.println("Solution found: \n" + result.get());
            //break;
        }


        /*while (true) {
            System.out.println("Trying box size: " + height + " x " + width);
            BoxPuzzle b1 = new BoxPuzzle(height, width, file_name);
            Backtracker bt = new Backtracker(false);
            Optional<Configuration> result = bt.solve(b1);
            if (!result.isPresent()) {
                System.out.println("No solution found for this size.\n");
            } else {
                System.out.println("Solution found: \n" + result.get());
                break;
            }
            height++;
            width++;
        }*/
    }
}

class Item {
    private String name;
    private int width;
    private int height;

    /**
     * Item constructor that takes in name, width, and height and sets corresponding values.
     *
     * @param name   - Item name
     * @param width  - Item width
     * @param height - Item height
     */
    public Item(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    /**
     * Get name of Item
     *
     * @return string of name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get width of Item
     *
     * @return int of width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Get heigh of Item
     *
     * @return int of height
     */
    public int getHeight() {
        return this.height;
    }

}
