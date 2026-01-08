

package DSA.Graphs;

import java.util.*;

public class floodFill {
    private void dfs(int row, int col, int[][] ans, int[][] image, int newColor, int[] delRow, int[] delCol, int initialColor) {
        ans[row][col] = newColor;
        
        int n = image.length;
        int m = image[0].length;
        
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && 
                image[nrow][ncol] == initialColor && ans[nrow][ncol] != newColor) {
                
                dfs(nrow, ncol, ans, image, newColor, delRow, delCol, initialColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialColor = image[sr][sc];
        if (initialColor == newColor) return image;

        int[][] ans = image;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        dfs(sr, sc, ans, image, newColor, delRow, delCol, initialColor);
        
        return ans;
    }

    /*
     * Time Complexity: O(N * M) - Each pixel is visited at most once.
     * Space Complexity: O(N * M) - Worst case recursion stack depth for a grid of size N*M.
     */
}
