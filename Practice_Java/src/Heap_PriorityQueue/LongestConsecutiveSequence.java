/*

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109

 */

package Heap_PriorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Queue<Integer> heap = new PriorityQueue<>(
                (a , b) -> a - b
        );
        if(nums.length == 0){
            return 0;
        }
        for (int num : nums) {
            heap.add(num);
        }
        int previous = heap.poll();
        int count = 1;
        int maxCount = count;
        while(!heap.isEmpty()){
            int now = heap.poll();
            if(previous == now){
                continue;
            }
            if(previous+1 == now){
                count++;
            }else{
                count = 1;
            }
            previous = now;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
