package BitManipulation;
/*

You are given an array nums of non-negative integers and an integer k.

An array is called special if the bitwise OR of all of its elements is at least k.

Return the length of the shortest special non-empty
subarray
 of nums, or return -1 if no special subarray exists.



Example 1:

Input: nums = [1,2,3], k = 2

Output: 1

Explanation:

The subarray [3] has OR value of 3. Hence, we return 1.

Example 2:

Input: nums = [2,1,8], k = 10

Output: 3

Explanation:

The subarray [2,1,8] has OR value of 11. Hence, we return 3.

Example 3:

Input: nums = [1,2], k = 0

Output: 1

Explanation:

The subarray [1] has OR value of 1. Hence, we return 1.



Constraints:

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 109
0 <= k <= 109

 */
public class ShortestSubArrayWithORatLeastK2 {
    /*
    Approach 1 : Sliding Window: Since the data set is quite large, the bitwise or and XOR operation can be very heavy
                Hence, we will be counting bits in a bits array.
    Complexity Analysis :
        Time Complexity : O(n)
        Space Complexity : O(1)
     */
    /*
    public int minimumSubarrayLength(int[] nums, int k) {
        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        int[] bitCount = new int[32];

        while(end < nums.length){
            updateBit(bitCount, nums[end], 1);
            while((start <= end) && (getNumberFromBitCount(bitCount) >= k)){
                minLength = Math.min(minLength, (end - start + 1));
                updateBit(bitCount, nums[start], -1);
                start++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
    private int getNumberFromBitCount(int[] bitCount){
        int result = 0;
        for(int bitPosition = 0 ; bitPosition < 32 ; bitPosition++){
            if(bitCount[bitPosition] != 0){
                result |= (1 << bitPosition);
            }
        }
        return result;
    }
    private void updateBit(int[] bitCount, int number, int mark){
        for(int bitPosition = 0 ; bitPosition < 32 ; bitPosition++){
            if(((number >> bitPosition) & 1) != 0){
                bitCount[bitPosition] += mark;
            }
        }
    }

     */
    /*
    Approach 2 : The approach is same as previous one, but we will be using a track variable which will contain the
                 Or value of all the elements in between that window, this will reduce the number lookup we want for
                 check condition, and we would need to update the remove logic to get the new ORvalue when a number
                 is removed as the OR operation is irreversible.
    Complexity Analysis :
        Time Complexity : O(n)
        Space Complexity : O(1)
     */
    public int minimumSubarrayLength(int[] nums, int k) {
        int start = 0, end = 0, minLength = Integer.MAX_VALUE, ORValue = 0;
        int[] bitCount = new int[32];

        while (end < nums.length) {
            ORValue |= nums[end];
            addBit(bitCount, nums[end]);
            while ((start <= end) && (ORValue >= k)) {
                minLength = Math.min(minLength, (end - start + 1));
                ORValue = removeBit(bitCount, nums[start]);
                start++;
            }
            end++;
        }
        if(minLength == Integer.MAX_VALUE){
            return -1;
        }
        return minLength;
    }
    private void addBit(int[] bitCount, int number){
        int a = 0;
        while(number > 0){
            if((number & 1) != 0){
                bitCount[a]++;
            }
            a++;
            number >>= 1;
        }
    }
    private int removeBit(int[] bitCount, int number){
        int a = 0;
        while( number > 0 ){
            if((number & 1) != 0){
                bitCount[a]--;
            }
            a++;
            number >>= 1;
        }
        int ORValue = 0;
        for(a = 0 ; a < 32 ; a++){
            if(bitCount[a] != 0){
                ORValue += Math.pow(2, a);
            }
        }
        return ORValue;
    }
}
