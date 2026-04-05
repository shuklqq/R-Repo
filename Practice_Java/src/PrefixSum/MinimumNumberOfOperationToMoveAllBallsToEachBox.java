package PrefixSum;
/*
You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and
'1' if it contains one ball.

In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
Note that after doing so, there may be more than one ball in some boxes.

Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to
the ith box.

Each answer[i] is calculated considering the initial state of the boxes.



Example 1:

Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball
from the second box to the third box in one operation.
Example 2:

Input: boxes = "001011"
Output: [11,8,5,4,3,4]


Constraints:

n == boxes.length
1 <= n <= 2000
boxes[i] is either '0' or '1'.
 */
public class MinimumNumberOfOperationToMoveAllBallsToEachBox {
    /**
     * Approach 1 : Prefix Sum - using two arrays, calculate shifting cost from left to right and right to left and
     *              then add each index to get shifting cost for each box;
     * Complexity Analysis :
     *      Time Complexity : O(n)
     *      Space Complexity : O(2 * n) = O(n)
     */
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] leftTraversal = new int[len];
        int[] rightTraversal = new int[len];
        int numberOfBalls = (boxes.charAt(0) == '1') ? 1 : 0;
        for(int a = 1; a < len ; a++){
            leftTraversal[a] = leftTraversal[a-1] + numberOfBalls;
            if(boxes.charAt(a) == '1'){
                numberOfBalls++;
            }
        }
        numberOfBalls = (boxes.charAt(len-1) == '1') ? 1 : 0;
        for(int a = len-2; a >= 0 ; a--){
            rightTraversal[a] = rightTraversal[a+1] + numberOfBalls;
            if(boxes.charAt(a) == '1'){
                numberOfBalls++;
            }
        }
        for(int a = 0 ; a < len ; a++){
            leftTraversal[a] = leftTraversal[a] + rightTraversal[a];
        }
        return leftTraversal;
    }
}
