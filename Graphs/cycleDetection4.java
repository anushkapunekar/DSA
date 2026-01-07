package DSA.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cycleDetection4 {
    public static boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        
        //  Calculate indegree of all nodes
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Add nodes with indegree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // To keep track of how many nodes we visit

        // Process the queue
        while (!q.isEmpty()) {
            int node = q.poll();
            count++; // Increment count for every node removed from queue

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        //  If count is equal to V, all nodes were visited (No Cycle)
        // If count is NOT equal to V, some nodes were stuck in a cycle
        return (count != V);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        //  cycle: 0 -> 1 -> 2 -> 3 -> 1
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); 

        if (hasCycle(V, adj)) {
            System.out.println("Cycle detected using BFS!");
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
