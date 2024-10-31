package String;

/*

You are given two strings sentence1 and sentence2, each representing a sentence composed of words. A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of only uppercase and lowercase English characters.

Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. Note that the inserted sentence must be separated from existing words by spaces.

For example,

s1 = "Hello Jane" and s2 = "Hello my name is Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in s1.
s1 = "Frog cool" and s2 = "Frogs are cool" are not similar, since although there is a sentence "s are" inserted into s1, it is not separated from "Frog" by a space.
Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.



Example 1:

Input: sentence1 = "My name is Haley", sentence2 = "My Haley"

Output: true

Explanation:

sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".

Example 2:

Input: sentence1 = "of", sentence2 = "A lot of words"

Output: false

Explanation:

No single sentence can be inserted inside one of the sentences to make it equal to the other.

Example 3:

Input: sentence1 = "Eating right now", sentence2 = "Eating"

Output: true

Explanation:

sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.



Constraints:

1 <= sentence1.length, sentence2.length <= 100
sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
The words in sentence1 and sentence2 are separated by a single space.

 */
public class SentenceSimilarity3 {

    /*
    Approach 1 : Splitting the string and comparing the two.
    Complexity Analysis :
        Time Complexity:
            String Length Comparison:The comparison sentence1.length() > sentence2.length() takes linear time, O(n + m),
                   where n and m are the lengths of sentence1 and sentence2, respectively.
                String Splitting: sentence1.trim().split("\\s+") and sentence2.trim().split("\\s+") both perform trimming
                and splitting of the string by whitespace. The trim() operation runs in O(n) and O(m), respectively, and the
                split() operation also runs in O(n) and O(m), as it has to iterate through the entire string.
                So, this step takes O(n + m) time in total.

            Length Calculation:str1.length and str2.length are constant time operations, O(1).
                Main Loop (While Loop):The while loop runs until x1 exceeds y1. This loop compares elements of the str1 and
                str2 arrays. The worst-case scenario involves iterating through all elements of str1 and str2, with each
                comparison being a constant-time operation.
                The number of iterations of the loop depends on the length of the shorter array (str1), which is len1.
                Therefore, the time complexity for this loop is O(len1).
                Since len1 can be at most n, the loop will run at most O(n) times.

            Overall Time Complexity:
                Splitting both sentences takes O(n + m).
                The while loop runs in O(n) (because str1 is shorter or equal to str2).
                Thus, the total time complexity is O(n + m), where n is the length of sentence1 and m is the length of sentence2.

        Space Complexity:
            Space for Splitting:
                When the split() method is called, two new arrays str1 and str2 are created, which store the individual
                words from sentence1 and sentence2. The space required for these arrays is proportional to the number of
                 words in each sentence.
                In the worst case, each word could be a single character, so the space complexity of storing these
                arrays is O(n + m), where n and m are the lengths of sentence1 and sentence2, respectively.

            Temporary Variables:The code uses a few integer variables (x1, x2, y1, y2) and booleans, which take up
                constant space, O(1).
            Overall Space Complexity:
                The space complexity is dominated by the space required to store the split strings (str1 and str2),
                which is O(n + m).
        Final Analysis:
            Time Complexity: O(n + m)
            Space Complexity: O(n + m)
     */
/*    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() > sentence2.length()) {
            String sentence3 = new String(sentence2);
            sentence2 = new String(sentence1);
            sentence1 = new String(sentence3);
        }
        String[] str1 = sentence1.trim().split("\\s+");
        String[] str2 = sentence2.trim().split("\\s+");
        int len1 = str1.length;
        int len2 = str2.length;
        if (len1 == 1) {
            if (str1[0].equals(str2[0]) || str1[0].equals(str2[len2 - 1])) {
                return true;
            } else {
                return false;
            }
        }
        int x1 = 0;
        int x2 = 0;
        int y1 = len1 - 1;
        int y2 = len2 - 1;
        while (x1 <= y1) {
            if (str1[x1].equals(str2[x2])) {
                x1++;
                x2++;
            } else if (str1[y1].equals(str2[y2])) {
                y1--;
                y2--;
            } else if (x1 == y1 && (str1[x1].equals(str2[x2]) || str1[y1].equals(str2[y2]))) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

 */

/*

Approach 2 : Splitting in more efficient way.
Complexity Analysis:
    Time Complexity:
        Initial Setup:
        The comparison s1.length() > s2.length() takes O(n + m) time, where n and m are the lengths of s1 and s2, respectively.
        The reassignment of s1, s2, and s3 takes constant time, O(1).
        Splitting Strings:
        s1.split(" ") and s2.split(" ") split the strings s1 and s2 into arrays of words. Splitting a string on whitespace takes O(n) for s1 and O(m) for s2, where n and m are the lengths of the two strings.
        While Loop:
        The loop iterates over the length of the shorter array, a.length (derived from s1).
        In each iteration, it performs a constant-time comparison, either a[i].equals(b[i]) or a[i].equals(b[b.length - a.length + i]). Both of these are O(1) comparisons.
        Therefore, the number of iterations of the loop is bounded by a.length, which is proportional to the number of words in s1. The time for this loop is O(a.length), where a.length is at most the number of words in s1.

        Try-Catch Block:
        The try-catch block is designed to handle any potential out-of-bounds exceptions. This block only adds constant overhead, as exceptions are unlikely to occur in normal execution.
        Final Return:
        The comparison a.length == i is done in constant time, O(1).
        Overall Time Complexity:
        Splitting the strings takes O(n + m).
        The while loop runs for O(a.length), where a.length is the number of words in the shorter string (s1).
        Thus, the overall time complexity is O(n + m), where n and m are the lengths of s1 and s2, respectively.

        Space Complexity:
        String Arrays:

        The function creates two new arrays a and b from s1 and s2. The space required for these arrays is proportional to the number of words in each string. In the worst case, if every word is a single character, this would take O(n + m) space.
        Temporary Variables:

        A few scalar variables (i, s3, flag) are used, which take O(1) space.
        Overall Space Complexity:
        The space complexity is dominated by the space required to store the arrays a and b, which is O(n + m).
        Final Analysis:
        Time Complexity: O(n + m), where n and m are the lengths of s1 and s2.
        Space Complexity: O(n + m) for storing the split string arrays.

 */
public boolean areSentencesSimilar(String s1, String s2) {
    int i = 0;
    String s3 = "";
    if (s1.length() > s2.length()) {
        s3 = s1;
        s1 = s2;
        s2 = s3;
    }
    String[] a = s1.split(" ");
    String[] b = s2.split(" ");

    Boolean flag = false;
    try {
        while (i < a.length) {
            if (a[i].equals(b[i]) && !flag) {
                i++;
            } else if (a[i].equals(b[b.length - a.length + i])) {
                flag = true;
                i++;
            } else {
                return false;
            }
        }
    } catch (Exception e) {
        return false;
    }
    return a.length == i;
}
}
