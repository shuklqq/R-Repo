package InterviewPrep.Implementation.Hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array nums.

Find the minimum length of a subarray that is not identical to any other subarray in nums.

Return an integer denoting the minimum possible length of such a subarray.

Two subarrays are considered identical if they have the same length and the same elements in corresponding positions.

 

Example 1:

Input: nums = [3,3,3]

Output: 3

Explanation:

Subarrays of length 1: [3] → appears 3 times
Subarrays of length 2: [3, 3] → appears 2 times
Subarrays of length 3: [3, 3, 3] → appears once
The subarray [3, 3, 3] is unique, so the smallest unique subarray length is 3.

Example 2:

Input: nums = [2,1,2,3,3]

Output: 1

Explanation:

Subarrays of length 1:

[2] → appears 2 times
[1] → appears once
[3] → appears 2 times
The subarray [1] is unique, so the smallest unique subarray length is 1.
Example 3:

Input: nums = [1,1,2,2,1]

Output: 2

Explanation:

Subarrays of length 1:

[1] → appears 3 times
[2] → appears 2 times
Subarrays of length 2:

[1, 1] → appears once
[1, 2] → appears once
[2, 2] → appears once
[2, 1] → appears once
There is at least one subarray of length 2 that is unique, so the smallest unique subarray length is 2.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105

Topics
Senior Staff
Array
Hash Table
Binary Search
Rolling Hash
Suffix Array
Hash Function
Weekly Contest 502

*/
public class SmallestUniqueSubarray {

    /*
     * BRUTE FORCE APPROACH — O(n^3) time, O(n^2) space.
     * Try every length from 1 upward; for each length, count every window (as a string key
     * built from its elements) and stop at the first length that has a window occurring once.
     * Correct, but too slow for n = 1e5: an all-equal array forces every length up to n.
     *
    public int smallestUniqueSubarray(int[] nums) {
        for(int window = 1; window < nums.length ; window++){
            HashMap<String, Integer> map= new HashMap<>();
            int first = 0;
            while(first + window <= nums.length){
                String key = Arrays.toString(Arrays.copyOfRange(nums, first, first + window));
                map.merge(key, 1, Integer::sum);
                first++;
            }
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getValue() == 1){
                   return window;
                }
            }
        }
        return nums.length;
    }
    */

    /*
     * OPTIMIZED APPROACH — binary search on length + rolling hash. O(n log n) time, O(n) space.
     *
     * Monotonic: if some window of length L is unique, extending it by one element gives a
     * unique window of length L + 1 (if the longer one occurred twice, so would the shorter).
     * So hasUniqueWindow(L) reads false..false, true..true and we binary search the first true.
     * L = n is always true (the whole array occurs once), so hi = n is a valid starting answer.
     */
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        RollingHash hash = new RollingHash(nums);
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (hasUniqueWindow(hash, n, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /** True if some window of length len occurs exactly once. O(n). */
    private static boolean hasUniqueWindow(RollingHash hash, int n, int len) {
        Map<Long, Integer> counts = new HashMap<>(2 * (n - len + 1));
        for (int start = 0; start + len <= n; start++) {
            counts.merge(hash.key(start, len), 1, Integer::sum);
        }
        for (int count : counts.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Polynomial prefix hashes under two moduli, built once in O(n).
     * key(start, len) gives a window's hash in O(1). Two moduli make a false match between
     * different windows negligibly likely; both hashes (< 2^30 each) are packed into one long.
     * Overflow: every product is < MOD * MOD ~ 1e18, below Long.MAX_VALUE ~ 9.2e18.
     */
    private static final class RollingHash {
        private static final long MOD1 = 1_000_000_007L;
        private static final long MOD2 = 1_000_000_009L;
        private static final long BASE1 = 100_003L;   // bases larger than max nums[i] (1e5)
        private static final long BASE2 = 100_019L;

        private final long[] prefix1, prefix2, pow1, pow2;

        RollingHash(int[] nums) {
            int n = nums.length;
            prefix1 = new long[n + 1];
            prefix2 = new long[n + 1];
            pow1 = new long[n + 1];
            pow2 = new long[n + 1];
            pow1[0] = 1;
            pow2[0] = 1;
            for (int i = 0; i < n; i++) {
                prefix1[i + 1] = (prefix1[i] * BASE1 + nums[i]) % MOD1;
                prefix2[i + 1] = (prefix2[i] * BASE2 + nums[i]) % MOD2;
                pow1[i + 1] = pow1[i] * BASE1 % MOD1;
                pow2[i + 1] = pow2[i] * BASE2 % MOD2;
            }
        }

        long key(int start, int len) {
            long h1 = windowHash(prefix1, pow1, MOD1, start, len);
            long h2 = windowHash(prefix2, pow2, MOD2, start, len);
            return (h1 << 32) | h2;
        }

        private static long windowHash(long[] prefix, long[] pow, long mod, int start, int len) {
            long h = (prefix[start + len] - prefix[start] * pow[len] % mod) % mod;
            return h < 0 ? h + mod : h;
        }
    }
}
