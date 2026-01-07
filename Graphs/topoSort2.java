package DSA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class topoSort2 {
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        
        // Calculate indegrees
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        //  Add nodes with 0 indegree to Queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int topo[] = new int[V];
        int index = 0;

        // Process the Queue
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;

            // Reduce indegree of neighbors
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Example: 5 -> 2, 5 -> 0, 4 -> 0, 4 -> 1, 2 -> 3, 3 -> 1
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        int[] result = topoSort(V, adj);

        System.out.println("Topological Sort (Kahn's Algorithm):");
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}

