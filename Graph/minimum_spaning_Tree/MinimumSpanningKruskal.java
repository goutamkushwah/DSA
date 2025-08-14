import java.util.Arrays;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Constructor
    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    // Compare edges by weight for sorting
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

public class MinimumSpanningKruskal {
    int V, E;       // Number of vertices and edges
    Edge[] edges;   // Array of all edges

    // Constructor
    public MinimumSpanningKruskal(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E]; // Initialize edge array
    }

    // -------------------
    // Disjoint Set (Union-Find) Functions
    // -------------------

    // Find representative (root) of set using path compression
    int find(int[] parent, int vertex) {
        if (parent[vertex] != vertex)
            parent[vertex] = find(parent, parent[vertex]); // Path compression
        return parent[vertex];
    }

    // Union of two sets using rank to keep tree short
    void union(int[] parent, int[] rank, int root1, int root2) {
        int xRoot = find(parent, root1);
        int yRoot = find(parent, root2);

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    // -------------------
    // Kruskal's Algorithm
    // -------------------
    void kruskalMST() {
        // Array to store MST result (V - 1 edges)
        Edge[] result = new Edge[V - 1];

        // Step 1: Sort all edges by weight
        Arrays.sort(edges);

        // Create parent and rank arrays for union-find
        int[] parent = new int[V];
        int[] rank = new int[V];

        // Initially, each vertex is its own parent (disjoint sets)
        for (int v = 0; v < V; v++) {
            parent[v] = v;
            rank[v] = 0;
        }

        int e = 0; // Index for result[]
        int i = 0; // Index for sorted edges[]

        // Step 2: Pick the smallest edge that doesn't form a cycle
        while (e < V - 1 && i < E) {
            Edge nextEdge = edges[i++]; // Get next smallest edge

            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            // If including this edge doesn't cause a cycle, include it
            if (x != y) {
                result[e++] = nextEdge;
                union(parent, rank, x, y);
            }
        }

        // Step 3: Print the MST result
        System.out.println("Edges in Minimum Spanning Tree:");
        int minCost = 0;
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
            minCost += result[i].weight;
        }
        System.out.println("Minimum Cost: " + minCost);
    }

    // -------------------
    // Main Method (Driver)
    // -------------------
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        int E = 5; // Number of edges

        MinimumSpanningKruskal graph = new MinimumSpanningKruskal(V, E);

        // Add edges: src, dest, weight
        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);

        // Run Kruskal's Algorithm
        graph.kruskalMST();
    }
}
