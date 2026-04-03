package Recursion;
/*

You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.



Example 1:

Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

Example 2:

Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.


Constraints:

1 <= s.length <= 50
1 <= dictionary.length <= 50
1 <= dictionary[i].length <= 50
dictionary[i] and s consists of only lowercase English letters
dictionary contains distinct words

 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Trie{
    private Map<Character, Trie> links;
    private boolean IsEnd = false;
    public Trie(){links = new HashMap<>();}
    public Trie getLink(Character ch){return links.get(ch);}
    public void setLink(Character ch, Trie node){links.put(ch, node);}
    public boolean containsLink(Character ch){return links.containsKey(ch);}
    public void setIsEnd(boolean value){IsEnd = value;}
    public boolean getIsEnd(){return IsEnd;}
}
public class ExtraCharacterInAString {
    /*
        Approach 1 : Dynamic programming with memorization
        Integer[] memo;
        HashSet<String> dictionarySet;

        public int minExtraChar(String s, String[] dictionary) {
            int n = s.length();
            memo = new Integer[n];
            dictionarySet = new HashSet<>(Arrays.asList(dictionary));
            return dp(0, n, s);
        }

        private int dp(int start, int n, String s) {
            if (start == n) {
                return 0;
            }
            if (memo[start] != null) {
                return memo[start];
            }
            // To count this character as a left over character
            // move to index 'start + 1'
            int ans = dp(start + 1, n, s) + 1;
            for (int end = start; end < n; end++) {
                var curr = s.substring(start, end + 1);
                if (dictionarySet.contains(curr)) {
                    ans = Math.min(ans, dp(end + 1, n, s));
                }
            }

            return memo[start] = ans;
        }

     */

    //Approach 2 : Reverse Dynamic programing with substring function.
    /*
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] arr = new int[n + 1];
        var dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        for (int start = n - 1; start >= 0; start--) {
            arr[start] = arr[start + 1] + 1;
            for (int end = start; end < n; end++) {
                if (dictionarySet.contains(s.substring(start, end + 1))) {
                    arr[start] = Math.min(arr[start], arr[end + 1]);
                }
            }
        }
        return arr[0];
    }

     */
    //Approach 3 : reverse Dynamic programming with trie.

    private Trie root = new Trie();
    private int[] dp;
    public void setTrie(String s){
        Trie temp = root;
        for(char ch : s.toCharArray()){
            if(!temp.containsLink(ch)){
                temp.setLink(ch, new Trie());
            }
            temp = temp.getLink(ch);
        }
        temp.setIsEnd(true);
    }
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        dp = new int[n + 1];
        for(int a = 0 ; a < dictionary.length ; a++){
            setTrie(dictionary[a]);
        }
        for(int a = n - 1 ; a >= 0 ;a--){
            dp[a] = dp[a+1] + 1;
            Trie temp = root;
            for(int b = a ; b < n ; b++){
                char ch = s.charAt(b);
                if(!temp.containsLink(ch)){
                    break;
                }
                temp = temp.getLink(ch);
                if(temp.getIsEnd()){
                    dp[a] = Math.min(dp[a], dp[b+1]);
                }
            }
        }
        return dp[0];
    }
    

    public static void main(String[] args) {
        ExtraCharacterInAString e = new ExtraCharacterInAString();
        String[] str = {"leet", "code", "leetcode"};
        System.out.println(e.minExtraChar("leetscode", str));
    }
}

