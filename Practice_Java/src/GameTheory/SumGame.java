package GameTheory;
/*
Alice and Bob take turns playing a game, with Alice starting first.
You are given a string num of even length consisting of digits and '?' characters. On each turn, a player will do the following if there is still at least one '?' in num:
Choose an index i where num[i] == '?'. Replace num[i] with any digit between '0' and '9'. The game ends when there are no more '?' characters in num.

For Bob to win, the sum of the digits in the first half of num must be equal to the sum of the digits in the second half. For Alice to win, the sums must not be equal.
For example, if the game ended with num = "243801", then Bob wins because 2+4+3 = 8+0+1. If the game ended with num = "243803", then Alice wins because 2+4+3 != 8+0+3.
Assuming Alice and Bob play optimally, return true if Alice will win and false if Bob will win.

Example 1:
Input: num = "5023"
Output: false
Explanation: There are no moves to be made.
The sum of the first half is equal to the sum of the second half: 5 + 0 = 2 + 3.

Example 2:
Input: num = "25??"
Output: true
Explanation: Alice can replace one of the '?'s with '9' and it will be impossible for Bob to make the sums equal.

Example 3:
Input: num = "?3295???"
Output: false
Explanation: It can be proven that Bob will always win. One possible outcome is:
- Alice replaces the first '?' with '9'. num = "93295???".
- Bob replaces one of the '?' in the right half with '9'. num = "932959??".
- Alice replaces one of the '?' in the right half with '2'. num = "9329592?".
- Bob replaces the last '?' in the right half with '7'. num = "93295927".
Bob wins because 9 + 3 + 2 + 9 = 5 + 9 + 2 + 7.
 
Constraints:
2 <= num.length <= 105
num.length is even.
num consists of only digits and '?'.

*/
public class SumGame {
// Most optimal solution is to calculate the difference between the sum of the digits in the left half and the right half, as well as the difference in the number of '?' characters in each half. If the total number of '?' characters is odd, Alice wins. If it is even, we check if the difference in sums can be balanced by replacing '?' with appropriate digits. If it cannot be balanced, Alice wins; otherwise, Bob wins.
    public boolean sumGame(String num) {
        char[] a = num.toCharArray();
        int n = a.length, diff = 0, k = 0;
        for (int i = 0; i < n / 2; i++) {
            if (a[i] == '?')
                k--;
            else
                diff += a[i] - '0';
        }
        for (int i = n / 2; i < n; i++) {
            if (a[i] == '?')
                k++;
            else
                diff -= a[i] - '0';
        }
        return 2 * diff != 9 * k;
    }
    /*
    Solution :
    1. Count the number of '?' characters in the left and right halves of the string
    2. Calculate the sum of the digits in the left and right halves of the string
    3. If the total number of '?' characters is odd, Alice wins
    4. If the total number of '?' characters is even, check if the difference between
    public boolean sumGame(String num) {
        int n = num.length();
        int[] left = get(num.substring(0, n / 2));
        int[] right = get(num.substring(n / 2, n));

        int n0 = left[0], q0 = left[1];
        int n1 = right[0], q1 = right[1];

        return (q0 + q1) % 2 == 1 || n0 - n1 != ((q1 - q0) * 9) / 2;
    }

    private int[] get(String s) {
        int nn = 0, qq = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '?') {
                qq++;
            } else {
                nn += ch - '0';
            }
        }
        return new int[] { nn, qq };
    }*/
    /*
    Solution : 
    public boolean sumGame(String num) {
        int n = num.length();
        int diff = 0;   // (left digit sum) - (right digit sum)
        int k = 0;      // (right '?' count) - (left '?' count)
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            int sign = (i < n / 2) ? 1 : -1;
            if (c == '?') k -= sign;          // left '?' -> k-1, right '?' -> k+1
            else          diff += sign * (c - '0');
        }
        return 2 * diff != 9 * k;             // Alice wins iff this holds
    }
    */
    /*
    Solution: The key to solving this problem is to realize that the game can be reduced to a simple mathematical condition based on the sums of the digits and the number of '?' characters in each half of the string.
    public boolean sumGame(String num) {
        int len = num.length();
        int leftSum = 0, rightSum = 0;
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < len / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                leftCount++;
            } else {
                leftSum += c - '0';
            }
        }
        for (int i = len / 2; i < len; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                rightCount++;
            } else {
                rightSum += c - '0';
            }
        }
        if(((leftCount + rightCount) % 2) != 0){
            return true;
        }else{
            int diff = leftSum - rightSum;
            int countDiff = rightCount - leftCount;
            if(countDiff == 0){
                return diff != 0;
            }else{
                int maxDiff = (countDiff / 2) * 9;
                return diff != maxDiff;
            }
        }
    }        
    */
}
