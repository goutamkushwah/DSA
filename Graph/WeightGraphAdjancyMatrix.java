public class WeightGraphAdjancyMatrix {
    int V;
    int[][] weight; // weight[u][v] stores the weight of edge u-v (0 if no edge)

    public WeightGraphAdjancyMatrix(int V) {
        this.V = V;
        weight = new int[V][V];
    }

    // Add edge (undirected, weighted)
    void addEdge(int u, int v, int w) {
        weight[u][v] = w;
        weight[v][u] = w; // For undirected graph; remove this line for directed
    }

    // Print adjacency matrix
    void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(weight[i][j] + " ");
            }
            System.out.println();
        }
    }
// DFS traversal from a given vertex
void DFS(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");
    for (int i = 0; i < V; i++) {
        if (weight[v][i] != 0 && !visited[i]) {
            DFS(i, visited);
        }
    }
}

// BFS traversal from a given vertex
void BFS(int v) {
    boolean[] visited = new boolean[V];
    int[] queue = new int[V];
    int front = 0, rear = 0;

    visited[v] = true;
    queue[rear++] = v;

    while (front < rear) {
        int curr = queue[front++];
        System.out.print(curr + " ");
        for (int i = 0; i < V; i++) {
            if (weight[curr][i] != 0 && !visited[i]) {
                visited[i] = true;
                queue[rear++] = i;
            }
        }
    }
}
    public static void main(String[] args) {
        WeightGraphAdjancyMatrix g = new WeightGraphAdjancyMatrix(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 1);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 6);

        g.printMatrix();
        System.out.print("DFS: ");
boolean[] visited = new boolean[g.V];
g.DFS(0, visited);
System.out.println();

System.out.print("BFS: ");
g.BFS(0);
System.out.println();
    }
}