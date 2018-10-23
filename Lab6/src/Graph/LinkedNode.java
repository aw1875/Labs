import java.util.*;

/**
 * Class representing a node in a graph. The node's name, a string,
 * is the only value it contains. Neighbors are stored internally
 * in a collection.
 *
 * This class does not define equals or hashCode. It is making the
 * assumption that each node is described by exactly one Node object.
 *
 * @author atd Aaron T Deever
 * @author jeh James E Heliotis
 */
class LinkedNode implements Node {

    /*
     *  Name associated with this node.
     */
    private String name;

    /*
     * Neighbors of this node are stored as a list (adjacency list).
     */
    private Set< LinkedNode > neighbors;

    /**
     * Constructor.  Initialized with an empty list of neighbors.
     *
     * @param name string representing the name associated with the node.
     */
    LinkedNode( String name ) {
        this.name = name;
        this.neighbors = new HashSet<>();
    }

    /**
     * Get the String name associated with this object.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Add a neighbor to this node.  Checks if already present, and does not
     * duplicate in this case.
     *
     * @param n node to add as neighbor.
     */
    public void addNeighbor( LinkedNode n ) {
        if ( !this.neighbors.contains( n ) ) {
            this.neighbors.add( n );
        }
    }

    /**
     * Return the adjacency list for this node containing all
     * of its neighbors.
     *
     * @return an immutable version of the list of neighbors of the given node
     */
    Set< Node > getNeighbors() {
        return Collections.unmodifiableSet( neighbors );
    }

    /**
     * Generate a string associated with the node, including the
     * name of the node followed by the names of its neighbors.
     *
     * @return string associated with the node.
     */
    @Override
    public String toString() {
        return name + ": " +
                String.join(
                        ", ",
                        this.neighbors.stream()
                                .map( LinkedNode::getName )
                                .toArray( String[]::new )
                );

    }

    /**
     * Compare this node to some other object.
     * @param o the object being compared to this node
     * @return true iff the other object is also a LinkedNode
     *         with the same name.
     */
    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        return name.equals( ((LinkedNode)o).name );
    }

    /**
     * Compute a hash code for this node.
     * @return a hash code computed from this node's name
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
