package StringAndArray2;

import java.util.Arrays;
import java.util.HashSet;

/*
Given a string s, return the number of unique palindromes of length three that are a subsequence of s.

Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.

A palindrome is a string that reads the same forwards and backwards.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted
without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".


Example 1:

Input: s = "aabca"
Output: 3
Explanation: The 3 palindromic subsequences of length 3 are:
- "aba" (subsequence of "aabca")
- "aaa" (subsequence of "aabca")
- "aca" (subsequence of "aabca")
Example 2:

Input: s = "adc"
Output: 0
Explanation: There are no palindromic subsequences of length 3 in "adc".
Example 3:

Input: s = "bbcbaba"
Output: 4
Explanation: The 4 palindromic subsequences of length 3 are:
- "bbb" (subsequence of "bbcbaba")
- "bcb" (subsequence of "bbcbaba")
- "bab" (subsequence of "bbcbaba")
- "aba" (subsequence of "bbcbaba")


Constraints:

3 <= s.length <= 105
s consists of only lowercase English letters.
 */
public class UniqueLengthThreePalindromicSubsequences {
    /**
     * Approach 1 : Counting the indices of unique characters, start and end. and checking the count of unique character
     *              between them.
     * Complexity Analysis :
     *      Time Complexity : O(n)
     *      Space Complexity : O(1)
     */
    /*
    public int countPalindromicSubsequence(String s) {
        int[][] indices = new int[26][2];
        for(int a = 0 ; a < 26 ; a++){
            indices[a][0] = -1;
        }

        for(int a = 0 ; a < s.length() ; a++){
            char ch = s.charAt(a);
            int index = ch - 'a';
            if(indices[index][0] == -1){
                indices[index][0] = a;
                indices[index][1] = a;
            }else{
                indices[index][1] = a;
            }
        }
        int ans = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(indices[i][0] == -1) continue;

            HashSet<Character> temp = new HashSet<>();
            for(int j = indices[i][0]+1 ; j < indices[i][1] ; j++){
                temp.add(s.charAt(j));
            }
            ans += temp.size();
        }
        return ans;
    }

     */
    /**
     * Approach 2 : Same approach as above but using boolean array rather than hashset for finding the unique element in
     *              between two indices reducing the space and time complexity as the number of characters are small english
     *              alphabets with are limited in count.
     * Complexity Analysis :
     *      Time Complexity : O(n)
     *      Space Complexity : O(1)
     */
    public int countPalindromicSubsequence(String s) {
        int[] leftIndice = new int[26];
        int[] rightIndice = new int[26];
        Arrays.fill(leftIndice, -1);

        for (int a = 0; a < s.length(); a++) {
            char ch = s.charAt(a);
            int index = ch - 'a';
            if (leftIndice[index] == -1) {
                leftIndice[index] = a;
                rightIndice[index] = a;
            } else {
                rightIndice[index] = a;
            }
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (leftIndice[i] == -1)
                continue;
            boolean[] counts = new boolean[26];
            for (int j = leftIndice[i] + 1; j < rightIndice[i]; j++) {
                int k = s.charAt(j) - 'a';
                if (!counts[k]) {
                    ans++;
                    counts[k] = true;
                }
            }
        }
        return ans;
    }
}
