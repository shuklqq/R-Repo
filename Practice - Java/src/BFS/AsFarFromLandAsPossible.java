/*

Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.



Example 1:


Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.
Example 2:


Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.


Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1

 */

package BFS;

import java.util.LinkedList;
import java.util.Queue;

class AsFarFromLandAsPossible {
    class node {
        int x;
        int y;

        node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int maxDistance(int[][] grid) {
        Queue<node> traversal = new LinkedList<>();
        int size = grid.length;
        for(int a = 0 ; a < size ; a++){
            for(int b = 0 ; b < size ; b++){
                if(grid[a][b] == 1){
                    traversal.add(new node(a,b));
                }
            }
        }
        if(traversal.isEmpty()){
            return -1;
        }
        int distance = 0;
        int maxDistance = 0;
        int flag = 0;
        while(!traversal.isEmpty()){
            int z = traversal.size();
            distance++;
            for(int a = 0 ; a < z ; a++){
                node temp = traversal.poll();
                int xElement = temp.x;
                int yElement = temp.y;
                if(xElement > 0 && grid[xElement -1][yElement] == 0){
                    traversal.add(new node(xElement - 1, yElement));
                    grid[xElement -1][yElement] = distance;
                    maxDistance = distance;
                    flag = 1;
                }
                if(yElement > 0 && grid[xElement][yElement - 1] == 0){
                    traversal.add(new node(xElement, yElement - 1));
                    grid[xElement][yElement - 1] = distance;
                    maxDistance = distance;
                    flag = 1;
                }
                if(xElement < size-1 && grid[xElement + 1][yElement] == 0){
                    traversal.add(new node(xElement + 1, yElement));
                    grid[xElement + 1][yElement] = distance;
                    maxDistance = distance;
                    flag = 1;
                }
                if(yElement < size - 1 && grid[xElement][yElement + 1] == 0){
                    traversal.add(new node(xElement, yElement + 1));
                    grid[xElement][yElement + 1] = distance;
                    maxDistance = distance;
                    flag = 1;
                }
            }
        }
        if(flag == 0){
            return -1;
        }
        return maxDistance;
    }
}
