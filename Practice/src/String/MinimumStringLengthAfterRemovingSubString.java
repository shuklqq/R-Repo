package String;
/*

            You are given a string s consisting only of uppercase English letters.

            You can apply some operations to this string where, in one operation, you can remove any occurrence of one of the substrings "AB" or "CD" from s.

            Return the minimum possible length of the resulting string that you can obtain.

            Note that the string concatenates after removing the substring and could produce new "AB" or "CD" substrings.



            Example 1:

            Input: s = "ABFCACDB"
            Output: 2
            Explanation: We can do the following operations:
            - Remove the substring "ABFCACDB", so s = "FCACDB".
            - Remove the substring "FCACDB", so s = "FCAB".
            - Remove the substring "FCAB", so s = "FC".
            So the resulting length of the string is 2.
            It can be shown that it is the minimum length that we can obtain.
            Example 2:

            Input: s = "ACBBD"
            Output: 5
            Explanation: We cannot do any operations on the string so the length remains the same.


            Constraints:

            1 <= s.length <= 100
            s consists only of uppercase English letters.


 */
public class MinimumStringLengthAfterRemovingSubString {
    /*

    Complexity Analysis :
        Time Complexity:
            Initialization:
                A StringBuilder is created from the input string s. Constructing a StringBuilder from a string takes O(n) time,
                where n is the length of the string s.
            While Loop:

            The loop runs while a < str.length() - 1.
            Inside the loop:
                Character Comparisons: Each iteration compares characters at positions a and a+1, which are constant-time
                    operations, O(1).
                Deletion: If a match is found (either "AB" or "CD"), str.delete(a, a+2) deletes two characters from the
                    StringBuilder. Deletion from a StringBuilder takes O(n) in the worst case, since it involves shifting the
                    remaining characters after the deletion.
                Updating Index a: When deletion occurs, if a != 0, a-- is executed to ensure that adjacent characters can be
                    re-checked. Otherwise, a++ increments the index.
            Worst Case Scenario:
                In the worst case, deletions can keep reducing the string size and the loop may need to recheck characters,
                 leading to repeated deletions.
                Every time a pair is deleted, the length of the string reduces, but since deleting two characters could
                involve a shift of up to O(n) characters, the total cost of deletions accumulates.
                If the deletion happens in every iteration, the time complexity for each deletion is O(n) (since it shifts
                 characters). There can be O(n) deletions in total, resulting in a worst-case time complexity of O(n²).

            Return Statement:
                Finally, str.length() is returned, which is a constant-time operation, O(1).
            Overall Time Complexity:
            StringBuilder creation: O(n)
            While loop: In the worst case, O(n²) due to the repeated deletions and shifting.
                 Thus, the overall time complexity is O(n²) in the worst case.

        Space Complexity:
            StringBuilder:
                The StringBuilder takes space proportional to the length of the input string, O(n).
            Temporary Variables:
                The variables a and a few other constants are used, which take O(1) space.
            Overall Space Complexity:
                The space complexity is O(n) due to the StringBuilder object, which stores a copy of the input string.
        Final Analysis:
            Time Complexity: O(n²) in the worst case (due to repeated deletions and shifting).
            Space Complexity: O(n) (space used by StringBuilder).

     */
    public int minLength(String s) {
        StringBuilder str = new StringBuilder(s);
        int a = 0;
        while(a < str.length()-1){
            if(str.charAt(a) == 'A'){
                if(str.charAt(a+1) == 'B'){
                    str.delete(a, a+2);
                    if(a != 0){
                        a--;
                    }
                }else{
                    a++;
                }
            }else if( str.charAt(a) == 'C'){
                if(str.charAt(a+1) == 'D'){
                    str.delete(a, a+2);
                    if(a != 0){
                        a--;
                    }
                }else{
                    a++;
                }
            }else{
                a++;
            }
        }
        return str.length();
    }
}
