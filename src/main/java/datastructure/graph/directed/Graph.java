package datastructure.graph.directed;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * A directed graph data structure.
 *
 * @author Scott.Stark@jboss.org
 */
@SuppressWarnings("unchecked")
public class Graph<T> {
    /** Color used to mark unvisited nodes */
    public static final int VISIT_COLOR_WHITE = 1;

    /** Color used to mark nodes as they are first visited in DFS order */
    public static final int VISIT_COLOR_GREY = 2;

    /** Color used to mark nodes after descendants are completely visited */
    public static final int VISIT_COLOR_BLACK = 3;

    private List<Vertex<T>> verticies;
    private List<Edge<T>> edges;
    private Vertex<T> rootVertex;


    public Graph() {
        verticies = new ArrayList<Vertex<T>>();
        edges = new ArrayList<Edge<T>>();
    }

    public boolean addVertex(Vertex<T> v) {
        boolean added = false;
        if (verticies.contains(v) == false) {
            added = verticies.add(v);
        }
        return added;
    }

    public boolean addEdge(Vertex<T> from, Vertex<T> to, int cost) throws IllegalArgumentException {
        if (verticies.contains(from) == false)
            throw new IllegalArgumentException("from is not in graph");
        if (verticies.contains(to) == false)
            throw new IllegalArgumentException("to is not in graph");

        Edge<T> e = new Edge<T>(from, to, cost);
        if (from.findEdge(to) != null)
            return false;
        else {
            from.addEdge(e);
            to.addEdge(e);
            edges.add(e);
            return true;
        }
    }

    public boolean insertBiEdge(Vertex<T> from, Vertex<T> to, int cost)
            throws IllegalArgumentException {
        return addEdge(from, to, cost) && addEdge(to, from, cost);
    }


    public boolean removeVertex(Vertex<T> v) {
        if (!verticies.contains(v))
            return false;

        verticies.remove(v);
        if (v == rootVertex)
            rootVertex = null;

        // Remove the edges associated with v
        for (int n = 0; n < v.getOutgoingEdgeCount(); n++) {
            Edge<T> e = v.getOutgoingEdge(n);
            v.remove(e);
            Vertex<T> to = e.getTo();
            to.remove(e);
            edges.remove(e);
        }
        for (int n = 0; n < v.getIncomingEdgeCount(); n++) {
            Edge<T> e = v.getIncomingEdge(n);
            v.remove(e);
            Vertex<T> predecessor = e.getFrom();
            predecessor.remove(e);
        }
        return true;
    }

    public boolean removeEdge(Vertex<T> from, Vertex<T> to) {
        Edge<T> e = from.findEdge(to);
        if (e == null)
            return false;
        else {
            from.remove(e);
            to.remove(e);
            edges.remove(e);
            return true;
        }
    }

    public void depthFirstSearch(Vertex<T> v, final Visitor<T> visitor) {
        VisitorEX<T, RuntimeException> wrapper = new VisitorEX<T, RuntimeException>() {
            public void visit(Graph<T> g, Vertex<T> v) throws RuntimeException {
                if (visitor != null)
                    visitor.visit(g, v);
            }
        };
        this.depthFirstSearch(v, wrapper);
    }

    /**
     * Perform a depth first serach using recursion. The search may be cut short
     * if the visitor throws an exception.
     *
     * @param <E>
     *
     * @param v -
     *          the Vertex to start the search from
     * @param visitor -
     *          the vistor to inform prior to
     * @see Visitor#visit(Graph, Vertex)
     * @throws E
     *           if visitor.visit throws an exception
     */
    public <E extends Exception> void depthFirstSearch(Vertex<T> v, VisitorEX<T, E> visitor) throws E {
        if (visitor != null)
            visitor.visit(this, v);
        v.visit();
        for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
            Edge<T> e = v.getOutgoingEdge(i);
            if (!e.getTo().visited()) {
                depthFirstSearch(e.getTo(), visitor);
            }
        }
    }

    /**
     * Perform a breadth first search of this graph, starting at v.
     *
     * @param v -
     *          the search starting point
     * @param visitor -
     *          the vistor whose vist method is called prior to visting a vertex.
     */
    public void breadthFirstSearch(Vertex<T> v, final Visitor<T> visitor) {
        VisitorEX<T, RuntimeException> wrapper = new VisitorEX<T, RuntimeException>() {
            public void visit(Graph<T> g, Vertex<T> v) throws RuntimeException {
                if (visitor != null)
                    visitor.visit(g, v);
            }
        };
        this.breadthFirstSearch(v, wrapper);
    }

    /**
     * Perform a breadth first search of this graph, starting at v. The vist may
     * be cut short if visitor throws an exception during a vist callback.
     *
     * @param <E>
     *
     * @param v -
     *          the search starting point
     * @param visitor -
     *          the vistor whose vist method is called prior to visting a vertex.
     * @throws E
     *           if vistor.visit throws an exception
     */
    public <E extends Exception> void breadthFirstSearch(Vertex<T> v, VisitorEX<T, E> visitor)
            throws E {
        LinkedList<Vertex<T>> q = new LinkedList<Vertex<T>>();

        q.add(v);
        if (visitor != null)
            visitor.visit(this, v);
        v.visit();
        while (!q.isEmpty()) {
            v = q.removeFirst();
            for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
                Edge<T> e = v.getOutgoingEdge(i);
                Vertex<T> to = e.getTo();
                if (!to.visited()) {
                    q.add(to);
                    if (visitor != null)
                        visitor.visit(this, to);
                    to.visit();
                }
            }
        }
    }

    /**
     * Find the spanning tree using a DFS starting from v.
     *
     * @param v -
     *          the vertex to start the search from
     * @param visitor -
     *          visitor invoked after each vertex is visited and an edge is added
     *          to the tree.
     */
    public void dfsSpanningTree(Vertex<T> v, DFSVisitor<T> visitor) {
        v.visit();
        if (visitor != null)
            visitor.visit(this, v);

        for (int i = 0; i < v.getOutgoingEdgeCount(); i++) {
            Edge<T> e = v.getOutgoingEdge(i);
            if (!e.getTo().visited()) {
                if (visitor != null)
                    visitor.visit(this, v, e);
                e.mark();
                dfsSpanningTree(e.getTo(), visitor);
            }
        }
    }




    /**
     * Search the graph for cycles. In order to detect cycles, we use a modified
     * depth first search called a colored DFS. All nodes are initially marked
     * white. When a node is encountered, it is marked grey, and when its
     * descendants are completely visited, it is marked black. If a grey node is
     * ever encountered, then there is a cycle.
     *
     * @return the edges that form cycles in the graph. The array will be empty if
     *         there are no cycles.
     */
    public Edge<T>[] findCycles() {
        ArrayList<Edge<T>> cycleEdges = new ArrayList<Edge<T>>();
        // Mark all verticies as white
        for (int n = 0; n < verticies.size(); n++) {
            Vertex<T> v = getVertex(n);
            v.setMarkState(VISIT_COLOR_WHITE);
        }
        for (int n = 0; n < verticies.size(); n++) {
            Vertex<T> v = getVertex(n);
            visit(v, cycleEdges);
        }

        Edge<T>[] cycles = new Edge[cycleEdges.size()];
        cycleEdges.toArray(cycles);
        return cycles;
    }

    private void visit(Vertex<T> v, ArrayList<Edge<T>> cycleEdges) {
        v.setMarkState(VISIT_COLOR_GREY);
        int count = v.getOutgoingEdgeCount();
        for (int n = 0; n < count; n++) {
            Edge<T> e = v.getOutgoingEdge(n);
            Vertex<T> u = e.getTo();
            if (u.getMarkState() == VISIT_COLOR_GREY) {
                // A cycle Edge<T>
                cycleEdges.add(e);
            } else if (u.getMarkState() == VISIT_COLOR_WHITE) {
                visit(u, cycleEdges);
            }
        }
        v.setMarkState(VISIT_COLOR_BLACK);
    }

    public String toString() {
        StringBuffer tmp = new StringBuffer("Graph[");
        for (Vertex<T> v : verticies)
            tmp.append(v);
        tmp.append(']');
        return tmp.toString();
    }

    public int size() {
        return verticies.size();
    }

    public Vertex<T> getRootVertex() {
        return rootVertex;
    }

    public void setRootVertex(Vertex<T> root) {
        this.rootVertex = root;
        if (verticies.contains(root) == false)
            this.addVertex(root);
    }

    public Vertex<T> getVertex(int n) {
        return verticies.get(n);
    }

    public List<Vertex<T>> getVerticies() {
        return this.verticies;
    }

    public boolean isEmpty() {
        return verticies.size() == 0;
    }

    public List<Edge<T>> getEdges() {
        return this.edges;
    }


    public void clearMark() {
        for (Vertex<T> w : verticies)
            w.clearMark();
    }

    public void clearEdges() {
        for (Edge<T> e : edges)
            e.clearMark();
    }

    public Vertex<T> findVertexByName(String name) {
        Vertex<T> match = null;
        for (Vertex<T> v : verticies) {
            if (name.equals(v.getName())) {
                match = v;
                break;
            }
        }
        return match;
    }

    public Vertex<T> findVertexByData(T data, Comparator<T> compare) {
        Vertex<T> match = null;
        for (Vertex<T> v : verticies) {
            if (compare.compare(data, v.getData()) == 0) {
                match = v;
                break;
            }
        }
        return match;
    }
}