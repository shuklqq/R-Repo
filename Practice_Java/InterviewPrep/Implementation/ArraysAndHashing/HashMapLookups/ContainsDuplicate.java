package InterviewPrep.Implementation.ArraysAndHashing.HashMapLookups;

import java.util.HashSet;

/*

You are given an array of integers nums. Return true if some value appears in it at least twice, and false if every value in it is different.

The two copies of a value can be anywhere in the array. They do not have to be next to each other.

Example 1
Input: nums = [4, -7, 12, 0, -7, 9]

Output: true
Explanation: The value -7 appears at index 1 and again at index 4. One value that appears twice is enough for true.

Example 2
Input: nums = [8, 3, -2, 15, 6]

Output: false
Explanation: All five values are different, so no value appears twice.

Example 3
Input: nums = [-1000000000, 1000000000, -1000000000]

Output: true
Explanation: The smallest value allowed appears at both ends of the array. The value between the two copies does not matter.

✦
Check your understanding
Work out the answer for this input before you write any code.

1
2
nums = [5, -5, 3]

true

false
Constraints
1 ≤ nums.length ≤ 105
-109 ≤ nums[i] ≤ 109

Topics
Array
Hash Map
Sorting

*/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> values = new HashSet<>();
        for(int num : nums){
            if(values.contains(num)){
                return true;
            }
            values.add(num);
        }
        return false;
    }
}
