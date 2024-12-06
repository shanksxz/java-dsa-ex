import java.util.*;

public class CycleDetection {
    static class Edge {
        int src, dest, wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visited[], int curr, int parent) {
        visited[curr] = true; 

        for (Edge edge : graph[curr]) {
            // Case 1: If the adjacent node is not visited, putrecurse
            if (!visited[edge.dest]) {
                if (detectCycleUtil(graph, visited, edge.dest, curr)) {
                    return true;
                }
            }
            // Case 2: If the adjacent node is visited and is not the parent of the current node, a cycle is detected
            else if (edge.dest != parent) {
                return true;
            }
        }

        return false; 
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (detectCycleUtil(graph, visited, i, -1)) {
                    return true; // found a cycle in one of the components
                }
            }
        }

        return false; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int v = in.nextInt(); // Number of vertices
        int e = in.nextInt(); // Number of edges
        ArrayList<Edge>[] graph = new ArrayList[v];

        // Initialize adjacency list
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // Input edges
        for (int i = 0; i < e; i++) {
            int src = in.nextInt();
            int dest = in.nextInt();
            int wt = in.nextInt(); // Optional weight (not used in cycle detection)
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt)); // Since it's an undirected graph
        }

        in.close();

        // Check for cycles
        if (detectCycle(graph)) {
            System.out.println("Cycle detected!");
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
