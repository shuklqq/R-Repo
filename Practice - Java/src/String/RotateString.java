package String;
/*

Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.


Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true
Example 2:

Input: s = "abcde", goal = "abced"
Output: false


Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.

 */
public class RotateString {
    /*
    Approach 1 : Use substring concatenation and check if the goal substring concatenation is equals to string s.
    Complexity Analysis :
        Time Complexity : O(1)
        Space Complexity : O(1)
     */
    /*
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        int a = goal.indexOf(s.charAt(0),0);
        int gLength = goal.length();
        while( a != -1){
            if((goal.substring(a, gLength) + goal.substring(0, a)).equals(s)){
                return true;
            }
            a = goal.indexOf(s.charAt(0), a+1);
        }
        return false;
    }*/
    /*
    Approach 2 : Use concatenation to create a 2x string and check if that string contains goal.
    Complexity Analysis :
        Time Complexity : O(1)
        Space Complexity : O(1)
     */
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String str = s + s;
        return str.contains(goal);
    }
}
