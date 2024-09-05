/*

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

 */

package BFS;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    /*
Approach 1 using Queue of pair to manage BFS traversal
 */
//    public int orangesRotting(int[][] grid) {
//        Queue<Pair<Integer,Integer>> Rotten1 = new ArrayDeque<>();
//        Queue<Pair<Integer,Integer>> Rotten2 = new ArrayDeque<>();
//        Queue<Pair<Integer,Integer>> Fresh = new ArrayDeque<>();
//
//        for(int a = 0 ; a < grid.length ; a++){
//            for(int b = 0 ; b < grid[0].length ; b++){
//                if(grid[a][b] == 2){
//                    Rotten1.add(new Pair<Integer,Integer>(a,b));
//                }
//                else if(grid[a][b] == 1){
//                    Fresh.add(new Pair<Integer,Integer>(a,b));
//                }
//            }
//        }
//        int time = 0;
//        while(!Rotten1.isEmpty()){
//            Pair<Integer, Integer> temp = Rotten1.poll();
//            Integer row = temp.getKey();
//            Integer column = temp.getValue();
//            Pair<Integer, Integer> right = new Pair<>(row,column + 1);
//            Pair<Integer, Integer> left = new Pair<>(row,column - 1);
//            Pair<Integer, Integer> up = new Pair<>(row - 1,column);
//            Pair<Integer, Integer> down = new Pair<>(row + 1,column);
//            if(Fresh.contains(right)){
//                Fresh.remove(right);
//                Rotten2.add(right);
//            }
//            if(Fresh.contains(left)){
//                Fresh.remove(left);
//                Rotten2.add(left);
//            }
//            if(Fresh.contains(up)){
//                Fresh.remove(up);
//                Rotten2.add(up);
//            }
//            if(Fresh.contains(down)){
//                Fresh.remove(down);
//                Rotten2.add(down);
//            }
//            if(Rotten1.isEmpty() && !Rotten2.isEmpty()){
//                while(!Rotten2.isEmpty()){
//                    Rotten1.add(Rotten2.poll());
//                }
//                time++;
//            }
//        }
//        if(!Fresh.isEmpty()){
//            return -1;
//        }
//        return time;
//      }

    /*
    Approach 2 - Create a class for orange which stores the coordinate of orange and create a queue of it for BFS traversal.
     */
    class Orange {
        int x;
        int y;

        Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Orange> rotten = new LinkedList<>();
        int row = grid.length;
        int column = grid[0].length;
        int freshCount = 0;
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < column; b++) {
                if (grid[a][b] == 2) {
                    rotten.add(new Orange(a, b));
                } else if (grid[a][b] == 1) {
                    freshCount++;
                }
            }
        }
        int seconds = -1;
        if (rotten.isEmpty() && freshCount == 0) {
            return 0;
        }
        while (!rotten.isEmpty()) {
            int size = rotten.size();
            for (int a = 0; a < size; a++) {
                Orange temp = rotten.poll();
                if (temp.x > 0 && grid[temp.x - 1][temp.y] == 1) {
                    freshCount--;
                    grid[temp.x - 1][temp.y] = 2;
                    rotten.add(new Orange(temp.x - 1, temp.y));
                }
                if (temp.y > 0 && grid[temp.x][temp.y - 1] == 1) {
                    freshCount--;
                    grid[temp.x][temp.y - 1] = 2;
                    rotten.add(new Orange(temp.x, temp.y - 1));
                }
                if (temp.x < row - 1 && grid[temp.x + 1][temp.y] == 1) {
                    freshCount--;
                    grid[temp.x + 1][temp.y] = 2;
                    rotten.add(new Orange(temp.x + 1, temp.y));
                }
                if (temp.y < column - 1 && grid[temp.x][temp.y + 1] == 1) {
                    freshCount--;
                    grid[temp.x][temp.y + 1] = 2;
                    rotten.add(new Orange(temp.x, temp.y + 1));
                }
            }
            seconds++;
        }
        if (freshCount != 0) {
            return -1;
        }
        return seconds;
    }
}
