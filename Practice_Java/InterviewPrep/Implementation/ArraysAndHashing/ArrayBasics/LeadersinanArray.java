package InterviewPrep.Implementation.ArraysAndHashing.ArrayBasics;

import java.util.ArrayList;
import java.util.List;

/*
You are given an array of integers nums. An element is a leader if it is strictly greater than every element to its right. The last element has nothing to its right, so it is always a leader.

Return the values of all the leaders, in the order they appear in nums.

Example 1
Input: nums = [5, 9, 2, 7, 3, 4]

Output: [9,7,4]
Explanation: 9 is greater than 2, 7, 3 and 4, and 7 is greater than 3 and 4. The last element, 4, is a leader by definition. 5 has 9 to its right, and 2 and 3 each have a larger value after them.

Example 2
Input: nums = [4, 6, 6, 1]

Output: [6,1]
Explanation: The first 6 has another 6 to its right. It is not strictly greater than that 6, so it is not a leader. The second 6 is greater than 1, and 1 is last.

Example 3
Input: nums = [-3, -8, -5]

Output: [-3,-5]
Explanation: −3 is greater than both −8 and −5. −8 has the larger −5 to its right, and −5 is last.

✦
Check your understanding
Work out the answer for this input before you write any code.

1
2
nums = [3, 1, 3, 2]

[3,2]

[3,3,2]

[2,3]

[3]
Constraints
1 ≤ nums.length ≤ 105
-109 ≤ nums[i] ≤ 109


Topics
Array

*/
public class LeadersinanArray {
    public int[] leaders(int[] nums) {
        List<Integer> leader = new ArrayList<>();
        int len = nums.length;
        leader.add(nums[len-1]);
        int max = nums[len-1];
        for(int a = len - 2 ; a >= 0 ; a--){
            if(nums[a] > max){
                leader.add(nums[a]);
                max = nums[a];
            }
        }
        int[] result = new int[leader.size()];
        for (int i = 0; i < leader.size(); i++) {
            result[i] = leader.get(leader.size() - 1 - i);
        }
        return result;
    }
}
