package datastructure.graph.adjacencyList;

import java.util.List;

/**
 * Created by vasanthakumarsubramanian on 1/12/17.
 */
public class Vertex {
    private String name;
    private List<Vertex> adjacentVertices;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }


}
