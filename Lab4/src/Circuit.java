public class Circuit extends MultiComponent {
    private int maxCapacity;

    /**
     * Circuit constructor, BLAH?
     * @param name
     * @param source
     * @param maxCapacity
     */
    public Circuit(String name, Component source, int maxCapacity) {
        super(name, source);
        children = null;
    }

    /**
     * Check if el is intance of circuit or receptacle. If it is add to children and return true, if not return false.
     * @param el
     * @return true if added successfully, false otherwise
     */
    public boolean add(Component el) {
        if (!(el instanceof Circuit) && !(el instanceof Receptacle)) {
            return false;
        }
        children.add(el);
        return true;
    }

    /**
     * Display method
     * @param offset
     */
    protected void display(String offset) {
        System.out.println(this.name);
        for (Component c: children) {
            System.out.println(offset + c);
        }
    }

    /**
     * Update current
     * @param deltaCurrent
     * @return
     */
    protected String updateCurrent(int deltaCurrent) {
        currCurrent = currCurrent + deltaCurrent;
        if (currCurrent > maxCapacity) {
            reset();
            updateCurrent(currCurrent);
            return this.name + " has overloaded!";
        } else {
            updateCurrent(currCurrent);
            return null;
        }
    }
}
