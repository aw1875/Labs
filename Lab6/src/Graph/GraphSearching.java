import java.util.*;

/**
 * The graph algorithms studied in RIT's first year CS courses.
 * @author James Heliotis
 */
public class GraphSearching {

    /**
     * Determine if a path of some length exists between a starting node
     * and a finishing node. If and only if this is true do the two nodes
     * belong to the same connected component in the graph.
     * <br>
     * This is the simplest version that only answers yes or no.
     * It keeps from getting into infinite cycles by
     *
     * @rit.pre the arguments name nodes in the graph.
     * @param graph the graph to be searched
     * @param start  the name associated with the starting node
     * @param finish the name associated with the finishing node
     * @return boolean indicating whether or not a path exists.
     */
    public static boolean canReachDFS(
            Graph graph, String start, String finish ) {

        // Assumes input check occurs previously
        Node startNode, finishNode;
        startNode = graph.getNode( start );
        finishNode = graph.getNode( finish );

        Set<Node> visited = new HashSet<>();
        visited.add( startNode );

        // Visit all nodes and check if finish is in visited set.
        visitDFS( graph, startNode, visited );
        return visited.contains( finishNode );
    }

    /**
     * Recursive function that visits all nodes reachable from the given node
     * in depth-first search fashion.  Visited list is updated in the process.
     *
     * @param graph the graph to be searched
     * @param node    the node from which to search
     * @param visited the list of nodes that have already been visited
     */
    private static void visitDFS(Graph graph, Node node, Set<Node> visited ) {

        for(Node nbr :graph.getNeighbors( node ))
            if ( !visited.contains( nbr ) ) {
                visited.add(nbr);
                visitDFS(graph, nbr, visited);
            }
    }

    /**
     * Create a path from a starting node to a finishing node if such
     * a path exists.
     * Uses depth-first search to determine if a path exists.
     * This pair of public and private methods uses a path list.
     * Another approach, shown below in the BFS code, is associating a
     * predecessor with each node.
     *
     * @rit.pre the arguments correspond to nodes in the graph
     * @param graph the graph to be searched
     * @param start  name associated with starting node
     * @param finish name associated with finishing node
     * @return an iteration from start to finish, or null if none exists
     */
    public static Iterable<Node> buildPathDFS(
            Graph graph, String start, String finish ) {

        // assumes input check occurs previously
        Node startNode, finishNode;
        startNode = graph.getNode( start );
        finishNode = graph.getNode( finish );

        // Construct a visited set of all nodes reachable from the start
        Set<Node> visited = new HashSet<>();
        visited.add( startNode );
        return buildPathDFS( graph, startNode, finishNode, visited );
    }

    /**
     * Recursive function that visits all nodes reachable from the given node
     * in depth-first search fashion. Visited list is updated in the process.
     *
     * @param graph the graph to be searched
     * @param start the node from which to search
     * @param finish the node for which to search
     * @param visited the list of nodes that have already been visited
     * @return the path from start to finish as a List,
     *         or if no path, an empty List.
     */
    private static List<Node> buildPathDFS(
            Graph graph, Node start, Node finish, Set<Node> visited ) {

        List<Node> path = null;

        if ( start.equals( finish ) )  {
            path = new LinkedList<>();
            // Put finish node in path. (Should be 1st node added.)
            path.add( start );
            return path;
        }

        for ( Node nbr : graph.getNeighbors( start ) ) {
            if ( !visited.contains( nbr ) ) {
                visited.add( nbr );
                path = buildPathDFS( graph, nbr, finish, visited );
                if ( path != null ) {
                    // Prepend this node to the successful path.
                    path.add( 0, start );
                    return path;
                }
            }
        }

        return null; // Failed on finding path from all neighbors. :-(
    }

    /**
     * Create a shortest path from a starting node to a finishing node if such
     * a path exists.
     * Uses breadth-first search to determine if a path exists.
     * To accomplish this, a predecessor gets associated with each node.
     *
     * @rit.pre the arguments correspond to nodes in the graph
     * @param graph the graph to be searched
     * @param start  name associated with starting node
     * @param finish name associated with finishing node
     * @return an iteration from start to finish, or null if none exists
     */
    public static Iterable<Node> buildPathBFS(
            Graph graph, String start, String finish ) {

        // Every node we visit will have a predecessor.
        // A node has been assigned a predecessor iff it has been visited,
        // so the keys of our predecessor map create a visited set!
        Map<Node, Node> predecessor = new HashMap<>();

        // assumes input check occurs previously
        Node startNode, finishNode;
        startNode = graph.getNode( start );
        finishNode = graph.getNode( finish );

        predecessor.put( startNode, null );
        // null predecessor indicates this is the starting point.
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.offer( startNode );

        while ( !toVisit.isEmpty() && !toVisit.peek().equals( finishNode ) ) {
            Node thisNode = toVisit.remove();
            graph.getNeighbors( thisNode ).forEach( nbr -> {
                if ( !predecessor.containsKey( nbr ) ) {
                    predecessor.put( nbr, thisNode );
                    toVisit.offer( nbr );
                }
            } );
        }

        if ( toVisit.isEmpty() ) {
            return null; // We never found the finish node.
        }
        else {
            List<Node> path = new LinkedList<>();
            path.add( 0, finishNode );
            Node node = predecessor.get( finishNode );
            while( node != null ) {
                path.add( 0, node ); // Reverse the direction to start->finish
                node = predecessor.get( node );
            }
            return path;
        }
    }

}
