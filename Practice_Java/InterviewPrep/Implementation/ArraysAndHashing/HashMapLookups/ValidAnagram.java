package InterviewPrep.Implementation.ArraysAndHashing.HashMapLookups;
/*
You are given two strings s and t. Return true if t uses exactly the same letters as s, each one the same number of times, and false otherwise. Put another way, return true when the letters of s can be rearranged to spell t.

The order of the letters does not matter, but how many times each letter appears does. So "aab" and "aba" match, while "aab" and "abb" do not.

Example 1
Input: s = "carthorse", t = "orchestra"

Output: true
Explanation: Both words have nine letters: one each of a, c, e, h, o, s and t, and two of r. Only the order is different.

Example 2
Input: s = "letter", t = "settle"

Output: false
Explanation: The two words have the same length and share most of their letters. But letter has an r where settle has an s.

Example 3
Input: s = "aabb", t = "ab"

Output: false
Explanation: t holds every letter that s holds, but only once each, while s has two of each. Strings of different lengths can never match.

Topics
String
Hash Map
Sorting

*/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        if(s.length() != t.length()){
            return false;
        }
        for(int a = 0 ; a < s.length() ; a++){
            letters[s.charAt(a) - 'a']++;
            letters[t.charAt(a) - 'a']--;
        }
        for(int a : letters){
            if(a != 0){
                return false;
            }
        }
        return true;
    }
}
