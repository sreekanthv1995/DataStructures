package graphadjmetrix;

public class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int source, int destination) {
        // Adding an edge between source and destination vertices
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1; // Assuming an undirected graph
    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 3;
        Graph graph = new Graph(numVertices);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        // Printing the adjacency matrix
        graph.printAdjacencyMatrix();
    }
}