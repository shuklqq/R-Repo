package InterviewPrep.Implementation.Hashtable;

import java.util.ArrayList;
import java.util.List;

/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

1 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].

Topics
Hash Table
String
Backtracking

*/
public class LetterCombinationsofaPhoneNumber {
   /*
    // Used Recursion to create final strings
    // Complexity - O(4^n . n);

    // Index is the digit itself; 0 and 1 have no letters.
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> finalString = new ArrayList<>();
        dfs(finalString, "", digits);
        return finalString;
    }
    public void dfs (List<String> finaString, String currentWord, String remainingDigits){
        if(remainingDigits.isEmpty()){
            finaString.add(currentWord);
            return;
        }
        String str = LETTERS[remainingDigits.charAt(0) - '0'];
        for(char ch : str.toCharArray()){
            dfs(finaString, currentWord+ch, remainingDigits.substring(1));
        }
    }*/

    // Used Backtracking - one shared StringBuilder: add a letter, go deeper, take it back.
    // Complexity - O(4^n . n);

    // Index is the digit itself; 0 and 1 have no letters.
    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits){
        List<String> finalString = new ArrayList<>();
        backtrack(finalString, new StringBuilder(), digits, 0);
        return finalString;
    }

    private void backtrack(List<String> finalString, StringBuilder currentWord, String digits, int index){
        if(index == digits.length()){
            // Snapshot: the builder keeps changing after this, the String does not.
            finalString.add(currentWord.toString());
            return;
        }
        String str = LETTERS[digits.charAt(index) - '0'];
        for(char ch : str.toCharArray()){
            currentWord.append(ch);                                 // do
            backtrack(finalString, currentWord, digits, index + 1); // explore
            currentWord.deleteCharAt(currentWord.length() - 1);     // undo
        }
    }

}
