package DSA.Graphs;

import java.util.ArrayList;

public class cycleDetection2 {
    public boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;

        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) return true;
            } 
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) return true;
            }
        }
        return false;
    }
}
//tc=o(n)+o(2E);
//sc=o(n);