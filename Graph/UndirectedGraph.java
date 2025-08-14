import java.util.*;
public class UndirectedGraph {
    private int v; // Number of vertices
    private List<List<Integer>> abj; // Corrected type

    public UndirectedGraph(int v) {
        this.v = v;
        abj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            abj.add(new ArrayList<>());
        }
    }

    // Add Edge
    void addEdge(int u , int v){
        abj.get(u).add(v);
        abj.get(v).add(u); 
    }
//print the graph
void printGraph(){
  for(int i  = 0;i<v;i++){
    System.out.print(i + ":");
    for(int node : abj.get(i)){
        System.out.println(node+" ");
    }
    System.err.println();
  }
}
public static void main(String[] args) {
    UndirectedGraph g = new UndirectedGraph(5);
    g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        g.printGraph();
}
}
