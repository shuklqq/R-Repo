package InterviewPrep.Implementation.Arrays;

import java.util.Arrays;

/*
You are given two arrays of the same length, names and ages. Person i is called names[i] and is ages[i] years old.

Return the names of all the people, ordered by age from youngest to oldest. People of the same age are ordered by name, alphabetically.

Names compare letter by letter, and the first letter that differs decides. A name that is the start of a longer name comes first, so ann comes before anna. Two people can have the same name, and the answer holds one name per person.

Example 1
Input:
names = ["mia", "leo", "ava", "zoe", "ben"]
ages = [31, 25, 31, 19, 25]

Output: ["zoe","ben","leo","ava","mia"]
Explanation: Zoe is the youngest, at 19. Ben and Leo are both 25, so they go in name order, and so do Ava and Mia at 31.

Example 2
Input: names = ["sam", "sam", "al"], ages = [0, 7, 7]

Output: ["sam","al","sam"]
Explanation: The two people called sam are different people. The one aged 0 goes first. The other is 7, like al, and comes after al by name.

Example 3
Input: names = ["anna", "ann", "an"], ages = [40, 40, 40]

Output: ["an","ann","anna"]
Explanation: Everyone is 40, so the names alone decide the order, and a shorter name that starts a longer one goes first.

*/
public class SortPeoplebyAgeThenName {
    public String[] sortByAgeThenName(String[] names, int[] ages){
        int len = ages.length;
        Integer[] indices = new Integer[len];

        for(int a = 0 ; a < len ; a++){
            indices[a] = a;
        }
        Arrays.sort(indices, (a , b) -> {
            if(ages[a] != ages[b]){
                return Integer.compare(ages[a], ages[b]);
            }
            return names[a].compareTo(names[b]);
        });

        String[] result = new String[len];
        for(int i = 0; i < len; i++){
            result[i] = names[indices[i]];
        }
        return result;
    }
}
