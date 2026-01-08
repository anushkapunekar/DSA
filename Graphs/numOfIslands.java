package DSA.Graphs;
import java.util.*;

public class numOfIslands {
 static class Pair {
        int first;
        int second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // BFS function to traverse the island
    private static void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.poll().first;
            int col = q.poll().second;

            // Checking all 8 neighbors
            for (int delrow = -1; delrow <= 1; delrow++) {
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                        && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    // Function to find the number of islands
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Example Grid: 3 islands if using 8-direction logic
        char[][] grid = {
            {'0', '1', '1', '1', '0'},
            {'0', '0', '0', '1', '1'},
            {'0', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'}
        };

        numOfIslands solver = new numOfIslands();
        int result = solver.numIslands(grid);

        System.out.println("The number of islands is: " + result);
    }
}
//tc=o(n*m)
//sc=o(n*m)