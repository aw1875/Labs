public class Receptacle extends MultiComponent {
    private int maxChildren;

    /**
     * Receptacle constructor, BLAH?
     * @param name
     * @param source
     * @param maxEl
     */
    public Receptacle(String name, Component source, int maxEl) {
        super(name, source);
        this.maxChildren = maxEl;
    }

    /**
     * Add method
     * @param el
     * @return true if successful, false otherwise
     */
    public boolean add(Component el) {
        if (!(el instanceof Receptacle) && !(el instanceof Appliance)) {
            return false;
        }
        if (children.size() < maxChildren) {
            children.add(el);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Display method
     * @param offset
     */
    protected void display(String offset) {
        System.out.println(this.name);
        for (Component c : children) {
            System.out.println(offset + c);
        }
    }
}
