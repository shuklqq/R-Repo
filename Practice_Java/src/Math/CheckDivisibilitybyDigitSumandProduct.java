package Math;
/*
You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:
The digit sum of n (the sum of its digits).The digit product of n (the product of its digits).Return true if n is divisible by this sum; otherwise, return false.

Example 1:
Input: n = 99
Output: true
Explanation: Since 99 is divisible by the sum (9 + 9 = 18) plus product (9 * 9 = 81) of its digits (total 99), the output is true.

Example 2:
Input: n = 23
Output: false
Explanation: Since 23 is not divisible by the sum (2 + 3 = 5) plus product (2 * 3 = 6) of its digits (total 11), the output is false.

Constraints:
1 <= n <= 106
*/
public class CheckDivisibilitybyDigitSumandProduct {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1, num = n, digit=0;
        while(num != 0){
            digit = num%10;
            num /= 10;
            sum += digit;
            product *= digit;
        }
        if((n%(sum + product)) == 0) return true;
        return false;
    }
    /*
    * Via Bit Manipulation
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1, num = n;
        while(num != 0){
            int q = (int) ((num * 0xCCCCCCCDL) >>> 35);
            int digit = num - ((q << 3) + (q << 1));
            sum += digit;
            product *= digit;
            num = q;
        }
        return n % (sum + product) == 0;
    }
    */
}
