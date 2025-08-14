import java.util.Arrays;

// Class containing Bellman-Ford Algorithm
public class BellmanFord {

    // Inner Graph class to represent vertices and edges
    static class Graph {
        private int[][] adjMatrix; // Stores edge weights
        private String[] vertexData; // Stores vertex names (like "A", "B", "C")
        private int size; // Number of vertices

        // Constructor: creates an empty graph with given number of vertices
        public Graph(int size) {
            this.size = size;
            this.adjMatrix = new int[size][size];
            this.vertexData = new String[size];
            Arrays.fill(vertexData, ""); // Initialize with empty names
        }

        // Add a directed edge u -> v with a given weight
        public void addEdge(int u, int v, int weight) {
            if (0 <= u && u < size && 0 <= v && v < size) {
                adjMatrix[u][v] = weight;
                // If you want an undirected graph, uncomment:
                // adjMatrix[v][u] = weight;
            }
        }

        // Assign a name to a vertex
        public void addVertexData(int vertex, String data) {
            if (0 <= vertex && vertex < size) {
                vertexData[vertex] = data;
            }
        }

        // Bellman-Ford Algorithm
        // Returns shortest distances from start vertex to all vertices
        public int[] bellmanFord(String startVertexData) {

            // Find the starting vertex index by name
            int startVertex = -1;
            for (int i = 0; i < size; i++) {
                if (vertexData[i].equals(startVertexData)) {
                    startVertex = i;
                    break;
                }
            }
            if (startVertex == -1) {
                throw new IllegalArgumentException("Start vertex not found");
            }

            // Initialize distances array with infinity (Integer.MAX_VALUE)
            int[] distances = new int[size];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[startVertex] = 0; // Distance to itself is 0

            // Relax edges (size-1) times
            for (int i = 0; i < size - 1; i++) {
                for (int u = 0; u < size; u++) {
                    for (int v = 0; v < size; v++) {
                        // If there is an edge from u to v and u is reachable
                        if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                            distances[u] + adjMatrix[u][v] < distances[v]) {

                            // Update the distance
                            distances[v] = distances[u] + adjMatrix[u][v];

                            // Debug output for relaxation step
                            System.out.println(
                                "Relaxing edge " + vertexData[u] + " -> " + vertexData[v] +
                                ", Updated distance to " + vertexData[v] + ": " + distances[v]
                            );
                        }
                    }
                }
            }

            // (Optional) — Detect negative weight cycles
            for (int u = 0; u < size; u++) {
                for (int v = 0; v < size; v++) {
                    if (adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE &&
                        distances[u] + adjMatrix[u][v] < distances[v]) {
                        System.out.println("Graph contains a negative weight cycle!");
                        return null; // Stop execution
                    }
                }
            }

            return distances;
        }
    }

    // Main method to test the Bellman-Ford Algorithm
    public static void main(String[] args) {
        Graph g = new Graph(5);

        // Adding vertex labels
        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");

        // Adding directed edges with weights
        g.addEdge(3, 0, 4);  // D -> A
        g.addEdge(3, 2, 7);  // D -> C
        g.addEdge(3, 4, 3);  // D -> E
        g.addEdge(0, 2, 4);  // A -> C
        g.addEdge(2, 0, -3); // C -> A (negative weight)
        g.addEdge(0, 4, 5);  // A -> E
        g.addEdge(4, 2, 3);  // E -> C
        g.addEdge(1, 2, -4); // B -> C (negative weight)
        g.addEdge(4, 1, 2);  // E -> B

        // Run Bellman-Ford starting from vertex "D"
        System.out.println("\nBellman-Ford Algorithm starting from vertex D:");
        int[] distances = g.bellmanFord("D");

        // Display shortest distances
        if (distances != null) {
            for (int i = 0; i < distances.length; i++) {
                System.out.println("Distance from D to " + g.vertexData[i] + ": " + distances[i]);
            }
        }
    }
}
