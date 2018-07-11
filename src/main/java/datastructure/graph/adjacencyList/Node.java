package datastructure.graph.adjacencyList;

import java.util.ArrayList;
import java.util.List;

public class Node {
  private List<Node> adjacent = new ArrayList<>();
  private String nodeName;
  private boolean visited;

  public Node(String nodeName){
    this.nodeName = nodeName;
  }

  public void addAdjacent(Node x){
    adjacent.add(x);
  }

  public String getNodeName(){
    return nodeName;
  }

  public List<Node> getAdjacent(){
    return adjacent;
  }

  @Override
  public String toString() {
    return "Node{" + nodeName  + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;

    Node node = (Node) o;

    return nodeName.equals(node.nodeName);

  }

  @Override
  public int hashCode() {
    return nodeName.hashCode();
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }
}
