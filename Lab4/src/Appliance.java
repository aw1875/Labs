public class Appliance extends Component {
    private boolean inUse;
    private int reqCurrent;

    public Appliance(String name, Component source, int reqCurr) {
        super(name, source);
        reqCurrent = reqCurr;
        inUse = false;
    }

    public void reset() {
        inUse = false;
        currCurrent = 0;
    }

    public boolean add(Component el) { return false; }

    protected void display(String offset) {
        System.out.println(offset + this.name);
    }

    public String toggleUsage() {
        if (updateCurrent(reqCurrent) == null) {
            inUse = true;
            return null;
        }
        inUse = false;
        return this.name + " has overloaded!";
    }

    /**
     * Getter function for inUse.
     * @return true if inUse is true, false otherwise.
     */
    public boolean getInUse() { return inUse; }
}
