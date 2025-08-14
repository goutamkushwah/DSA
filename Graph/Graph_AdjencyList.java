public class Graph_AdjencyList {
    int V;
    int[][] adjList;
    int[] size; // Number of neighbors for each vertex
    int maxEdges = 10; // Maximum edges per vertex

     // Constructor to initialize the graph with a given number of vertices
    Graph_AdjencyList(int V) {
          this.V = V;
         adjList = new int[V][maxEdges];
        size = new int[V];
     }
    
     void addEdge(int u, int v) {
    adjList[u][size[u]++] = v;
    adjList[v][size[v]++] = u;
}
     
        // Print the adjacency list
    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < size[i]; j++) {
                System.out.print(adjList[i][j] + " ");
            }
            System.out.println();
        }
    }
     void DepthFirstSearch(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");
    for (int j = 0; j < size[v]; j++) {
        int neighbor = adjList[v][j];
        if (!visited[neighbor]) {
            DepthFirstSearch(neighbor, visited);
        }
    }
}
void BreadthFirstSearch(int v) {
    boolean[] visited = new boolean[V];
    int[] queue = new int[V];
    int front = 0, rear = 0;

    visited[v] = true;
    queue[rear++] = v;

    while (front < rear) {
        int curr = queue[front++];
        System.out.print(curr + " ");
        for (int j = 0; j < size[curr]; j++) {
            int neighbor = adjList[curr][j];
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue[rear++] = neighbor;
            }
        }
    }
}
     public static void main(String[] args) {
          Graph_AdjencyList graph = new Graph_AdjencyList(5);
          graph.addEdge(0, 1);
          graph.addEdge(0, 4);
          graph.addEdge(1, 2);
          graph.addEdge(1, 3);
          graph.addEdge(1, 4);
          graph.addEdge(2, 3);
          graph.addEdge(3, 4);
          
          graph.printGraph();
         System.out.print("DFS : ");
         graph.DepthFirstSearch(0, new boolean[graph.V]);
         System.out.println();
         System.out.print("BFS : ");
         graph.BreadthFirstSearch(0);
          System.out.println();
     } 
}
