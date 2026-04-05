package StringAndArray2;

import java.util.Set;

/*
You are given a 0-indexed array of strings words and a 2D array of integers queries.

Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive)
of words that start and end with a vowel.

Return an array ans of size queries.length, where ans[i] is the answer to the ith query.

Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
Output: [2,3,0]
Explanation: The strings starting and ending with a vowel are "aba", "ece", "aa" and "e".
The answer to the query [0,2] is 2 (strings "aba" and "ece").
to query [1,4] is 3 (strings "ece", "aa", "e").
to query [1,1] is 0.
We return [2,3,0].
Example 2:

Input: words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
Output: [3,2,1]
Explanation: Every string satisfies the conditions, so we return [3,2,1].


Constraints:

1 <= words.length <= 105
1 <= words[i].length <= 40
words[i] consists only of lowercase English letters.
sum(words[i].length) <= 3 * 105
1 <= queries.length <= 105
0 <= li <= ri < words.length
 */
public class CountVowelStringsInRange {
    /**
     * Approach 1 : Prefix Sum
     * Complexity Analysis :
     *      Time Complexity : O(M + N)
     *      Space Complexity : O(M)
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] count = new int[n + 1];
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int sum = 0;
        for (int a = 0 ; a < n ; a++) {
            String word = words[a];
            if(vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))){
                sum++;
            }
            count[a+1] = sum;
        }
        int len = queries.length;
        int[] ans = new int[len];
        for (int a = 0; a < len; a++) {
            int x = queries[a][0];
            int y = queries[a][1];
            ans[a] = count[y + 1] - count[x];
        }
        return ans;
    }
}
