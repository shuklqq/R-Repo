/*

Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

 */

package HashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharachters {
    public int lengthOfLongestSubstring(String s) {

/*
Approach 1 -
 */
//        Queue<Character> res = new LinkedList<>();
//        int max = 0;
//        System.out.print(s.length());
//        for(int a = 0 ;a < s.length(); a++){
//            if(res.contains(s.charAt(a))){
//                while(res.contains(s.charAt(a))){
//                    res.poll();
//                }
//            }
//            res.add(s.charAt(a));
//            if(res.size() > max){
//                max = res.size();
//            }
//        }
//        return max;

/*
Approach 2 -
 */

        if (s.length() == 0) {
            return 0;
        }
        int a = 0;
        int b = 0;
        int max = 0;
        Integer[] chars = new Integer[128];
        while (b < s.length()) {
            char ch = s.charAt(b);
            Integer index = chars[ch];
            if (index != null && index < b && index >= a) {
                a = index + 1;
            }
            max = Math.max(max, b - a + 1);
            chars[ch] = b;
            b++;
        }
        return max;
    }
}
