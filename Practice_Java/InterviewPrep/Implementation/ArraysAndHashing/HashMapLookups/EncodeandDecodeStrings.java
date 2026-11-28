package InterviewPrep.Implementation.ArraysAndHashing.HashMapLookups;

import java.util.ArrayList;
import java.util.List;

/*

You are given a list of strings words. Write two functions. encode packs the whole list into one string. decode takes that string and returns the original list, with every word exactly as it was and in the same order.

A word can hold any printable ASCII character, including spaces, commas, digits and #. A word can also be empty, and so can the list.

decode must rebuild the list from the packed string alone. It cannot use anything encode saved, such as a field on the class.

Example 1
Input: words = ["pack", "my", "bag"]

Output: ["pack","my","bag"]
Explanation: Any packed string works, as long as decode can read the list back out of it.

Example 2
Input: words = ["a,b", "", "#1 two"]

Output: ["a,b","","#1 two"]
Explanation: The first word holds a comma, the second is empty, and the third starts with #. All three come back exactly as they were.

Example 3
Input: words = []

Output: []
Explanation: An empty list must come back empty. That is not the same as a list holding one empty word, which must come back as [""].

Constraints
0 ≤ words.length ≤ 104
0 ≤ words[i].length ≤ 200
All the words together hold at most 2 × 105 characters.
Every character is printable ASCII, codes 32 to 126.


Topics
String
Design

*/
public class EncodeandDecodeStrings {
    /*
    Time Complexity : O(n)
    Space Complexity : O(n)
    */
    public static final char MARKER = '#';
    public String encode(List<String> words) {
        StringBuilder str = new StringBuilder();
        for(String s : words){
            int len = s.length();
            str.append(len);
            str.append(MARKER);
            str.append(s);
        }
        return str.toString();
    }

    public List<String> decode(String packed) {
        List<String> str = new ArrayList<>();
        int a = 0;
        while(a < packed.length()){
            int marketAt = packed.indexOf(MARKER, a);
            String digit = packed.substring(a , marketAt);
            int len = Integer.parseInt(digit);
            str.add(packed.substring(marketAt + 1, marketAt + 1 + len));
            a = marketAt + 1 + len;
        }
        return str;
    }
}
