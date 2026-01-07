package DSA.Graphs;

 import java.util.*;

public class bipartiteGraph2 {
 private static boolean check(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;

        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!check(it, 1 - col, color, adj)) return false;
            } else if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!check(i, 0, color, adj)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 3; // (0-1-2-0) -> NOT Bipartite
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(0); adj.get(0).add(2);

        if (isBipartite(V, adj)) System.out.println("DFS: Graph is Bipartite");
        else System.out.println("DFS: Graph is NOT Bipartite");
    }
}