package datastructure.graph;

/**
 * A directed, weighted edge in a graph
 *
 * @author Scott.Stark@jboss.org
 */
class Edge<T> {
    private Vertex<T> from;
    private Vertex<T> to;
    private int cost;
    private boolean mark;

    public Edge(Vertex<T> from, Vertex<T> to) {
        this(from, to, 0);
    }

    public Edge(Vertex<T> from, Vertex<T> to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
        mark = false;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public int getCost() {
        return cost;
    }

    public void mark() {
        mark = true;
    }

    public void clearMark() {
        mark = false;
    }

    public boolean isMarked() {
        return mark;
    }

    public String toString() {
        StringBuffer tmp = new StringBuffer("Edge[from: ");
        tmp.append(from.getName());
        tmp.append(",to: ");
        tmp.append(to.getName());
        tmp.append(", cost: ");
        tmp.append(cost);
        tmp.append("]");
        return tmp.toString();
    }
}