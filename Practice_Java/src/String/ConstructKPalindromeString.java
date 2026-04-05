package String;
/*
Given a string s and an integer k, return true if you can use all the characters in s to construct k palindrome strings
or false otherwise.

Example 1:
Input: s = "annabelle", k = 2
Output: true
Explanation: You can construct two palindromes using all characters in s.
Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"

Example 2:
Input: s = "leetcode", k = 3
Output: false
Explanation: It is impossible to construct 3 palindromes using all the characters of s.

Example 3:
Input: s = "true", k = 4
Output: true
Explanation: The only possible solution is to put each character in a separate string.

Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= 105
 */
public class ConstructKPalindromeString {
    /**
     * Approach 1 : Using the letter count and checking the number of characters which are in odd number count. Because
     * Complexity Analysis :
     *      Time Complexity : O(n)
     *      Space Complexity : O(1)
     */
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        int[] characterCount = new int[26];
        for(char ch : s.toCharArray()){
            characterCount[ch - 'a']++;
        }
        int oddCount = 0;
        for(int a = 0 ; a < 26 ; a++){
            if(characterCount[a] % 2 != 0){
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}
