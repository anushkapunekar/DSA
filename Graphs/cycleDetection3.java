package DSA.Graphs;

import java.util.ArrayList;

public class cycleDetection3{
 private boolean dfsCheck(int node, int vis[], int pathVis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        pathVis[node] = 1;

        for (int it : adj.get(node)) {
            
            if (vis[it] == 0) {
                if (dfsCheck(it, vis, pathVis, adj)) 
                    return true;
            } 
           
            else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0; 
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfsCheck(i, vis, pathVis, adj))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Creating a directed cycle: 0 -> 1 -> 2 -> 3 -> 1
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); 

        cycleDetection3 obj = new cycleDetection3();
        if (obj.isCycle(V, adj)) {
            System.out.println("Directed Graph contains a cycle.");
        } else {
            System.out.println("Directed Graph does not contain a cycle.");
        }
    }
}