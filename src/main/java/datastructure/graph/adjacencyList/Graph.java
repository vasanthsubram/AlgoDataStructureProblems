package datastructure.graph.adjacencyList;

import java.util.*;


public class Graph {
  private ArrayList<Node> rootNodes = new ArrayList<>();;

  public void addNode(Node x){
    rootNodes.add(x);
  }


  public void bfs(Node n){
    System.out.println("BFS");
    Queue<Node> q = new ArrayDeque<>();
    Set<Node> visited = new HashSet<>();
    q.add(n);

    while(!q.isEmpty()){
      Node p = q.remove();
      if(!visited.contains(p)) {
        visit(p);
        visited.add(p);
        q.addAll(p.getAdjacent());
      }
    }

  }
  public void depthFirstSearch(Node n){
    System.out.println("DFS");
    Set<Node> visited = new HashSet<>();
    dfs(n,visited);
  }
  public void dfs(Node n, Set<Node> visited){
    visit(n);
    visited.add(n);
    for(Node a: n.getAdjacent()){
      if(!visited.contains(a)) {
        dfs(a, visited);
      }
    }

  }

  /*
   a-- b -- c
  ||   |
   d-- e
   |   |
   f   g

 */



  public void dfsStack(Node n){
    Set<Node> visited = new HashSet<>();

    Stack<Node> stack = new Stack<>();
    stack.push(n);

    while (!stack.empty()) {
      Node c = stack.pop();
      if(!visited.contains(c)) {
        visit(c);
        visited.add(c);
        for (Node a : c.getAdjacent()) {
          stack.push(a);
        }
      }
    }
  }

  private void visit(Node n) {
    print(n);
  }

  public  boolean pathBetweenNodes(Node start, Node end){
    Queue<Node> q = new LinkedList<>();
    Set<Node> visited = new HashSet<>();
    q.add(start);

    while(!q.isEmpty()){
      Node current = q.remove();
      if (!visited.contains(current)) {
        visited.add(current);
        if (current == end) {
          print(current);
          return true;
        }
        print(current);
        q.addAll(current.getAdjacent());
      } else{
        System.out.println(" Node already visited: " + current.getNodeName() );
      }
    }
    System.out.println("No path between " + start.getNodeName() + " and " + end.getNodeName());
    return false;
  }

  private void print(Node n){
    System.out.println("Visited  =" + n.getNodeName());
  }
}
