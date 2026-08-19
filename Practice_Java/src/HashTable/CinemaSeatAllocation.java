package HashTable;

import java.util.HashMap;

/*

A cinema has n rows of seats, numbered from 1 to n. Each row has 10 seats, numbered from 1 to 10.

You are given a 2D integer array reservedSeats, where reservedSeats[i] = [rowi, seati] means that seat seati in row rowi is already reserved.

A four-person group must be assigned to four seats in the same row. The group can be seated in one of the following seat blocks:

seats 2, 3, 4, 5
seats 4, 5, 6, 7
seats 6, 7, 8, 9
A block can be used only if none of its seats are reserved. Each seat can be assigned to at most one group.

Return an integer denoting the maximum number of four-person groups that can be assigned.

 

Example 1:



Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
Output: 4
Explanation: The figure above shows an optimal allocation of four groups. Seats marked in blue are already reserved, and each set of four contiguous seats marked in orange is assigned to one group.
Example 2:

Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
Output: 2
Example 3:

Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
Output: 4
 

Constraints:

1 <= n <= 109
1 <= reservedSeats.length <= min(10 * n, 104)
reservedSeats[i] == [rowi, seati]
1 <= rowi <= n
1 <= seati <= 10
All reservedSeats[i] are distinct.
*/

public class CinemaSeatAllocation {
    // Aprraoch 3 : 

    
    // Approach 2: bitmask per row — O(m) time, O(m) space, m = reservedSeats.length
    // public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    //     // bit s of the mask is set when seat s of that row is reserved
    //     HashMap<Integer, Integer> reserve = new HashMap<>();
    //     for (int i = 0; i < reservedSeats.length; i++) {
    //         int row = reservedSeats[i][0];
    //         reserve.put(row, reserve.getOrDefault(row, 0) | (1 << reservedSeats[i][1]));
    //     }
    //     int max = (n - reserve.size()) * 2;
    //     for (int mask : reserve.values()) {
    //         boolean left = (mask & 0b0000111100) == 0;   // seats 2-5 free
    //         boolean middle = (mask & 0b0011110000) == 0; // seats 4-7 free
    //         boolean right = (mask & 0b1111000000) == 0;  // seats 6-9 free
    //         if (left && right) {
    //             max += 2;
    //         } else if (left || middle || right) {
    //             max += 1;
    //         }
    //     }
    //     return max;
    // }

    // Approach 1: HashMap<row, List<reserved seats>> with contains() checks
    /*
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int max = 0;
        HashMap<Integer, List<Integer>> reserve = new HashMap<>();
        int len = reservedSeats.length;
        for (int i = 0; i < len; i++) {
            List<Integer> temp = new ArrayList<>();
            if (reserve.containsKey(reservedSeats[i][0])) {
                temp = reserve.get(reservedSeats[i][0]);
            }
            temp.add(reservedSeats[i][1]);
            reserve.put(reservedSeats[i][0], temp);
        }
        max = (n - reserve.size()) * 2;
        for(Entry<Integer, List<Integer>> entry : reserve.entrySet()) {
            List<Integer> temp = new ArrayList<>();
                temp = entry.getValue();
                if (!(temp.contains(2) || temp.contains(3) || temp.contains(4) || temp.contains(5))) {
                    max++;
                    temp.add(2);
                    temp.add(3);
                    temp.add(4);
                    temp.add(5);
                }
                if (!(temp.contains(4) || temp.contains(5) || temp.contains(6) || temp.contains(7))) {
                    max++;
                    temp.add(4);
                    temp.add(5);
                    temp.add(6);
                    temp.add(7);
                }
                if (!(temp.contains(6) || temp.contains(7) || temp.contains(8) || temp.contains(9))) {
                    max++;
                    temp.add(6);
                    temp.add(7);
                    temp.add(8);
                    temp.add(9);
                }

        }
        return max;
    }
    */
}
