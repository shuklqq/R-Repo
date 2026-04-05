package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
So it is impossible.


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    /**
     * Approach 1 : Topological sort using Kahn's Algorithms to find the circles while doing DFS
     * Complexity Analysis :
     *      Time Complexity :
     *      Space Complexity :
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList[] adjList = new ArrayList[numCourses];
        for(int a = 0 ; a < numCourses ; a++){
            adjList[a] = new ArrayList<>();
        }
        for(int a = 0 ; a < prerequisites.length ; a++){
            int to = prerequisites[a][0];
            int from = prerequisites[a][1];
            adjList[from].add(to);
            inDegree[to]++;
        }
        int count = 0;
        Queue<Integer> zeroInDegreeNodes = new LinkedList<>();
        for(int a = 0 ; a < numCourses ; a++){
            if(inDegree[a] == 0){
                zeroInDegreeNodes.offer(a);
            }
        }
        while(!zeroInDegreeNodes.isEmpty()){
            int node = zeroInDegreeNodes.poll();
            count++;
            for(Object neighbor : adjList[node]){
                inDegree[(int) neighbor] --;
                if(inDegree[(int) neighbor] == 0){
                    zeroInDegreeNodes.offer((Integer) neighbor);
                }
            }
        }
        return count == numCourses;
    }
}
