import java.util.*;

public class bfs {
  static class Edge {
    int src, dest, wt;
    Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }

  public static void Bfs(ArrayList<Edge>[] graph, int start){
    boolean[] visited = new boolean[graph.length];
    Queue<Integer> q = new LinkedList<>();

    // start
    visited[start] = true;
    q.offer(start);

    while(!q.isEmpty()){
      int curr = q.poll();
      System.out.print(curr + " ");

      for(Edge edge : graph[curr]) {
        if(!visited[edge.dest]) {
          visited[edge.dest] = true;
          q.offer(edge.dest);
        }
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

    Bfs(graph, 0);
  } 
}
