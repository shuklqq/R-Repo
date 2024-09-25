package Interview;

import java.util.HashSet;

/*

Given a string s, how many distinct substring of s are palindrome?
Write  the most efficient java code for the above problem.

Constraints: 1<= s<= 5000, each character is lowercases a-z

 */
public class NumberOfDistinctSubarrays {
    public static int palindrome(String s) {
        int n = s.length();
        HashSet<String> palindromes = new HashSet<>();

        // Create a DP table to store whether a substring is a palindrome
        boolean[][] dp = new boolean[n][n];

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            palindromes.add(s.substring(i, i + 1));  // Add single-character palindromes
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                palindromes.add(s.substring(i, i + 2));  // Add two-character palindromes
            }
        }

        // Check for palindromes of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;

                // If the characters at the two ends are the same and the substring between them is a palindrome
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    palindromes.add(s.substring(i, j + 1));  // Add this palindrome
                }
            }
        }

        // Return the size of the HashSet which contains distinct palindromic substrings
        return palindromes.size();
    }

    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(palindrome(s));  // Output: 5
    }
}
