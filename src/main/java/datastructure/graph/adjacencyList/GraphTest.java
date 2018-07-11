package datastructure.graph.adjacencyList;

public class GraphTest {

  /*

    x

     a-- b -- c
    ||   |
     d-- e
     |   |
     f   g

   */

  public static void main(String[] args){
    Graph graph = new Graph();

    Node a = new Node("a");
    Node b = new Node("b");
    Node c = new Node("c");
    Node x = new Node("x");
    graph.addNode(a);
    graph.addNode(b);
    graph.addNode(c);

    graph.addNode(x);

    Node d = new Node("d");
    Node e = new Node("e");
    Node f = new Node("f");
    Node g = new Node("g");

    a.addAdjacent(d);
    a.addAdjacent(b);
    b.addAdjacent(e);
    b.addAdjacent(c);
    d.addAdjacent(f);

    e.addAdjacent(d);
    e.addAdjacent(g);

    //cycle
    d.addAdjacent(a);

//    System.out.println("node between a and f");
//    System.out.println(graph.pathBetweenNodes(a, f));
//    System.out.println();
//    System.out.println("node between a and x");
//    System.out.println(graph.pathBetweenNodes(a, x));
//    graph.depthFirstSearch(a);
    System.out.println();
    graph.dfsStack(a);

    System.out.println();
    graph.bfs(a);
  }

}
