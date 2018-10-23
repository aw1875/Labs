import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A graph implementation base on building real nodes with links to other
 * nodes. In other words, this is the "adjacency list" style of graph
 * implementation. The "list" is actually a map of nodes' names to
 * nodes. Each node stores its own neighbors, technically outside
 * the graph structure.
 *
 * Because there is a different subclass of Node that goes with
 * this graph, some downcasting has to take place when Node objects
 * are passed in as arguments. That means that carelessly coded clients
 * of this class could experience {@link ClassCastException}s.
 *
 * @author James Heliotis
 */
public class LinkedGraph implements Graph {

    /**
     * Users (client code) know nodes by name. Here is where they are
     * mapped to the internal structure.
     */
    private final Map< String, LinkedNode > nodeMap;

    /**
     * Create an empty graph.
     */
    public LinkedGraph() {
        this.nodeMap = new HashMap<>();
    }

    /** {@inheritDoc} */
    @Override
    public Iterable< Node > getNodes() {

        Iterator< LinkedNode > underlying = this.nodeMap.values().iterator();
        return () -> new Iterator< Node >() {
            @Override
            public boolean hasNext() {
                return underlying.hasNext();
            }

            @Override
            public Node next() {
                return underlying.next();
            }
        };
    }

    /** {@inheritDoc} */
    @Override
    public boolean hasNode( String nodeName ) {
        return this.nodeMap.containsKey( nodeName );
    }

    /** {@inheritDoc} */
    @Override
    public Node getNode( String nodeName ) {
        return this.nodeMap.get( nodeName );
    }

    /** {@inheritDoc} */
    @Override
    public String getNodeName( Node node ) {
        for ( String key: this.nodeMap.keySet() ) {
            if ( this.nodeMap.get( key ).equals( node ) ) {
                return key;
            }
        }
        return UNFOUND_NODE_NAME;
    }

    /** {@inheritDoc} */
    @Override
    public void addNeighbor( Node node, Node neighbor ) {
        ((LinkedNode)node).addNeighbor( (LinkedNode)neighbor );
    }

    /** {@inheritDoc} */
    @Override
    public Set< Node > getNeighbors( Node node ) {
        return ((LinkedNode)node).getNeighbors();
    }

    /** {@inheritDoc} */
    @Override
    public Node makeNode( String name ) {
        LinkedNode result = new LinkedNode( name );
        this.nodeMap.put( name, result );
        return result;
    }

    /**
     * Generate a string associated with the graph. The string
     * is comprised of one line for each node in the graph, which is
     * unconventionally large for a method overriding the
     * {@link Object#toString()} method.
     *
     * @return string associated with the graph.
     */
    @Override
    public String toString() {
        String result = "";
        for ( String name : this.nodeMap.keySet() ) {
            result = result + this.nodeMap.get( name ) + "\n";
        }
        return result;
    }

}

