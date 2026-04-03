package BitManipulation;
/*

You are given two integers n and x. You have to construct an array of positive integers nums of size n where for every
0 <= i < n - 1, nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation between all elements
of nums is x.

Return the minimum possible value of nums[n - 1].



Example 1:

Input: n = 3, x = 4

Output: 6

Explanation:

nums can be [4,5,6] and its last element is 6.

Example 2:

Input: n = 2, x = 7

Output: 15

Explanation:

nums can be [7,15] and its last element is 15.



Constraints:

1 <= n, x <= 108

 */
public class MinimumArrayEnd {
    /*
    Approach 1 : Consecutive ORing
    Complexity Analysis :
        Time Complexity : O(n)
        Space Complexity : O(1)
     */
    /*
        public long minEnd(int n, int x) {
        long result = x;
        while(--n > 0){
            result = (result + 1) | x;
        }
        return result;
    }
     */
    /*
    Approach 2 : Bit Manipulation and Binary Construction
    Complexity Analysis :
        Time Complexity : O(logn)
        Space Complexity : O(logn)
     */
    /*
    public long minEnd(int n, int x) {
        long result = 0, bit;
        --n;

        int[] binaryX = new int[64] , binaryN = new int[64];
        long longX = x , longN = n;

        for(int a = 0 ; a < 64 ; a++){
            bit = (longX >> a) & 1;
            binaryX[a] = (int) bit;

            bit = (longN >> a) & 1;
            binaryN[a] = (int) bit;
        }

        int posX = 0 , posN = 0;

        while(posX < 64){
            while(binaryX[posX] != 0 && posX < 64){
                ++posX;
            }
            binaryX[posX] = binaryN[posN];
            ++posN;
            ++posX;
        }

        for(int a = 0 ; a < 64 ; a++){
            if(binaryX[a] == 1){
                result += Math.pow(2,a);
            }
        }
        return result;
    }
     */
    /*
    Approach 3 : BitMasking with Logical Operations
    Complexity Analysis :
        Time Complexity : O(logn)
        Space Complexity : O(1)
     */
    public long minEnd(int n, int x) {
        long result = x, mask;
        --n;

        for(mask = 1 ; n > 0 ; mask <<= 1){
            if((mask & x) == 0){
                result |= (n & 1) * mask;
                n >>= 1;
            }
        }
        return result;
    }
}
