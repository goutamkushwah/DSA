public class DirectedGraph {
    int V;
    int[][] adjList;
    int[] size;
    int maxEdges=10;
    public DirectedGraph(int V) {
        this.V = V;
       adjList = new int [V][maxEdges];
       size = new int[V];       

    }
    // Add a directed edge from parent to child
    void addEdge(int parent, int child) {
        adjList[parent][size[parent]++] = child;
    }
     void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + "-> ");
            for (int j = 0; j < size[i]; j++) {
                System.out.print(adjList[i][j] + " ");
            }
            System.out.println();
        }
    }
    void DFS(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < size[v]; i++) {
            int child = adjList[v][i];
            if (!visited[child]) {
                DFS(child, visited);
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
        for (int i = 0; i < size[curr]; i++) {
            int child = adjList[curr][i];
            if (!visited[child]) {
                visited[child] = true;
                queue[rear++] = child;
            }
        }
    }
}
        public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(5);
        g.addEdge(0, 1); // 0 is root
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);

        g.printGraph();
        System.out.print("BFS: ");
          g.BFS(0);
         System.out.println();System.out.print("BFS: ");
        boolean[] visited = new boolean[g.V];
        g.DFS(0, visited);
        System.out.println();
    }
}