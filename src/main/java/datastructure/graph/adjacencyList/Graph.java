package datastructure.graph.adjacencyList;

import java.util.List;

/**
 * Created by vasanthakumarsubramanian on 1/12/17.
 */
public class Graph {

    private String name;
    private List<Vertex> vertices;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }
}
