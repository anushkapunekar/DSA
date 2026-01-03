package DSA.Graphs;

import java.util.ArrayList;

public class dfs {
    public void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (Integer neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj, result);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        
        // Start DFS from node 1
        dfs(1, visited, adj, result);
        
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(4);
        adj.get(4).add(2);
        adj.get(3).add(5);
        adj.get(5).add(3);

        dfs sol = new dfs();
        ArrayList<Integer> result = sol.dfsOfGraph(n, adj);

        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }
}
//tc=0(n)+(2*E)
//sc=(o)n approx