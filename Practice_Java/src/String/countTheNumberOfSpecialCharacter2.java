package String;
/*
You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

There are no special characters in word.

Example 3:

Input: word = "AbBCab"

Output: 0

Explanation:

There are no special characters in word.

 

Constraints:

1 <= word.length <= 2 * 105
word consists of only lowercase and uppercase English letters.
*/
public class countTheNumberOfSpecialCharacter2 {
    /*
    Boolean array solution, Best for space complexity, but a bit more complex to implement and understand.:
    public int numberOfSpecialChars(String word) {
        boolean[] markLower = new boolean[26];
        boolean[] markUpper = new boolean[26];
        boolean[] result = new boolean[26];
        int special = 0;
        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z'){
                if(!markLower[ch - 'a'] && !markUpper[ch - 'a']){
                    markLower[ch - 'a'] = true;
                }else if(markLower[ch - 'a'] && markUpper[ch - 'a']){
                    result[ch - 'a'] = false;
                }
            }else if(ch >= 'A' && ch <= 'Z'){
                if(markLower[ch - 'A'] && !markUpper[ch - 'A']){
                    result[ch - 'A'] = true;
                }
                markUpper[ch - 'A'] = true;
            }
        }
        for(boolean a : result){
            if(a){
                special++;
            }
        }
        return special;
    }

    // Solution 2: State machine solution, Best for time complexity, but uses more space and is a bit more complex to implement and understand.:
    public int numberOfSpecialChars(String word) {
        // 0=unseen, 1=lowercase only, 2=special, 3=invalid, 4=uppercase only (no lowercase yet)
        int[] state = new int[26];
        int special = 0;
        for (char ch : word.toCharArray()) {
            int idx = Character.toLowerCase(ch) - 'a';
            if (ch >= 'a' && ch <= 'z') {
                if      (state[idx] == 0) state[idx] = 1;
                else if (state[idx] == 2) { special--; state[idx] = 3; } // lowercase after uppercase → invalidate
                else if (state[idx] == 4) state[idx] = 3;                // lowercase after first-seen uppercase → invalid
            } else {
                if      (state[idx] == 0) state[idx] = 4;                // uppercase seen first, no lowercase yet
                else if (state[idx] == 1) { special++; state[idx] = 2; } // all lowercase were before this uppercase
            }
        }
        return special;
    }
        
    */
    public int numberOfSpecialChars(String word) {
        boolean[] hasLower = new boolean[26];
        boolean[] hasUpper = new boolean[26];

        for (char ch : word.toCharArray()) {
            if (ch >= 'a' && ch <= 'z'){
                hasLower[ch - 'a'] = !hasUpper[ch - 'a'];
            }else{
                hasUpper[ch - 'A'] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++){
            if (hasLower[i] && hasUpper[i]){
                count++;
            }
        }
        return count;
    }
}
