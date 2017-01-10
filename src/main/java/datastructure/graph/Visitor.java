package datastructure.graph;


/**
 * A graph visitor interface.
 *
 * @author Scott.Stark@jboss.org
 * @version $Revision$
 * @param <T>
 */
interface Visitor<T> {
    /**
     * Called by the graph traversal methods when a vertex is first visited.
     */
    public void visit(Graph<T> g, Vertex<T> v);
}
