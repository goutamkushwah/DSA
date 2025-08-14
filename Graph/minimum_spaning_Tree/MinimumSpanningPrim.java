public class MinimumSpanningPrim {
    int V;           // Number of vertices
    int[][] graph;   // Adjacency matrix representation

    // Constructor
    public MinimumSpanningPrim(int V) {
        this.V = V;
        graph = new int[V][V]; // Initialize matrix with 0 (no edges)
    }

    // Add an edge to the graph (undirected)
    void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
        graph[dest][src] = weight; // Since graph is undirected
    }

    // Function to find the vertex with minimum key value not yet included in MST
    int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Function to construct MST using Prim's Algorithm
    void primMST() {
        int[] parent = new int[V];  // Stores MST structure
        int[] key = new int[V];     // Stores minimum edge weights to a vertex
        boolean[] mstSet = new boolean[V]; // Tracks included vertices

        // Step 1: Initialize all keys as infinite
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Step 2: Start from vertex 0
        key[0] = 0;      // Start vertex has key = 0 so it's picked first
        parent[0] = -1;  // Root of MST has no parent

        // Step 3: MST will have V-1 edges
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum key vertex from the set of vertices not yet in MST
            int u = minKey(key, mstSet);
            mstSet[u] = true; // Add picked vertex to MST set

            // Update key value and parent for adjacent vertices
            for (int v = 0; v < V; v++) {
                // graph[u][v] != 0 means an edge exists
                // mstSet[v] == false means vertex v not yet in MST
                // graph[u][v] < key[v] means found smaller edge weight
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // Step 4: Print the MST
        System.out.println("Edges in Minimum Spanning Tree:");
        int minCost = 0;
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
            minCost += graph[i][parent[i]];
        }
        System.out.println("Minimum Cost: " + minCost);
    }

    // Main method to test
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        MinimumSpanningPrim g = new MinimumSpanningPrim(V);

        // Add edges: src, dest, weight
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(1, 3, 15);
        g.addEdge(2, 3, 4);

        g.primMST();
    }
}

