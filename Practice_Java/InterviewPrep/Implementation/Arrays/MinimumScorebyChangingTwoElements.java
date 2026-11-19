package InterviewPrep.Implementation.Arrays;

import java.util.Arrays;

/*
You are given an integer array nums.

The low score of nums is the minimum absolute difference between any two integers.
The high score of nums is the maximum absolute difference between any two integers.
The score of nums is the sum of the high and low scores.
Return the minimum score after changing two elements of nums.

 

Example 1:

Input: nums = [1,4,7,8,5]

Output: 3

Explanation:

Change nums[0] and nums[1] to be 6 so that nums becomes [6,6,7,8,5].
The low score is the minimum absolute difference: |6 - 6| = 0.
The high score is the maximum absolute difference: |8 - 5| = 3.
The sum of high and low score is 3.
Example 2:

Input: nums = [1,4,3]

Output: 0

Explanation:

Change nums[1] and nums[2] to 1 so that nums becomes [1,1,1].
The sum of maximum absolute difference and minimum absolute difference is 0.
 

Constraints:

3 <= nums.length <= 105
1 <= nums[i] <= 109
*/
public class MinimumScorebyChangingTwoElements {
    public int minimizeSum(int[] nums) {
        /*
        Complexity - O(n) time, single pass, O(1) space.
        All three options only ever read the 3 smallest and 3 largest values,
        so collect those six in one pass instead of sorting.
        */
        int[] small = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}; // small[0] <= small[1] <= small[2]
        int[] large = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}; // large[0] >= large[1] >= large[2]
        for (int x : nums) {
            keepThreeSmallest(small, x);
            keepThreeLargest(large, x);   // not else-if: when n <= 5 a value can be in both groups
        }
        return Math.min(large[0] - small[2],          // A: change the two smallest
               Math.min(large[2] - small[0],          // B: change the two largest
                        large[1] - small[1]));        // C: change one from each end
        
        /*
        Complexity - O(nlogn)
        int len = nums.length;
        if(len < 4){
            return 0;
        }
        Arrays.sort(nums);
        int ans = Math.min((nums[len - 1] - nums[2]), Math.min(((nums[len-3]) - nums[0]), (nums[len-2] - nums[1])));
        return ans;
        */
    }

    // Keeps the three smallest values seen so far, in ascending order.
    private void keepThreeSmallest(int[] small, int x) {
        if (x < small[0])      { small[2] = small[1]; small[1] = small[0]; small[0] = x; }
        else if (x < small[1]) { small[2] = small[1]; small[1] = x; }
        else if (x < small[2]) { small[2] = x; }
    }

    // Keeps the three largest values seen so far, in descending order.
    private void keepThreeLargest(int[] large, int x) {
        if (x > large[0])      { large[2] = large[1]; large[1] = large[0]; large[0] = x; }
        else if (x > large[1]) { large[2] = large[1]; large[1] = x; }
        else if (x > large[2]) { large[2] = x; }
    }
}
