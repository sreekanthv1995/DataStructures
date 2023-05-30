package graph;

public class GraphMain {
    public static void main(String[] args) {

        Graph myGraph = new Graph();

        myGraph.addVertex(0);
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);


        myGraph.addEdge(0, 1);
        myGraph.addEdge(2, 3);
        myGraph.addEdge(1, 2);
        myGraph.addEdge(3, 0);




        myGraph.display();
        myGraph.BFS(0);


    }
}
