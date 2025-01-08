package DynamicProgramming;
/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
 */
public class longestPalindromicSubstring {
    /**
     * Approach 1 : Dynamic Programming
     * Complexity Analysis :
     *      Time Complexity : O(n^2)
     *      Space Complexity : O(n^2)
     */
    /*
    public String longestPalindrome(String s) {
        int len = s.length();
        int[] ans = new int[]{0 , 0};
        boolean[][] dp = new boolean[len][len];

        for(int a = 0 ; a < len ; a++){
            dp[a][a] = true;
            ans[0] = a;
            ans[1] = a;
        }
        for(int a = 0 ; a < len-1 ; a++){
            if(s.charAt(a) == s.charAt(a+1)){
                dp[a][a+1] = true;
                ans[0] = a;
                ans[1] = a + 1;
            }
        }
        for(int diff = 2 ; diff < len ; diff++){
            for(int a = 0 ; a < len-diff ; a++){
                int b = a + diff;
                if(s.charAt(a) == s.charAt(b) && dp[a][b-1]){
                    dp[a][b] = true;
                    ans[0] = a;
                    ans[1] = b;
                }
            }
        }
        int i = ans[0], j = ans[1];
        return s.substring(i , j+1);
    }

     */
    /**
     * Approach 2 : Expand from the center and check for even and odd length substrings if they are palindrome or not.
     * Complexity Analysis :
     *      Time Complexity : O(n^2)
     *      Space Complexity : O(1)
     */
    public String longestPalindrome(String s) {
        int[] ans = new int[]{0,0};

        for(int a = 0 ; a < s.length() ; a++){
            int oddLength = expand(a,a,s);
            if(oddLength > (ans[1] - ans[0] + 1)){
                int dist = oddLength/2;
                ans[0] = a - dist;
                ans[1] = a + dist;
            }

            int evenLength = expand(a, a+1, s);
            if(evenLength > (ans[1] - ans[0] + 1)){
                int dist = (evenLength/2) - 1;
                ans[0] = a - dist;
                ans[1] = a + dist + 1;
            }
        }
        int i = ans[0];
        int j = ans[1];

        return s.substring(i, j+1);
    }
    public int expand(int i , int j, String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i - 1;
    }
}
