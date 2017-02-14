package datastructure.graph.directed;

/**
 * Created by vasanthakumarsubramanian on 1/10/17.
 */
public class GraphTest {
    public static void main(String[] args) {
/*
        sea ------->  nyc ----> dc
                       nyc ----> sfo
        sea -------> sfo

*/
        Vertex<Integer> nyc = new Vertex<>("NYC");
        Vertex<Integer> sfo = new Vertex<>("SFO");

        Vertex<Integer> sea = new Vertex<>("SEA");
        Vertex<Integer> dc = new Vertex<>("DC");


//        Edge<Integer> nycSfo=new Edge<>(nyc,sfo);

        Graph<Integer> graph=new Graph<>();

        graph.addVertex(nyc);
        graph.addVertex(sfo);
        graph.addVertex(sea);
        graph.addVertex(dc);

        graph.addEdge(nyc, sfo,1000);
        graph.addEdge(sea, nyc,1000);
        graph.addEdge(nyc, dc,1000);
        graph.addEdge(sea, sfo,800);

//        System.out.println(graph.toString());

        System.out.println(sea.findEdge(sfo));
        System.out.println(sea.findEdge(dc));
    }
}
