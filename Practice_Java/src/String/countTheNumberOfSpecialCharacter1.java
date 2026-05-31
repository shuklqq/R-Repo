package String;
/*
You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.

 

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters in word are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

No character in word appears in uppercase.

Example 3:

Input: word = "abBCab"

Output: 1

Explanation:

The only special character in word is 'b'.

 

Constraints:

1 <= word.length <= 50
word consists of only lowercase and uppercase English letters.
*/
public class countTheNumberOfSpecialCharacter1 {
    public int numberOfSpecialChars(String word) {
        boolean[] memory = new boolean[26];
        boolean[] memory2 = new boolean[26];
        int result  = 0;
        for(char ch : word.toCharArray()){
            if(ch >= 'a' && ch <= 'z') memory[ch - 'a'] = true;
            else memory2[ch - 'A'] = true;
        }
        for(int a = 0 ; a < 26 ; a++){
            if(memory[a] && memory2[a]) result++;
        }
        return result;
    }
}
