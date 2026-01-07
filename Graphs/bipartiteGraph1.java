package DSA.Graphs;

import java.util.*;
import java.util.ArrayList;

public class bipartiteGraph1 {

    private static boolean check(int start, int[] color, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                }
                
                else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!check(i, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Square Graph (0-1-2-3-0) -> Bipartite
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        adj.get(2).add(3); adj.get(3).add(2);
        adj.get(3).add(0); adj.get(0).add(3);

        if (isBipartite(V, adj)) System.out.println("BFS: Graph is Bipartite");
        else System.out.println("BFS: Graph is NOT Bipartite");
    }
}