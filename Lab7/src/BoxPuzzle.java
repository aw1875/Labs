import java.util.Collection;

public class BoxPuzzle implements Configuration {
    int height;
    int width;
    String file_name;

    public BoxPuzzle (int height, int width, String file_name) {
        this.height = height;
        this.width = width;
        this.file_name = file_name;
    }

    public BoxPuzzle (BoxPuzzle b1) {
        BoxPuzzle b2 = b1;
    }

    @Override
    public Collection<Configuration> getSuccessors() {
        return null;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public boolean isGoal() {
        return false;
    }
}
