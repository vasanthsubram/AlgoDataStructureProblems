package datastructure.graph;


/**
 * A graph visitor interface that can throw an exception during a visit
 * callback.
 *
 * @author Scott.Stark@jboss.org
 */
interface VisitorEX<T, E extends Exception> {
    /**
     * Called by the graph traversal methods when a vertex is first visited.
     */
    public void visit(Graph<T> g, Vertex<T> v) throws E;
}