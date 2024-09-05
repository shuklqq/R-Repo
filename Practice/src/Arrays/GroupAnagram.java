/*

Given an array of strings strs, group the
anagrams
 together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 */

package Arrays;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {

// Approach 1

//        Map<String, List<String>> memo = new HashMap<>();
//        List<List<String>> res = new ArrayList<>();
//        for (int a = 0; a < strs.length; a++) {
//            char[] b = strs[a].toCharArray();
//            Arrays.sort(b);
//            String f = String.valueOf(b);
//            List<String> temp;
//            if (memo.containsKey(f)) {
//                temp = memo.get(f);
//                temp.add(strs[a]);
//                memo.put(f, temp);
//            } else {
//                temp = new ArrayList<>();
//                temp.add(strs[a]);
//                memo.put(f, temp);
//            }
//        }
//        for (String key : memo.keySet()) {
//            res.add(memo.get(key));
//        }
//        return res;

// Approach 2
        Map<String, List<String>> memo = new HashMap<>();
        for (String s : strs) {
            char[] b = s.toCharArray();
            Arrays.sort(b);
            String f = String.valueOf(b);
            memo.putIfAbsent(f, new ArrayList<>());
            memo.get(f).add(s);
        }
        return new ArrayList<>(memo.values());
    }
}
