package BitManipulation;
/*
You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array,
nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is
paired with every integer in nums2 exactly once).

Return the bitwise XOR of all integers in nums3.

Example 1:
Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
Output: 13
Explanation:
A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
The bitwise XOR of all these numbers is 13, so we return 13.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 0
Explanation:
All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
and nums1[1] ^ nums2[1].
Thus, one possible nums3 array is [2,5,1,6].
2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.

Constraints:
1 <= nums1.length, nums2.length <= 105
0 <= nums1[i], nums2[j] <= 109
 */
public class BitWiseXOROfAllPairings {
    /**
     * Approach 1 : First lets calculate the number of integers present in num1 and num2 array. And then check if the
     * number of elements in both the array are odd or even.
     *          *Do the double XOR like mentioned in a notebook to understand that there can be 4 cases:*
     *      Case 1 : Both are even and resultant XOR will always be zero.
     *      Case 2 : nums1 is odd and nums2 is even, in that case XOR as per our use case will be equal to XOR of all
     *      the elements in num1 and all the elements in num2 will be cancelled by themselves, resulting in zero for
     *      num2 XOR.
     *      Case 3 : num2 is odd and nums1 is even, in that case, COR will come as XOR of all elements of num2.
     *      Case 4 : Both are odd, then resultant XOR will be equal to XOR of all elemnts of num1 and num2.
     * Above cases show that we only need to XOR all the elements of that array which have odd number of elements and
     * that would be resultant XOR.
     * Hence, check the odd condition for each input array and if they are odd, XOR all the elements into and answer
     * integer and then return the same.
     * Complexity Analysis :
     *      Time Complexity : O(n+m)
     *      Space Complexity : O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        if (nums2.length % 2 != 0) {
            for (int num : nums1) {
                ans ^= num;
            }
        }
        if (nums1.length % 2 != 0) {
            for (int num : nums2) {
                ans ^= num;
            }
        }
        return ans;
    }
}
