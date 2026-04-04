package String

/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.

*/

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	prefix := strs[0]
	for i := 1; i < len(strs); i++ {
		for j := 0; j < len(prefix) && j < len(strs[i]); j++ {
			if prefix[j] != strs[i][j] {
				prefix = prefix[:j]
				break
			}
		}
		// If current string is shorter than prefix, trim prefix
		if len(strs[i]) < len(prefix) {
			prefix = prefix[:len(strs[i])]
		}
	}
	return prefix
}
