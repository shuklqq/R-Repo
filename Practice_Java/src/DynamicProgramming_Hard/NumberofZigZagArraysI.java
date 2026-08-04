package DynamicProgramming_Hard;
/*
You are given three integers n, l, and r.

A ZigZag array of length n is defined as follows:

Each element lies in the range [l, r].
No two adjacent elements are equal.
No three consecutive elements form a strictly increasing or strictly decreasing sequence.
Return the total number of valid ZigZag arrays.

Since the answer may be large, return it modulo 109 + 7.

A sequence is said to be strictly increasing if each element is strictly greater than its previous one (if exists).

A sequence is said to be strictly decreasing if each element is strictly smaller than its previous one (if exists).

 

Example 1:

Input: n = 3, l = 4, r = 5

Output: 2

Explanation:

There are only 2 valid ZigZag arrays of length n = 3 using values in the range [4, 5]:

[4, 5, 4]
[5, 4, 5]​​​​​​​
Example 2:

Input: n = 3, l = 1, r = 3

Output: 10

Explanation:

There are 10 valid ZigZag arrays of length n = 3 using values in the range [1, 3]:

[1, 2, 1], [1, 3, 1], [1, 3, 2]
[2, 1, 2], [2, 1, 3], [2, 3, 1], [2, 3, 2]
[3, 1, 2], [3, 1, 3], [3, 2, 3]
All arrays meet the ZigZag conditions.

 

Constraints:

3 <= n <= 2000
1 <= l < r <= 2000

Hint 1 : 
Use dynamic programming: let dp[i][dir][x] be the count of length-i sequences ending at value x where dir is the required next comparison (0 = down, 1 = up).

Hint 2 :
If the required move is up (dir=1) do dp[i+1][0][y] += sum(dp[i][1][x]) for x < y; if the required move is down (dir=0) do dp[i+1][1][y] += sum(dp[i][0][x]) for x > y.

Hint 3 :
Speed up with prefix/suffix sums so each layer updates in O(m) instead of O(m2); take values mod 109+7.
*/
public class NumberofZigZagArraysI {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        // Only the number of distinct values matters, not l/r themselves.
        int m = r - l + 1;

        // dp[x] for a length-i sequence ending at value-index x:
        //   up[x]   = last step was UP    (so next step must go DOWN)
        //   down[x] = last step was DOWN  (so next step must go UP)
        // Base case = length 1: either direction is open.
        long[] up = new long[m];
        long[] down = new long[m];
        java.util.Arrays.fill(up, 1L);
        java.util.Arrays.fill(down, 1L);

        long[] newUp = new long[m];
        long[] newDown = new long[m];

        // Extend the sequence n-1 times.
        for (int step = 1; step < n; step++) {
            // newUp[y]  = sum of down[x] for x < y   -> running prefix sum
            long prefix = 0;
            for (int y = 0; y < m; y++) {
                newUp[y] = prefix;
                prefix = (prefix + down[y]) % MOD;
            }
            // newDown[y] = sum of up[x] for x > y    -> running suffix sum
            long suffix = 0;
            for (int y = m - 1; y >= 0; y--) {
                newDown[y] = suffix;
                suffix = (suffix + up[y]) % MOD;
            }
            // Swap buffers (avoid reallocation each layer).
            long[] t;
            t = up; up = newUp; newUp = t;
            t = down; down = newDown; newDown = t;
        }

        long ans = 0;
        for (int x = 0; x < m; x++) {
            ans = (ans + up[x] + down[x]) % MOD;
        }
        return (int) ans;
    }
}
