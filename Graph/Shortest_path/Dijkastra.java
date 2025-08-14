// Class implementing Dijkstra's shortest path algorithm in Java
public class Dijkastra {

    // Inner class to represent a graph
    static class Graph {
        private int[][] adjMatrix;   // Adjacency matrix to store edge weights
        private String[] vertexData; // Array to store vertex names (A, B, C...)
        private int size;            // Number of vertices in the graph

        // Constructor: initializes the graph with given number of vertices
        public Graph(int size) {
            this.size = size;
            this.adjMatrix = new int[size][size];   // Initially all 0 (no edges)
            this.vertexData = new String[size];     // Stores vertex labels
        }

        // Adds an edge between two vertices u and v with a given weight
        public void addEdge(int u, int v, int weight) {
            if (u >= 0 && u < size && v >= 0 && v < size) {
                adjMatrix[u][v] = weight;
                adjMatrix[v][u] = weight;  // Because this is an undirected graph
            }
        }

        // Adds a name/label to a vertex
        public void addVertexData(int vertex, String data) {
            if (vertex >= 0 && vertex < size) {
                vertexData[vertex] = data;
            }
        }

        // Main Dijkstra's algorithm: finds shortest paths from a starting vertex
        public int[] dijkstra(String startVertexData) {
            int startVertex = findIndex(startVertexData); // Convert vertex name to index
            int[] distances = new int[size];              // Distance array
            boolean[] visited = new boolean[size];        // Track visited vertices

            // Initialize distances to infinity
            for (int i = 0; i < size; i++) {
                distances[i] = Integer.MAX_VALUE;
            }
            distances[startVertex] = 0; // Distance to self is 0

            // Process all vertices
            for (int i = 0; i < size; i++) {
                // Pick the unvisited vertex with the smallest distance
                int u = minDistance(distances, visited);
                if (u == -1) break; // If no vertex is reachable, stop

                visited[u] = true; // Mark as visited

                // Update distances to adjacent vertices
                for (int v = 0; v < size; v++) {
                    // Conditions:
                    // 1. v is not visited
                    // 2. There is an edge from u to v (weight != 0)
                    // 3. Distance to u is not infinity
                    if (!visited[v] && adjMatrix[u][v] != 0 && distances[u] != Integer.MAX_VALUE) {
                        int newDist = distances[u] + adjMatrix[u][v]; // Possible new distance
                        if (newDist < distances[v]) { // Update if smaller
                            distances[v] = newDist;
                        }
                    }
                }
            }
            return distances; // Return array of shortest distances
        }

        // Finds the index of a vertex from its name
        private int findIndex(String data) {
            for (int i = 0; i < size; i++) {
                if (vertexData[i].equals(data)) {
                    return i;
                }
            }
            return -1; // Not found
        }

        // Finds the vertex with the smallest distance that has not been visited
        private int minDistance(int[] distances, boolean[] visited) {
            int min = Integer.MAX_VALUE, minIndex = -1;
            for (int v = 0; v < size; v++) {
                if (!visited[v] && distances[v] <= min) {
                    min = distances[v];
                    minIndex = v;
                }
            }
            return minIndex;
        }
    }

    // Main method: Creates a graph, adds vertices/edges, runs Dijkstra
    public static void main(String[] args) {
        Graph g = new Graph(7); // Create a graph with 7 vertices

        // Add vertex labels
        g.addVertexData(0, "A");
        g.addVertexData(1, "B");
        g.addVertexData(2, "C");
        g.addVertexData(3, "D");
        g.addVertexData(4, "E");
        g.addVertexData(5, "F");
        g.addVertexData(6, "G");

        // Add edges with weights
        g.addEdge(3, 0, 4); // D - A, weight 4
        g.addEdge(3, 4, 2); // D - E, weight 2
        g.addEdge(0, 2, 3); // A - C, weight 3
        g.addEdge(0, 4, 4); // A - E, weight 4
        g.addEdge(4, 2, 4); // E - C, weight 4
        g.addEdge(4, 6, 5); // E - G, weight 5
        g.addEdge(2, 5, 5); // C - F, weight 5
        g.addEdge(2, 1, 2); // C - B, weight 2
        g.addEdge(1, 5, 2); // B - F, weight 2
        g.addEdge(6, 5, 5); // G - F, weight 5

        // Run Dijkstra's algorithm from D
        System.out.println("Dijkstra's Algorithm starting from vertex D:\n");
        int[] distances = g.dijkstra("D");

        // Print shortest distances
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Shortest distance from D to " + g.vertexData[i] + ": " + distances[i]);
        }
    }
}
