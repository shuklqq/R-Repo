package String;

import java.util.Arrays;

/*
You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of
s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.

Return the lexicographically largest repeatLimitedString possible.

A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a
letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length)
characters do not differ, then the longer string is the lexicographically larger one.

Example 1:

Input: s = "cczazcc", repeatLimit = 3
Output: "zzcccac"
Explanation: We use all the characters from s to construct the repeatLimitedString "zzcccac".
The letter 'a' appears at most 1 time in a row.
The letter 'c' appears at most 3 times in a row.
The letter 'z' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "zzcccac".
Note that the string "zzcccca" is lexicographically larger but the letter 'c' appears more than 3 times in a row, so
it is not a valid repeatLimitedString.

Example 2:

Input: s = "aababab", repeatLimit = 2
Output: "bbabaa"
Explanation: We use only some of the characters from s to construct the repeatLimitedString "bbabaa".
The letter 'a' appears at most 2 times in a row.
The letter 'b' appears at most 2 times in a row.
Hence, no letter appears more than repeatLimit times in a row and the string is a valid repeatLimitedString.
The string is the lexicographically largest repeatLimitedString possible so we return "bbabaa".
Note that the string "bbabaaa" is lexicographically larger but the letter 'a' appears more than 2 times in a row, so
it is not a valid repeatLimitedString.


Constraints:

1 <= repeatLimit <= s.length <= 105
s consists of lowercase English letters.
 */
public class constructStringWithRepeatLimit {
    /***
     * Approach 1 : Using two pointers to check and while condition to get the letter to create the string.
     * Complexity Analysis :
     *      Time Complexity  :  O(m * n)
     *      Space Complexity :  O(n)
     *//*
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder str = new StringBuilder();
        int counter1 = s.length() - 1, repeatLimitCounter = 1, counter2 = counter1-1;
        char lastChar = charArray[counter1--];
        str.append(lastChar);
        while (counter1 >= 0) {
            char currentChar = charArray[counter1];
            if (currentChar != '0') {
                if (currentChar == lastChar) {
                    if (repeatLimitCounter < repeatLimit) {
                        repeatLimitCounter++;
                        str.append(currentChar);
                    } else {
                        if(counter2 >= counter1){
                            counter2 = counter1-1;
                        };
                        while (counter2 >= 0 && (charArray[counter2] == lastChar || charArray[counter2] == '0')) {
                            counter2--;
                        }
                        if (counter2 == -1) {
                            break;
                        } else {
                            repeatLimitCounter = 1;
                            currentChar = charArray[counter2];
                            str.append(currentChar);
                            charArray[counter2] = '0';
                            counter1++;
                        }
                    }
                } else {
                    repeatLimitCounter = 1;
                    str.append(currentChar);
                }
            }
            counter1--;
            if(currentChar != '0'){
                lastChar = currentChar;
            }
        }
        return str.toString();
    }
    */
    /**
     * Approach 2 : Greedy approach with counter using frequency memorization
     * Complexity Analysis :
     *      Time Complexity : O(n)
     *      Space Complexity : O(n)
     */
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int currentCharIndex = 25;
        while (currentCharIndex >= 0) {
            if (freq[currentCharIndex] == 0) {
                currentCharIndex--;
                continue;
            }

            int use = Integer.min(freq[currentCharIndex], repeatLimit);
            result.append(String.valueOf((char) ('a' + currentCharIndex)).repeat(Math.max(0, use)));
            freq[currentCharIndex] -= use;

            if (freq[currentCharIndex] > 0) {
                int smallerCharIndex = currentCharIndex - 1;
                while (smallerCharIndex >= 0 && freq[smallerCharIndex] == 0) {
                    smallerCharIndex--;
                }
                if (smallerCharIndex < 0) {
                    break;
                }
                result.append((char) ('a' + smallerCharIndex));
                freq[smallerCharIndex]--;
            }
        }

        return result.toString();
    }
}
