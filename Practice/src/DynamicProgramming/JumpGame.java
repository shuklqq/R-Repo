package DynamicProgramming;
/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the
array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible
to reach the last index.

Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 105
 */
public class JumpGame {
    /**
     * Approach 1 : Dynamic Programming with bottom up approach, using iterations.
     * Complexity Analysis :
     *      Time Complexity : O(n^2)
     *      Space Complexity : O(n)
     */
    /*
    public boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] steps = new boolean[len];
        steps[len-1] = true;
        for(int a  = len-2 ; a >= 0 ; a--){
            int furthestJump = Math.min(a+nums[a], len-1);
            for(int b = a+1 ; b <= furthestJump ; b++){
                if(steps[b]){
                    steps[a] = true;
                    break;
                }
            }
        }
        return steps[0];
    }

     */
    /**
     * Approach 2 : Greedy with the bottom up approach
     * Complexity Analysis :
     *      Time Complexity :
     *      Space Complexity :
     */
    public boolean canJump(int[] nums) {
        int len = nums.length, leftMostTrue = len-1;
        for(int a  = len-2 ; a >= 0 ; a--){
            if(a + nums[a] >= leftMostTrue){
                leftMostTrue = a;
            }
        }
        return leftMostTrue == 0;
    }
}
