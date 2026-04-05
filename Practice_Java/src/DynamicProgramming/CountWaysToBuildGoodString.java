package DynamicProgramming;

import java.util.Arrays;

/*
Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at
each step perform either of the following:
Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.
A good string is a string constructed by the above process having a length between low and high (inclusive).
Return the number of different good strings that can be constructed satisfying these properties. Since the answer can
be large, return it modulo 109 + 7.

Example 1:
Input: low = 3, high = 3, zero = 1, one = 1
Output: 8
Explanation:
One possible valid good string is "011".
It can be constructed as follows: "" -> "0" -> "01" -> "011".
All binary strings from "000" to "111" are good strings in this example.

Example 2:
Input: low = 2, high = 3, zero = 1, one = 2
Output: 5
Explanation: The good strings are "00", "11", "000", "110", and "011".

Constraints:
1 <= low <= high <= 105
1 <= zero, one <= low
 */
public class CountWaysToBuildGoodString {
    /**
     * Approach 1 : Dynamic Programming using Iterative Approach.
     * Complexity Analysis :
     *      Time Complexity : O(High)
     *      Space Complexity : O(High)
     */
    /*
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] ans = new int[high + 1];
        ans[0] = 1;
        int mod = 1_000_000_007;
        for(int a = 1 ; a <= high ; a++){
            if(a >= zero){
                ans[a] += ans[a - zero];
            }
            if(a >= one){
                ans[a] += ans[a - one];
            }
            ans[a] %= mod;
        }
        int sum = 0;
        for(int a = low ; a <= high ; a++){
            sum += ans[a];
            sum %= mod;
        }
        return sum;
    }

     */

    /**
     * Approach 2 : Dynamic Programming Recursive Approach
     * Complexity Analysis :
     *      Time Complexity : O(High)
     *      Space Complexity : O(High)
     */
    int[] dp;
    int mod = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        int ans = 0;
        for(int end = low ; end <= high ; end++){
            ans += countGoodStringsOfSpecificLength(end, zero, one);
            ans %= mod;
        }
        return ans;
    }
    public int countGoodStringsOfSpecificLength(int end, int zero, int one){
        if(dp[end] != -1){
            return dp[end];
        }
        int count = 0;
        if(end >= one){
            count += countGoodStringsOfSpecificLength(end - one, zero, one);
        }
        if(end >= zero){
            count += countGoodStringsOfSpecificLength(end - zero, zero, one);
        }
        dp[end] = count % mod;
        return dp[end];
    }
}
