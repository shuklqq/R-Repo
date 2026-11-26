package InterviewPrep.Implementation.ArraysAndHashing.HashMapLookups;

import java.lang.reflect.Array;
import java.util.HashMap;

/*
You are given an array of integers nums and an integer target. Exactly one pair of elements in nums adds up to target. Return the indexes of those two elements as [i, j], with the smaller index first.

The two elements must sit at different positions. They may hold the same value. Indexes start at 0.

Example 1
Input: nums = [4, 11, -2, 7, 16], target = 14

Output: [2,4]
Explanation: −2 + 16 = 14, and −2 is at index 2 and 16 at index 4. The 7 at index 3 would need a second 7, and an element cannot be paired with itself.

Example 2
Input: nums = [3, 8, 3], target = 6

Output: [0,2]
Explanation: The two 3s add up to 6. They hold the same value but sit at different positions, so they count.

Example 3
Input: nums = [-6, -14, 25, -8], target = -20

Output: [0,1]
Explanation: −6 + (−14) = −20. The target can be negative, and the pair can be the first two elements.

Topics
Array
Hash Map

*/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff = new HashMap<>();
        for(int a = 0 ; a < nums.length ; a++){
            int num = target - nums[a];
            if(diff.containsKey(num)){
                return new int[]{diff.get(num), a};
            }
            diff.put(nums[a], a);
        }
        return new int[0];
    }
}
