package String;
/*

You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original
string where spaces will be added. Each space should be inserted before the character at the given index.

For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C', which are at
indices 5 and 9 respectively. Thus, we obtain "Enjoy Your Coffee".
Return the modified string after the spaces have been added.



Example 1:

Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
Output: "Leetcode Helps Me Learn"
Explanation:
The indices 8, 13, and 15 correspond to the underlined characters in "LeetcodeHelpsMeLearn".
We then place spaces before those characters.
Example 2:

Input: s = "icodeinpython", spaces = [1,5,7,9]
Output: "i code in py thon"
Explanation:
The indices 1, 5, 7, and 9 correspond to the underlined characters in "icodeinpython".
We then place spaces before those characters.
Example 3:

Input: s = "spacing", spaces = [0,1,2,3,4,5,6]
Output: " s p a c i n g"
Explanation:
We are also able to place spaces before the first character of the string.


Constraints:

1 <= s.length <= 3 * 105
s consists only of lowercase and uppercase English letters.
1 <= spaces.length <= 3 * 105
0 <= spaces[i] <= s.length - 1
All the values of spaces are strictly increasing.

 */
public class addingSpacesToAString {
    /*
    Approach 1 : using String builder.
    Complexity Analysis :
        Time Complexity : O(n + m)
        Space Complexity : O( n * m)
     */
    /*
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str = new StringBuilder();
        int spacesCount = spaces.length, counter = 0;
        for (int a = 0; a < s.length(); a++) {
            if ((counter < spacesCount)&&(a == spaces[counter])) {
                counter++;
                str.append(" ");
            }
            str.append(s.charAt(a));
        }
        return str.toString();
    }

     */
    /*
    Approach 2 : Using char array for storing the spaces and letters. This would be more efficient as we are aware of
                 the size of the final string as original string is given and number of spaces to be added is also given,
    Complexity Analysis :
        Time Complexity: O(s.length+spaces.length)
        Space Complexity: O(s.length+spaces.length)
     */
    public String addSpaces(String s, int[] spaces) {
        int spacesCount = spaces.length,
                stringLen = s.length(),
                stringCounter = 0,
                spacesCounter = 0,
                finalLength = spacesCount + stringLen;
        char[] finalString = new char[finalLength];
        for(int a = 0 ; a < finalLength ; a++){
            if((spacesCounter < spacesCount) && (stringCounter == spaces[spacesCounter])){
                finalString[a++] = ' ';
                spacesCounter++;
            }
            finalString[a] = s.charAt(stringCounter++);
        }
        return new String(finalString);
    }
}
