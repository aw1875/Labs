import java.util.*;

/**
 * Interface for a directed graph. Nodes are connected by edges, but
 * there is no concept of an edge here, e.g., now edge "weights".
 * The nodes are identified with strings and contain no other internal data.
 *
 * @author James E Heliotis
 */
public interface Graph {

    /**
     * Instead of throwing an exception, reverse lookup (node-to-name)
     * that fails returns this string.
     */
    public static final String UNFOUND_NODE_NAME = "NO SUCH NODE (getNodeName)";

    /**
     * Get all the nodes currently in this graph.
     * @return an {@link Iterable} over all the graph's nodes.
     */
    Iterable< Node > getNodes();

    /**
     * Check if a given String node is in the graph.
     *
     * @param nodeName name of a node
     * @return true iff the graph contains a node with that name
     */
    public boolean hasNode( String nodeName );

    /**
     * Look up a node in the graph by its name.
     * @rit.pre hasNode( nodeName )
     * @param nodeName the sought node's name
     * @return the Node object named nodeName or null if doesn't exist
     */
    public Node getNode( String nodeName );

    /**
     * Look up the name of a node.
     * @param node the node to look up
     * @return the node's name
     */
    public String getNodeName( Node node );

    /**
     * Hook up two more nodes with an edge. Edges are directional, so if
     * you desire a two-way connection, addNeighbor must be called twice,
     * the second time with the arguments reversed.
     * @param node the source node for the edge
     * @param neighbor the destination node for the edge
     */
    public void addNeighbor( Node node, Node neighbor );

    /**
     * What are all the neighbors of a node?
     * @param node the node whose neighbors are sought
     * @return a set of {@link Node}s where for each node v in the set,
     *         addNeighbor had previously been called with node as the
     *         first argument and v as the second
     */
    public Set< Node > getNeighbors( Node node );

    /**
     * Create a new node for this graph.
     * @rit.post the returned node has no neighbors.
     * @param nodeName the name of the new node
     * @return the Node object created
     */
    public Node makeNode( String nodeName );

}
