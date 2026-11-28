package InterviewPrep.Implementation.ArraysAndHashing.HashMapLookups;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/*

You are given a string s. Find the first letter of s that appears in it exactly once, and return its index. If every letter of s appears two or more times, return -1.

"First" means the smallest index in s, reading from left to right. Indexes start at 0.

Example 1
Input: s = "statistics"

Output: 2
Explanation: s and t appear three times each and i twice. Only a and c appear once, and a comes first, at index 2.

Example 2
Input: s = "aabbcc"

Output: -1
Example 3
Input: s = "racecar"

Output: 3
Explanation: r, a and c each appear twice. The only letter that appears once is the e in the middle, at index 3.

Constraints
1 ≤ s.length ≤ 105
s holds lowercase English letters only.

Topics
String
Hash Map
Counting

*/
public class FirstUniqueCharacterinaString {
    /*
    This is feasible when the string size is low, but of n is high, here complexity is O(2*n)
    */
    /*
     public int firstUniqChar(String s) {
        int[] memory = new int[26];
        for(char ch : s.toCharArray()){
            memory[ch - 'a']++;
        }
        for(int a = 0 ; a < s.length(); a++){
            char ch = s.charAt(a);
            if(memory[ch - 'a'] == 1){
                return a; 
            }
        }
        return -1;
    } */

    /*
    Another approach is to remember the first index of the charachter in the string and use that for lookup.
    this way, complexity becaoms, O(n + 26);
    */
    public int firstUniqChar(String s) {
        int len = s.length();
        int[] memory = new int[26];
        int[] indexMemory = new int[26];
        for(int a = 0 ; a < len ; a++){
            char ch = s.charAt(a);
            int index = ch - 'a';
            if(memory[index] == 0){
                indexMemory[index] = a;
            }
            memory[ch - 'a']++;
        }
        for(int a = 0 ; a < len; a++){
            char ch = s.charAt(a);
            int index = ch - 'a';
            if(memory[index] == 1){
                return indexMemory[index]; 
            }
        }
        return -1;
    }
}
