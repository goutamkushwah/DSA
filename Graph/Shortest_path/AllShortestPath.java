import java.util.*;

/**
 * A single Java program implementing:
 * 1. Dijkstra's Algorithm       (Non-negative weights)
 * 2. Bellman-Ford Algorithm     (Negative weights allowed)
 * 3. BFS                        (Unweighted graph)
 * 4. Floyd-Warshall Algorithm   (All-pairs shortest paths)
 *
 * Works with both directed and undirected graphs depending on edge input.
 */
public class AllShortestPath {

    // Class to represent a weighted directed edge
    static class Edge {
        int to;       // Destination vertex
        int weight;   // Edge weight

        Edge(int t, int w) {
            to = t;
            weight = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ======== SAMPLE GRAPH CREATION ========
        int V = 5; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Example directed edges (u -> v, weight)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        // ======== MENU ========
        System.out.println("Choose Algorithm:");
        System.out.println("1. Dijkstra (Non-negative weights)");
        System.out.println("2. Bellman-Ford (Negative weights allowed)");
        System.out.println("3. BFS (Unweighted graph)");
        System.out.println("4. Floyd-Warshall (All-pairs shortest path)");
        int choice = sc.nextInt();

        System.out.print("Enter Source Vertex (0 - " + (V - 1) + "): ");
        int src = sc.nextInt();

        // ======== EXECUTE CHOSEN ALGORITHM ========
        switch (choice) {
            case 1:
                runDijkstra(graph, src);
                break;
            case 2:
                runBellmanFord(graph, V, src);
                break;
            case 3:
                runBFS(graph, src);
                break;
            case 4:
                runFloydWarshall(graph, V);
                break;
            default:
                System.out.println("Invalid Choice!");
        }
        sc.close();
    }

    // ------------------ 1. DIJKSTRA ------------------
    static void runDijkstra(List<List<Edge>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];         // Stores shortest distances
        int[] parent = new int[V];       // Stores path parents
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        // Min-heap storing (vertex, distance)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            if (d > dist[node]) continue; // Skip outdated entries

            for (Edge e : graph.get(node)) {
                if (dist[node] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[node] + e.weight;
                    parent[e.to] = node;
                    pq.offer(new int[]{e.to, dist[e.to]});
                }
            }
        }

        printResult(dist, parent, src);
    }

    // ------------------ 2. BELLMAN-FORD ------------------
    static void runBellmanFord(List<List<Edge>> graph, int V, int src) {
        int[] dist = new int[V];
        int[] parent = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        // Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int u = 0; u < V; u++) {
                for (Edge e : graph.get(u)) {
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[e.to]) {
                        dist[e.to] = dist[u] + e.weight;
                        parent[e.to] = u;
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int u = 0; u < V; u++) {
            for (Edge e : graph.get(u)) {
                if (dist[u] != Integer.MAX_VALUE && dist[u] + e.weight < dist[e.to]) {
                    System.out.println("Graph contains a negative weight cycle!");
                    return;
                }
            }
        }

        printResult(dist, parent, src);
    }

    // ------------------ 3. BFS (UNWEIGHTED) ------------------
    static void runBFS(List<List<Edge>> graph, int src) {
        int V = graph.size();
        int[] dist = new int[V];
        int[] parent = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (Edge e : graph.get(node)) {
                if (dist[e.to] == Integer.MAX_VALUE) {
                    dist[e.to] = dist[node] + 1;
                    parent[e.to] = node;
                    q.add(e.to);
                }
            }
        }

        printResult(dist, parent, src);
    }

    // ------------------ 4. FLOYD-WARSHALL ------------------
    static void runFloydWarshall(List<List<Edge>> graph, int V) {
        int[][] dist = new int[V][V];
        int INF = 999999;

        // Initialize distances
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
            for (Edge e : graph.get(i)) {
                dist[i][e.to] = e.weight;
            }
        }

        // Core algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print results
        System.out.println("All-pairs shortest paths:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) System.out.print("INF ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ------------------ Helper: Print Path & Distance ------------------
    static void printResult(int[] dist, int[] parent, int src) {
        System.out.println("Vertex\tDistance\tPath");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(i + "\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]) + "\t\t");
            printPath(i, parent);
            System.out.println();
        }
    }

    // Recursive path printing
    static void printPath(int vertex, int[] parent) {
        if (vertex == -1) return;
        printPath(parent[vertex], parent);
        System.out.print(vertex + " ");
    }
}
