package Arrays;

import java.util.Arrays;

/*

You are given an integer array nums. A subsequence of nums is called a square streak if:

The length of the subsequence is at least 2, and
after sorting the subsequence, each element (except the first element) is the square of the previous number.
Return the length of the longest square streak in nums, or return -1 if there is no square streak.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: nums = [4,3,6,16,8,2]
Output: 3
Explanation: Choose the subsequence [4,16,2]. After sorting it, it becomes [2,4,16].
- 4 = 2 * 2.
- 16 = 4 * 4.
Therefore, [4,16,2] is a square streak.
It can be shown that every subsequence of length 4 is not a square streak.
Example 2:

Input: nums = [2,3,5,6,7]
Output: -1
Explanation: There is no square streak in nums so return -1.


Constraints:

2 <= nums.length <= 10^5
2 <= nums[i] <= 10^5

 */
public class LongestSquareStreakInAnArray {
    /*

    Approach 1 : Using a final array since the number of values are limited and the values itself are limited, for
                faster lookup, using an array and storing the squares iterations.
    Complexity Analysis:
        Time Complexity : O(n * log(n))
        Space Complexity : O(n)
     */
    public final int[] squares = new int[100001];
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int maxValue = 0;
        for(int a : nums){
            double sqrt = Math.sqrt(a);
            if(sqrt == (int)sqrt){
                squares[a] = squares[(int)sqrt] + 1;
                maxValue = Integer.max(maxValue, squares[a]);
            }else{
                squares[a] = 1;
            }
        }
        return maxValue == 0 || maxValue == 1 ? -1 : maxValue;
    }
}
