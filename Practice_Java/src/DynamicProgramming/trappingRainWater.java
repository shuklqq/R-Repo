package DynamicProgramming;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water
it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */
public class trappingRainWater {
    /**
     * Approach 1 : Dynamic Programming
     * Complexity Analysis :
     *      Time Complexity : O(N)
     *      Space Complexity : O(M)
     */
    /*
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

     */
    /**
     * Approach 2 : Two Pointer approach
     * Complexity Analysis :
     *      Time Complexity : O(N)
     *      Space Complexity : O(N)
     */
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                sum += (leftMax - height[left]);
                ++left;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                sum += (rightMax - height[right]);
                --right;
            }
        }
        return sum;
    }
}
