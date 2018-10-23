/**
 * file: Component.java
 * language: java
 * author: Adam Wolf
 */

public abstract class Component {
    protected int currCurrent;
    protected String name;
    protected Component source;

    /**
     * Component constructor, set name and source to given name and source and set currCurrent to 0
     * @param name
     * @param source
     */
    protected Component (String name, Component source) {
        this.name = name;
        this.source = source;
        currCurrent = 0;
    }

    /**
     * Add method
     * @param newElem
     * @return
     */
    public abstract boolean add(Component newElem);

    /**
     * Reset method
     */
    public abstract void reset();

    /**
     * Display method
     * @param offset
     */
    protected abstract void display(String offset);

    /**
     *
     */
    public void display() {
        System.out.println(this.name);
        display("");
    }

    /**
     * Add current change to currCurrent
     * If current is negative then it would subtract
     * @param deltaCurrent
     * @return null if no overload, component name + "has overloaded" otherwise.
     */
    protected String updateCurrent(int deltaCurrent) {
        currCurrent = currCurrent + deltaCurrent;
        if (currCurrent < 0) {
            currCurrent = 0;
            return this.name + " has overloaded!";
        }
        return "null";
    }
}
