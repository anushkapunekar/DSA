package DSA.Graphs;
import java.util.*;

class Node {
    int first;
    int second;
    public Node(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class cycleDetectionInUnidirectedGraph {
    public boolean checkForCycle(int start, int n, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for (Integer neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new Node(neighbor, node));
                } else if (parent != neighbor) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (checkForCycle(i, n, adj, visited)) return true;
            }
        }
        return false;
    }
}
//sc = o(n);
//tc = o(n) + o(2E);