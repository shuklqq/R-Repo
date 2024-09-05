/*

Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.



Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

 */

package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {
    /*
    Approach 1 - recursion with Dynamic Programming
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b * b <= a; b++) {
                dp[a] = Math.min(dp[a], dp[a - b * b] + 1);
            }
        }
        return dp[n];
    }
    /*
    Approach 2 -
     */

}
