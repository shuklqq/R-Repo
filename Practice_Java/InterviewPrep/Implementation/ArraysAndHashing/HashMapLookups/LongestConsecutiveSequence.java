package InterviewPrep.Implementation.ArraysAndHashing.HashMapLookups;

import java.security.KeyStore.Entry;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*

You are given an array of integers nums. Return the length of the longest run of consecutive values that all appear in nums.

A run of consecutive values is a list of whole numbers where each one is exactly one more than the one before, such as 4, 5, 6, 7. The values of a run can sit anywhere in nums, in any order. A value that appears more than once counts only once.

Example 1
Input: nums = [8, 3, 10, 4, 9, 1, 2, 11, 7]

Output: 5
Explanation: 7, 8, 9, 10 and 11 all appear, so they form a run of length 5. 1, 2, 3 and 4 form a shorter run of length 4.

Example 2
Input: nums = [0, -1, 2, -2, 1, 1, 0]

Output: 5
Explanation: Every value from −2 to 2 appears, which is a run of length 5. The repeated 0 and 1 count once each, so they do not make the run longer.

Example 3
Input: nums = [1000000000, -1000000000, 999999999]

Output: 2
Explanation: 999999999 and 109 form a run of length 2. −109 has no neighbour in the array, so on its own it is a run of length 1.

Constraints
0 ≤ nums.length ≤ 105
-109 ≤ nums[i] ≤ 109

Topics
Array
Hash Map

*/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        /*
        // TreeSet sorts in place so each add is logn and hence solution is O(nlogn)
        if(nums.length == 0){
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num);
        }
        int prev = set.pollFirst();
        int curr = 1;
        int max = 1;
        for(int num : set){
            if(num - prev == 1){
                curr++;
            }else{
                max = Math.max(max, curr);
                curr = 1;
            }
            prev = num;
        }
        return Math.max(max, curr);
        */
       
       // Using Hashset and lookup makes lookup in O(1) for 2*n elements making O(2*n) and hence O(n)
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 0;
        for(int num : set){
            if(set.contains(num-1)){
                continue;
            }

            int maxLength = 1;
            while(set.contains(num + maxLength)){
                maxLength++;
            }
            max = Math.max(maxLength, max);
        }
        return max;
    }
}
