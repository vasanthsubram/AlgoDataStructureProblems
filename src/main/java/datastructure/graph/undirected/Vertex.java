package datastructure.graph.undirected;


import java.util.ArrayList;

/**
 * This class models a vertex in a graph. For ease of
 * the reader, a label for this vertex is required.
 *
 * Note that the Graph object only accepts one Vertex per label,
 * so uniqueness of labels is important.
 *
 * This vertex's neighborhood
 * is described by the Edges incident to it.
 *
 * @author Michael Levet
 * @date June 09, 2015
 */
public class Vertex {

    private ArrayList<Edge> neighborhood;
    private String label;

    public Vertex(String label){
        this.label = label;
        this.neighborhood = new ArrayList<Edge>();
    }

    public void addNeighbor(Edge edge){
        if(this.neighborhood.contains(edge)){
            return;
        }
        this.neighborhood.add(edge);
    }

    public boolean containsNeighbor(Edge other){
        return this.neighborhood.contains(other);
    }


    public Edge getNeighbor(int index){
        return this.neighborhood.get(index);
    }

    Edge removeNeighbor(int index){
        return this.neighborhood.remove(index);
    }

    public void removeNeighbor(Edge e){
        this.neighborhood.remove(e);
    }


    public int getNeighborCount(){
        return this.neighborhood.size();
    }

    public String getLabel(){
        return this.label;
    }

    public String toString(){
        return "Vertex " + label;
    }

    public int hashCode(){
        return this.label.hashCode();
    }

    public boolean equals(Object other){
        if(!(other instanceof Vertex)){
            return false;
        }
        Vertex v = (Vertex)other;
        return this.label.equals(v.label);
    }

    /**
     *
     * @return ArrayList<Edge> A copy of this.neighborhood. Modifying the returned
     * ArrayList will not affect the neighborhood of this Vertex
     */
    public ArrayList<Edge> getNeighbors(){
        return new ArrayList<Edge>(this.neighborhood);
    }

}

