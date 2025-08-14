public class WeightGraphAdjancyList {
    int V;
    int [][] neighbor;// stores neighbor vertex
    int[][] weights;   // stores corresponding edge weights
    int[] size;        // number of neighbors for each vertex
    int maxEdges = 10; // maximum edges per vertex
public WeightGraphAdjancyList(int v) {
    this.V = v;
    this.neighbor = new int[v][maxEdges];
    this.weights = new int[v][maxEdges];
    this.size = new int[v];
}
// Add edge (undirected, weighted)
void addEdge(int u, int v, int w) {
  
    neighbor[u][size[u]] = v;
    weights[u][size[u]] = w;
    size[u]++;
    
    neighbor[v][size[v]] = u; // undirected graph
    weights[v][size[v]] = w;
    size[v]++;
}
// // Print adjacency list with weights
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < size[i]; j++) {
                System.out.print("(" + neighbor[i][j] + ", " + weights[i][j] + ") ");
            }
            System.out.println();
        }
    }
   void DFS(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");
    for (int j = 0; j < size[v]; j++) {
        int neighborV = neighbor[v][j];
        if (!visited[neighborV]) {
            DFS(neighborV, visited);
        }
    }
}
void BFS(int v) {
    boolean[] visited = new boolean[V];
    int[] queue = new int[V];
    int front = 0, rear = 0;

    visited[v] = true;
    queue[rear++] = v;

    while (front < rear) {
        int curr = queue[front++];
        System.out.print(curr + " ");
        for (int j = 0; j < size[curr]; j++) {
            int neighborV = neighbor[curr][j];
            if (!visited[neighborV]) {
                visited[neighborV] = true;
                queue[rear++] = neighborV;
            }
        }
    }
}
     public static void main(String[] args) {
        WeightGraphAdjancyList g = new WeightGraphAdjancyList(5);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 5);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 4);
        g.addEdge(1, 4, 1);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 4, 6);

        g.printGraph();
      System.out.print("BFS: ");
        g.BFS(0);
        System.out.println();   
        System.out.print("DFS: ");
        boolean[] visited = new boolean[g.V];
        g.DFS(0, visited);
        System.out.println();
    }
}

