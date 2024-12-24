package BFS;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume
all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {
    /**
     * Approach 1 : Using BFS to traverse the array and find the connected lands to get the number of islands.
     * Complexity Analysis :
     *      Time Complexity : O(m * n)
     *      Space Complexity : O(min(M,N))
     */
    /*
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, numberOfIsland = 0;
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (grid[a][b] == '1') {
                    numberOfIsland++;
                    grid[a][b] = '0';
                    Queue<Integer> pairs = new LinkedList<>();
                    pairs.add(a * n + b);
                    while (!pairs.isEmpty()) {
                        int temp = pairs.remove();
                        int row = temp / n, col = temp % n;

                        if ((row < m - 1) && (grid[row + 1][col] == '1')) {
                            pairs.add((row + 1) * n + (col));
                            grid[row + 1][col] = '0';
                        }
                        if ((col < n - 1) && (grid[row][col + 1] == '1')) {
                            pairs.add((row) * n + (col + 1));
                            grid[row][col + 1] = '0';
                        }
                        if ((row > 0) && (grid[row - 1][col] == '1')) {
                            pairs.add((row - 1) * n + (col));
                            grid[row - 1][col] = '0';
                        }
                        if ((col > 0) && (grid[row][col - 1] == '1')) {
                            pairs.add((row) * n + (col - 1));
                            grid[row][col - 1] = '0';
                        }
                    }
                }
            }
        }
        return numberOfIsland;
    }

     */

    /**
     * Approach 2 : using DFS for node traversal
     * Complexity Analysis :
     *      Time Complexity : O(m * n)
     *      Space Complexity : O(min(M,N))
     */
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}
