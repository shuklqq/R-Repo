package String;

import java.util.Stack;

/*
A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following
conditions is true:

It is ().
It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
It can be written as (A), where A is a valid parentheses string.
You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only
of '0's and '1's. For each index i of locked,

If locked[i] is '1', you cannot change s[i].
But if locked[i] is '0', you can change s[i] to either '(' or ')'.
Return true if you can make s a valid parentheses string. Otherwise, return false.

Example 1:
Input: s = "))()))", locked = "010100"
Output: true
Explanation: locked[1] == '1' and locked[3] == '1', so we cannot change s[1] or s[3].
We change s[0] and s[4] to '(' while leaving s[2] and s[5] unchanged to make s valid.

Example 2:
Input: s = "()()", locked = "0000"
Output: true
Explanation: We do not need to make any changes because s is already valid.

Example 3:
Input: s = ")", locked = "0"
Output: false
Explanation: locked permits us to change s[0].
Changing s[0] to either '(' or ')' will not make s valid.

Constraints:
n == s.length == locked.length
1 <= n <= 105
s[i] is either '(' or ')'.
locked[i] is either '0' or '1'.
 */
public class CheckIfAParenthesesStringCanBeValid {
    /**
     * Approach 1 : Using Stack for storing adn checking the parenthesis.
     * Complexity Analysis:
     *      Time Complexity : O(n)
     *      Space Complexity : O(n)
     */
    /*
    public boolean canBeValid(String s, String locked) {
        int length = s.length();

        // If length of string is odd, return false.
        if (length % 2 == 1) {
            return false;
        }

        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();

        // Iterate through the string to handle '(' and ')'
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked.push(i);
            } else if (s.charAt(i) == '(') {
                openBrackets.push(i);
            } else if (s.charAt(i) == ')') {
                if (!openBrackets.empty()) {
                    openBrackets.pop();
                } else if (!unlocked.empty()) {
                    unlocked.pop();
                } else {
                    return false;
                }
            }
        }

        // Match remaining open brackets with unlocked characters
        while (
                !openBrackets.empty() &&
                        !unlocked.empty() &&
                        openBrackets.peek() < unlocked.peek()
        ) {
            openBrackets.pop();
            unlocked.pop();
        }

        if (!openBrackets.empty()) {
            return false;
        }

        return true;
    }

     */
    /**
     * Approach 2 : Using Counting to count the open brackets and close brackets considering the changeable and
     *              non-changeable brackets.
     * Complexity Analysis :
     *      Time Complexity : O(n)
     *      Space Complexity : O(1)
     */
    /*
    public boolean canBeValid(String s, String locked) {
        int length = s.length();

        // If length of string is odd, return false.
        if (length % 2 == 1) {
            return false;
        }
        int openBrackets = 0;
        int unlocked = 0;

        // Iterate through the string to handle '(' and ')'.
        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '0') {
                unlocked++;
            } else if (s.charAt(i) == '(') {
                openBrackets++;
            } else if (s.charAt(i) == ')') {
                if (openBrackets > 0) {
                    openBrackets--;
                } else if (unlocked > 0) {
                    unlocked--;
                } else {
                    return false;
                }
            }
        }

        // Match remaining open brackets with unlocked characters.
        int balance = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                balance--;
                unlocked--;
            } else if (s.charAt(i) == '(') {
                balance++;
                openBrackets--;
            } else if (s.charAt(i) == ')') {
                balance--;
            }
            if (balance > 0) {
                return false;
            }
            if (unlocked == 0 && openBrackets == 0) {
                break;
            }
        }

        if (openBrackets > 0) {
            return false;
        }

        return true;
    }

     */
    /**
     * Approach 3 : Using the above approach but reducing the count of iteration from 2 * n to n, by traversing half at a time.
     * Complexity Analysis :
     *      Time Complexity : O(n)
     *      Space Complexity : O(1)
     */
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 != 0){
            return false;
        }
        if(s.equals("((")){
            return true;
        }
        int len1 = s.length()/2, len2 = s.length();
        int count11 = 0 , count10 = 0, count21 = 0, count20 = 0;
        for (int a = 0; a < len1; a++) {
            if (locked.charAt(a) == '0') {
                count10++;
            } else {
                if(s.charAt(a) == ')'){
                    if(count10 == 0 && count11 == 0){
                        return false;
                    }else{
                        if(count11 != 0){
                            count11--;
                        }else{
                            count10--;
                        }
                    }
                }else{
                    count11++;
                }
            }
        }
        for (int a = len2-1; a >= len1; a--) {
            if (locked.charAt(a) == '0') {
                count20++;
            } else {
                if(s.charAt(a) == '('){
                    if(count20 == 0 && count21 == 0){
                        return false;
                    }else{
                        if(count21 != 0){
                            count21--;
                        }else{
                            count20--;
                        }
                    }
                }else{
                    count21++;
                }
            }
        }

        while(count21 != 0){
            if(count11 != 0){
                count11--;
            }else if(count20 != 0){
                count20--;
            }else{
                return false;
            }
            count21--;
        }
        while(count11 != 0){
            if(count10 != 0){
                count10--;
            }else{
                return false;
            }
            count11--;
        }

        return (((count10 + count20) % 2 == 0));
    }
}
