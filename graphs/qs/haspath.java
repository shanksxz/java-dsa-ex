
import java.util.*;

public class haspath{
  static class Edge {
    int src, dest, wt;
    Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }

  static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
    if(src == dest) return true;
    visited[src] = true;
    for(Edge edge: graph[src]){
      if(!visited[edge.dest] && hasPath(graph, edge.dest, dest, visited)) {
        return true;
     }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner in =  new Scanner(System.in);
    int v = in.nextInt();
    int e = in.nextInt();
    ArrayList<Edge>[] graph = new ArrayList[v];
   
    for(int i = 0; i<v; i++) {
      graph[i] = new ArrayList<>();
    }

    for(int i = 0; i<e; i++) {
      int src = in.nextInt();
      int dest = in.nextInt();
      int wt = in.nextInt();

      graph[src].add(new Edge(src, dest, wt));
      graph[dest].add(new Edge(dest, src, wt));
    }

    in.close();
    boolean[] visited = new boolean[v];

    if(hasPath(graph, 0, 5, visited)){
      System.out.println("path found");
    } else {
      System.out.println("no path found");
    }
  } 
}
