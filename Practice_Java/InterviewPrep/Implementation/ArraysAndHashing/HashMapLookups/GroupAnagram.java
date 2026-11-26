package InterviewPrep.Implementation.ArraysAndHashing.HashMapLookups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
You are given a list of lowercase words, words. Two words are anagrams if one can be rearranged into the other: they use the same letters, and each letter the same number of times.

Split the words into groups so that two words share a group exactly when they are anagrams, and return the groups. Every word belongs to exactly one group, and a word that appears twice in words appears twice in its group.

The groups can come back in any order, and so can the words inside each group. The examples list each group's words alphabetically and sort the groups by their first word.

Example 1
Input: words = ["pat", "rot", "tap", "sun", "tor", "apt"]

Output: [["apt","pat","tap"],["rot","tor"],["sun"]]
Explanation: "pat", "tap" and "apt" each use a, p and t once. "rot" and "tor" each use o, r and t once. "sun" has no anagram in the list, so it forms a group on its own.

Example 2
Input: words = ["dog", "god", "dog", "cat"]

Output: [["cat"],["dog","dog","god"]]
Explanation: "dog" appears twice, and both copies go into the group with "god". "cat" is alone.

Example 3
Input: words = ["aab", "aba", "abb", "bab", "b"]

Output: [["aab","aba"],["abb","bab"],["b"]]
Explanation: "aab" and "abb" use the same two letters, but "aab" has two a's and "abb" has two b's, so they are not anagrams. "b" has the right letter but not enough of them.

Constraints
1 ≤ words.length ≤ 104
1 ≤ words[i].length ≤ 100
words[i] holds only lowercase English letters

Topics
Array
Hash Map
String
Sorting

*/
public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] words) {
        HashMap<String, List<String>> complete = new HashMap<>();
        for(String word : words){
            char[] temp = word.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            complete.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(complete.values());
    }
}
