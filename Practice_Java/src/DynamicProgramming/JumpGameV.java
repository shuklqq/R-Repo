package DynamicProgramming;
/*
Given an array of integers arr and an integer d. In one step you can jump from index i to index:

i + x where: i + x < arr.length and  0 < x <= d.
i - x where: i - x >= 0 and  0 < x <= d.
In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).

You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.

Notice that you can not jump outside of the array at any time.

 

Example 1:


Input: arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
Output: 4
Explanation: You can start at index 10. You can jump 10 --> 8 --> 6 --> 7 as shown.
Note that if you start at index 6 you can only jump to index 7. You cannot jump to index 5 because 13 > 9. You cannot jump to index 4 because index 5 is between index 4 and 6 and 13 > 9.
Similarly You cannot jump from index 3 to index 2 or index 1.
Example 2:

Input: arr = [3,3,3,3,3], d = 3
Output: 1
Explanation: You can start at any index. You always cannot jump to any index.
Example 3:

Input: arr = [7,6,5,4,3,2,1], d = 1
Output: 7
Explanation: Start at index 0. You can visit all the indicies. 
 

Constraints:

1 <= arr.length <= 1000
1 <= arr[i] <= 105
1 <= d <= arr.length
*/
public class JumpGameV {
    public int maxJumps(int[] arr, int d) {
        int len = arr.length;
        int[] dp = new int[len];
        for(int a = 0 ; a < len ; a++){
            dp[a] = -1;
        }
        int max = 0;
        for(int a = 0 ; a < len ; a++){
            if(dp[a] == -1){
                dp[a] = maxPossibleJumps(arr, dp, a, d);
            }
            max = Math.max(max, dp[a]);
        }
        return max;
    }

    public int maxPossibleJumps(int[] arr, int[] dp, int currentIndex, int jumpLength){
        if(dp[currentIndex] != -1) return dp[currentIndex];  // FIX 1: memoization check

        int leftItr = currentIndex - 1;
        int rightItr = currentIndex + 1;
        int leftMax = 0;   // FIX 2: 0 not -1; dp[i] includes self, so base contributes 0 from neighbors
        int rightMax = 0;
        int len = arr.length;

        while(leftItr >= 0 && leftItr >= (currentIndex - jumpLength)){
            if(arr[leftItr] < arr[currentIndex]){
                if(dp[leftItr] == -1) {
                    dp[leftItr] = maxPossibleJumps(arr, dp, leftItr, jumpLength); // FIX 1
                }
                leftMax = Math.max(leftMax, dp[leftItr]);  // FIX 3: track max, not overwrite
                leftItr--;                                  // FIX 4: advance iterator
            } else {
                break;
            }
        }

        while(rightItr < len && rightItr <= (currentIndex + jumpLength)){  // FIX 5: <= to include d steps
            if(arr[rightItr] < arr[currentIndex]){
                if(dp[rightItr] == -1) {
                    dp[rightItr] = maxPossibleJumps(arr, dp, rightItr, jumpLength); // FIX 1
                }
                rightMax = Math.max(rightMax, dp[rightItr]); // FIX 3
                rightItr++;                                   // FIX 4
            } else {
                break;
            }
        }

        dp[currentIndex] = 1 + Math.max(leftMax, rightMax);  // FIX 2: +1 counts currentIndex itself
        return dp[currentIndex];
    }
}