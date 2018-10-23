/**
 * An abstraction for a Graph's node objects. Each implementation of the
 * Graph interface will use a corresponding implementor of this class.
 * Problems will invariably happen because of covariance. It is recommended
 * that any needed downcasting be kept in the implementations of the Graph
 * classes, since there are no methods here, and therefore no mention of
 * Node arguments that would have to be downcast.
 *
 * @author James Heliotis
 */
public interface Node {
}
