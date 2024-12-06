import java.util.*;

public class dfs{
  static class Edge {
    int src, dest, wt;
    Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }

  static void Dfs(ArrayList<Edge>[] graph, int start, boolean[] visited){
    visited[start] = true;
    System.out.print(start + " ");

    for(Edge edge: graph[start]){
      if(!visited[edge.dest]) {
        Dfs(graph, edge.dest, visited);
      }
    }
  }

  static void dfsWrapper(ArrayList<Edge>[] graph, int v) {
    boolean[] visited = new boolean[v];
    for(int i = 0; i<v; i++) {
      if(!visited[i]) {
        Dfs(graph, i, visited);
      }
    }
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

    dfsWrapper(graph, v);
  } 
}
