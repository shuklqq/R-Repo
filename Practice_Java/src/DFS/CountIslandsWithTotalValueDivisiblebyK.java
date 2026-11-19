package DFS;
/*
You are given an m x n matrix grid and a positive integer k. An island is a group of positive integers (representing land) that are 4-directionally connected (horizontally or vertically).

The total value of an island is the sum of the values of all cells in the island.

Return the number of islands with a total value divisible by k.

 

Example 1:


Input: grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5

Output: 2

Explanation:

The grid contains four islands. The islands highlighted in blue have a total value that is divisible by 5, while the islands highlighted in red do not.

Example 2:


Input: grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3

Output: 6

Explanation:

The grid contains six islands, each with a total value that is divisible by 3.

 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
0 <= grid[i][j] <= 106
1 <= k <= 106
*/

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean[][] visited;

    /**
     * Approach 1 : Recursive DFS (flood fill) with a visited grid.
     * Scan every cell; each unvisited land cell is the start of a new island. islandSum() answers the
     * question "what is the total value of the island containing (a, b)?", so the outer loop only has
     * to test that value against k. Framing it as a value (not "may I visit this cell?") is what lets
     * the bounds / water / visited check live in ONE place inside islandSum().
     * Complexity Analysis :
     *      Time Complexity : O(m * n) - each cell is entered as a real visit at most once (it is marked
     *                        visited immediately), plus at most 4 O(1) guard-rejected calls from its
     *                        neighbours.
     *      Space Complexity : O(m * n) - the visited grid, plus the recursion stack, which can reach
     *                         m * n frames on a snake-shaped island (that is the weakness Approach 2 fixes).
     */
    public int countIslands(int[][] grid, int k) {
        int len = grid.length;
        int len2 = grid[0].length;
        visited = new boolean[len][len2];
        int count = 0;
        for(int a = 0 ; a < len ; a++){
            for(int b = 0 ; b < len2 ; b++){
                if(!visited[a][b] && grid[a][b] != 0){
                    if(islandSum(grid, a, b, len, len2) % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Returns the total value of the island containing (a, b), marking every cell of it visited.
     * The single guard at the top is the fail-open default: an off-grid, water (0) or already-visited
     * cell contributes 0. Because the guard is here, the four recursive calls below need no conditions
     * of their own - no corner / edge / interior cases.
     * visited[a][b] is set BEFORE recursing; setting it after would let two adjacent cells call each
     * other forever.
     * Returns long: an island can hold up to 10^5 cells of value up to 10^6 (sum up to 10^11), which
     * overflows int. grid[a][b] (int) + long promotes to long automatically.
     */
    public long islandSum(int[][] grid, int a, int b, int len, int len2){
        if(a < 0 || b < 0 || a >= len || b >= len2 || visited[a][b] || grid[a][b] == 0){
            return 0;
        }
        visited[a][b] = true;
        return grid[a][b] + islandSum(grid, a + 1, b, len, len2) + islandSum(grid, a - 1, b, len, len2) + islandSum(grid, a, b + 1, len, len2) + islandSum(grid, a, b - 1, len, len2);
    }

    /**
     * Approach 2 : Iterative DFS with an explicit stack (the alternative to Approach 1).
     * Same scan, same guard, same answer - but the cells still to be visited sit on a heap-allocated
     * ArrayDeque instead of the JVM call stack. Approach 1 recurses once per cell of an island, so a
     * snake-shaped island of m * n cells needs m * n stack frames and can throw StackOverflowError;
     * this version cannot.
     * A cell is marked visited when it is PUSHED (not when popped), so each cell enters the stack at
     * most once and the stack never holds more than m * n entries.
     * Complexity Analysis :
     *      Time Complexity : O(m * n) - each cell is pushed and popped at most once, and each pop does
     *                        4 O(1) neighbour checks.
     *      Space Complexity : O(m * n) - the visited grid plus the stack (worst case m * n entries).
     *                         No recursion, so no call-stack growth.
     */
    public int countIslandsIterative(int[][] grid, int k) {
        int len = grid.length;
        int len2 = grid[0].length;
        visited = new boolean[len][len2];
        int count = 0;
        for(int a = 0 ; a < len ; a++){
            for(int b = 0 ; b < len2 ; b++){
                if(!visited[a][b] && grid[a][b] != 0){
                    if(islandSumIterative(grid, a, b, len, len2) % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /** The four 4-directional moves: down, up, right, left. */
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * Iterative twin of islandSum(): same contract (total value of the island containing (a, b), all
     * of its cells marked visited), driven by an explicit stack instead of recursion.
     * Precondition: (a, b) is in bounds, is land and is unvisited - the caller's loop guarantees that.
     * The neighbour check is the same guard as Approach 1, just applied before pushing.
     */
    public long islandSumIterative(int[][] grid, int a, int b, int len, int len2){
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{a, b});
        visited[a][b] = true;
        long sum = 0;
        while(!stack.isEmpty()){
            int[] cell = stack.pop();
            sum += grid[cell[0]][cell[1]];
            for(int[] d : DIRECTIONS){
                int na = cell[0] + d[0];
                int nb = cell[1] + d[1];
                if(na < 0 || nb < 0 || na >= len || nb >= len2 || visited[na][nb] || grid[na][nb] == 0){
                    continue;
                }
                visited[na][nb] = true;
                stack.push(new int[]{na, nb});
            }
        }
        return sum;
    }
}
