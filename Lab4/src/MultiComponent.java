import java.util.ArrayList;

public abstract class MultiComponent extends Component {
    protected ArrayList<Component> children;

    /**
     * Multicomponent constructor, call super class to create constructor.
     * @param name
     * @param source
     */
    protected MultiComponent(String name, Component source) {
        super(name, source);
        children = new ArrayList<Component>();
    }

    /**
     * Reset method
     */
    public void reset() {
        for (Component c: children) {
            c.reset();
        }
        currCurrent = 0;
    }
}