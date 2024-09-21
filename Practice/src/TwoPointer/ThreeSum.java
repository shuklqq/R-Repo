/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

 */

package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> memo = new ArrayList<>();
        HashMap<Integer,Integer> memory = new HashMap<>();
        Arrays.sort(nums);
        int top = 0;
        while (top < nums.length &&  nums[top] <= 0) {
            int bottom = nums.length - 1;
            if(memory.containsKey(nums[top]) && memory.get(nums[top])== nums[bottom]){
                top++;
                continue;
            }
            while (bottom > top && nums[bottom] >= 0) {
                if(memory.containsKey(nums[top]) && memory.get(nums[top])== nums[bottom]){
                    bottom--;
                    continue;
                }
                int sum = nums[top] + nums[bottom];
                if (sum >= 0) {
                    int temp = top + 1;
                    while (sum + nums[temp] <= 0 && (temp < bottom) && (temp > top)) {
                        int totalSum = sum + nums[temp];
                        if (totalSum == 0) {
                            List<Integer> temp2 = new ArrayList<>();
                            temp2.add(nums[top]);
                            temp2.add(nums[temp]);
                            temp2.add(nums[bottom]);
                            if(!memo.contains(temp2)){
                                memo.add(temp2);
                            }
                        }
                        temp++;
                    }
                } else if (sum < 0) {
                    int temp = bottom - 1;
                    while (sum + nums[temp] >= 0) {
                        int totalSum = sum + nums[temp];
                        if (totalSum == 0) {
                            List<Integer> temp2 = new ArrayList<>();
                            temp2.add(nums[top]);
                            temp2.add(nums[temp]);
                            temp2.add(nums[bottom]);
                            if(!memo.contains(temp2)){
                                memo.add(temp2);
                            }
                        }
                        temp--;
                    }
                }
                memory.put(nums[top], nums[bottom]);
                bottom--;
            }
            top++;
        }
        return memo;
    }
    public static void main(String[] args){
        int[] a = {-1,0,1,2,-1,-4};
        ThreeSum sum = new ThreeSum();
        List<List<Integer>> res = sum.threeSum(a);
        res.stream().forEach(c -> c.stream().forEach(b -> System.out.print(b)));
    }
}
