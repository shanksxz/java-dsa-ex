import java.util.*;

public class cycle {
    static class Edge {
        int src, dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph, int vertices) {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (dfs(graph, i, visited, recStack)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] recStack) {
        visited[curr] = true;
        recStack[curr] = true;

        for (Edge edge : graph[curr]) {
            if (!visited[edge.dest]) {
                if (dfs(graph, edge.dest, visited, recStack)) {
                    return true;
                }
            } else if (recStack[edge.dest]) {
                return true;
            }
        }

        recStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges to the graph
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 2));

        if (hasCycle(graph, vertices)) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
}
