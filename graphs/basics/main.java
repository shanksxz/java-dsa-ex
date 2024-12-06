import java.util.*;

public class main {
  static class Edge {
    int src, dest, wt;
    Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("No. of vertex");
    int v = in.nextInt();
    ArrayList<Edge>[] graph = new ArrayList[v];

    for(int i = 0; i<v; i++) {
      graph[i] = new ArrayList<>();
    }

    System.out.println("No. of edges");
    int e = in.nextInt();
    System.out.println("Input for graph");
    for(int i = 0; i<e; i++) {
      int src = in.nextInt();
      int dest = in.nextInt();
      int wt = in.nextInt();

      // add edges in both direction
      graph[src].add(new Edge(src, dest, wt));
      graph[dest].add(new Edge(dest, src, wt));
    }

    System.out.println("Which vertex to check");
    // get neighbors of an vertex
    int vertexToCheck = in.nextInt();

    for(Edge edge: graph[vertexToCheck]) {
      System.out.println("Neighbor: " + edge.dest + " weight: " + edge.wt);
    }
  
  }
}
