// using adjacency matrix
public class Graph {
    int V;//Number of vertices
    int[][] adj;//Adjacency matrix
    int[] size;//Number of neighbors for each vertex
       
    public Graph(int V, int maxEdges){
        this.V=V;
        adj = new int[V][maxEdges];
        size = new int[V];
    }
    // Add edge(undirected)
    void addEdge(int u, int v){
        adj[u][v] = 1;
        adj[v][u] = 1;
    }
    // print graph
    void printGraph(){
        for(int i=0; i<V; i++){
            System.out.print(i + ": ");
            for(int j=0; j<V; j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
     // DFS traversal from a given vertex
    void DepthFirstSearch(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < V; i++) {
            if (adj[v][i] == 1 && !visited[i]) {
                DepthFirstSearch(i, visited);
            }
        }
    }
 // BFS traversal from a given vertex without using Collection Framework
void BreadthFirstSearch(int v) {
    boolean[] visited = new boolean[V];
    int[] queue = new int[V];
    int front = 0, rear = 0;

    visited[v] = true;
    queue[rear++] = v;

    while (front < rear) {
        int curr = queue[front++];
        System.out.print(curr + " ");
        for (int i = 0; i < V; i++) {
            if (adj[curr][i] == 1 && !visited[i]) {
                visited[i] = true;
                queue[rear++] = i;
            }
        }
    }
}
     public static void main(String[] args) {
       Graph g = new Graph(5,5);
        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
         g.printGraph();
        System.out.print("DFS : ");
        g.DepthFirstSearch(0, new boolean[g.V]);
       System.out.println();
       System.out.print("BFS : ");
       g.BreadthFirstSearch(0);
       System.out.println();
    }
}
