package Math;

/*

You are given a 0-indexed integer array nums of length n.

You can perform the following operation as many times as you want:

Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
Return true if you can make nums a strictly increasing array using the above operation and false otherwise.

A strictly increasing array is an array whose each element is strictly greater than its preceding element.



Example 1:

Input: nums = [4,9,6,10]
Output: true
Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract 3 from nums[0], so that nums becomes [1,9,6,10].
In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums becomes equal to [1,2,6,10].
After the second operation, nums is sorted in strictly increasing order, so the answer is true.
Example 2:

Input: nums = [6,8,11,12]
Output: true
Explanation: Initially nums is sorted in strictly increasing order, so we don't need to make any operations.
Example 3:

Input: nums = [5,8,3]
Output: false
Explanation: It can be proven that there is no way to perform operations to make nums sorted in strictly increasing order, so the answer is false.


Constraints:

1 <= nums.length <= 1000
1 <= nums[i] <= 1000
nums.length == n

 */
public class PrimeSubtractionOperation {
    /*
    Approach 1 : Storing the primes :
    Complexity Analysis :
        Time Complexity: O(n + m*sqrt(m))
        Space Complexity : O(m)
     */
    /*
    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }
        int[] previousPrime = new int[maxElement + 1];
        for (int i = 2; i <= maxElement; i++) {
            if (isPrime(i)) {
                previousPrime[i] = i;
            } else {
                previousPrime[i] = previousPrime[i - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int bound;
            if (i == 0) {
                bound = nums[0];
            } else {
                bound = nums[i] - nums[i - 1];
            }
            if (bound <= 0) {
                return false;
            }
            int largestPrime = previousPrime[bound - 1];
            nums[i] -= largestPrime;
        }
        return true;
    }

     */
    /*
    Approach 2 : Sieve of Eratosthenes + Two Pointers
    Complexity Analysis :
        Time Complexity : O(n + m*log(logn))
        Space Complexity : O(k) - K is the maximum element in the array nums.
     */
    public boolean primeSubOperation(int[] nums) {
        int maxElement = 0, len = nums.length;
        for(int num : nums){
            if(maxElement < num){
                maxElement = num;
            }
        }

        boolean[] compositeArray = new boolean[maxElement + 1];
        compositeArray[0] = compositeArray[1] = true;
        for(int a = 2 ; a <= Math.sqrt(maxElement+1);  a++){
            if(!compositeArray[a]){
                for(int b = a * a; b <= maxElement ; b += a ){
                    compositeArray[b] = true;
                }
            }
        }

        int currValue = 1, i = 0;
        while( i < len){
            int diff  = nums[i] - currValue;

            if(diff < 0){
                return false;
            }
            if(!compositeArray[diff] || diff == 0){
                i++;
                currValue++;
            }else{
                currValue++;
            }
        }
        return true;
    }
}
