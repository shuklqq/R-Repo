package String;

import java.util.PriorityQueue;

/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.



Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""


Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */
public class reOrganizeString {
    /**
     * Approach 1 : Using frequency count and priority queue based on the frequency.
     * Complexity Analysis :
     *      Time Complexity : O(N * logK)
     *      Space Complexity : O(K)
     */
    /*
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        PriorityQueue<Character> minHeap = new PriorityQueue<>((a, b) -> {
            if(freq[b - 'a'] == freq[a - 'a']){
                return -1;
            }else{
                return freq[b - 'a'] - freq[a - 'a'];
            }
        });
        for (int a = 0; a < 26; a++) {
            if (freq[a] != 0) {
                minHeap.add((char) (a + 'a'));
            }
        }
        if(freq[minHeap.peek() - 'a'] > (s.length() / 2)+1){
            return "";
        }
        StringBuilder str = new StringBuilder();
        while (!minHeap.isEmpty()) {
            char ch1 = minHeap.poll();
            if (minHeap.isEmpty()) {
                if(freq[ch1 - 'a'] > 1){
                    break;
                }else{
                    if(str.isEmpty() || str.charAt(str.length() - 1) != ch1){
                        str.append(ch1);
                    }else{
                        break;
                    }
                }
            } else {
                char ch2 = minHeap.poll();
                str.append(ch1).append(ch2);
                freq[ch2 - 'a']--;
                if (freq[ch2 - 'a'] != 0) {
                    minHeap.add(ch2);
                }
            }
            freq[ch1 - 'a']--;
            if (freq[ch1 - 'a'] != 0) {
                minHeap.add(ch1);
            }

        }
        return (str.length() != s.length()) ? "" : str.toString();
    }

     */
    /**
     * Approach 2 : Counting and Odd/Even
     * Complexity Analysis :
     *      Time Complexity : O(N)
     *      Space Complexity : O(N)
     */
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int len = s.length();

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int maxFreq = 0, maxIndex = 0;

        for (int a = 0; a < 26; a++) {
            if (freq[a] > maxFreq) {
                maxFreq = freq[a];
                maxIndex = a;
            }
        }
        if (maxFreq > ((len + 1) / 2)) {
            return "";
        }

        int counter = 0;
        freq[maxIndex] = 0;
        char ch = (char) ('a' + maxIndex);
        char[] str = new char[len];
        for (int a = 0; a < maxFreq; a++) {
            str[counter] = ch;
            counter += 2;
        }

        for (int a = 0; a < 26; a++) {
            if (freq[a] != 0) {
                int freqCounter = freq[a];
                ch = (char) ('a' + a);
                while (freqCounter > 0) {
                    if (counter >= len) {
                        counter = 1;
                    }
                    str[counter] = ch;
                    counter += 2;
                    freqCounter--;
                }
            }
        }
        return String.valueOf(str);
    }
}
