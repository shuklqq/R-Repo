package Heap_PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*

You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval
[lefti, righti].

You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two i
ntervals that are in the same group intersect each other.

Return the minimum number of groups you need to make.

Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and
[5, 8] intersect.



Example 1:

Input: intervals = [[5,10],[6,8],[1,5],[2,3],[1,10]]
Output: 3
Explanation: We can divide the intervals into the following groups:
- Group 1: [1, 5], [6, 8].
- Group 2: [2, 3], [5, 10].
- Group 3: [1, 10].
It can be proven that it is not possible to divide the intervals into fewer than 3 groups.
Example 2:

Input: intervals = [[1,3],[5,6],[8,10],[11,13]]
Output: 1
Explanation: None of the intervals overlap, so we can put all of them in one group.


Constraints:

1 <= intervals.length <= 105
intervals[i].length == 2
1 <= lefti <= righti <= 106

 */
public class DivideIntervalsIntoMinimumNumberOfGroups {
    /*
    Approach 1 : Prefix Sum : Sorting and Priority Queue.
    Complexity Analysis :
        Total Time Complexity:
            Populating the temp array: O(len)
            Sorting the temp array: O(len * log(len))
            Calculating the maximum group size: O(len)
            Thus, the total time complexity is dominated by the sorting step, resulting in: O(len⋅log(len))

        Total Space Complexity:
            temp array: O(len)
            Auxiliary space for sorting: O(len) (in worst case)
            Thus, the total space complexity is: O(len)

        Final Time and Space Complexity:
            Time Complexity: O(len * log(len))
            Space Complexity: O(len)
     */

    /*public int minGroups(int[][] intervals) {
        int len = intervals.length;
        int[][] temp = new int[2*len][2];
        int b = 0;
        for (int[] interval : intervals) {
            temp[b][0] = interval[0];
            temp[b][1] = 1;
            b++;
            temp[b][0] = interval[1] + 1;
            temp[b][1] = -1;
            b++;
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        int maxSize = 0;
        int sum = 0;
        for (int[] ints : temp) {
            sum += ints[1];
            maxSize = Integer.max(maxSize, sum);
        }
        return maxSize;
    }
    -------------------------------------------------------------------------------------------------------------
    */
    /*

    Approach 2 :
    Complexity Analysis: Line Sweep Algorithm with sorted container
        Total Time Complexity:
            Inserting elements into the TreeMap: O(len * log(len))
            Iterating over the TreeMap: O(len)
            Thus, the total time complexity is dominated by the insertion operations, resulting in: O(len⋅log(len))

        Total Space Complexity:
            TreeMap storage: O(len)
            Auxiliary space: O(1)
            Thus, the total space complexity is: O(len)

        Final Time and Space Complexity:
            Time Complexity: O(len * log(len))
            Space Complexity: O(len)

     */

    /*
        public int minGroups(int[][] intervals) {
        TreeMap<Integer, Integer> temp = new TreeMap<>();
        for(int[] a : intervals){
            temp.put(a[0], temp.getOrDefault(a[0], 0) + 1);
            temp.put(a[1] + 1, temp.getOrDefault(a[1] + 1, 0) - 1);
        }
        int prefixSum = 0;
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : temp.entrySet()){
            prefixSum += entry.getValue();
            max = Integer.max(max, prefixSum);
        }
        return max;
    }

     */
}
