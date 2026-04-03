/*

Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space.



Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]


Constraints:

1 <= n <= 5 * 104

 */


package Tree;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumber {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        dfs(1,n,ans);
        return ans;
    }
    void dfs (int a , int n , List<Integer> ans){
        if(a > n){
            return;
        }
        int c = a % 10;
        while(a <= n && c <= 9){
            ans.add(a);
            dfs(a * 10, n, ans);
            a++;
            c++;
        }
    }

    public static void main(String[] args) {
        LexicographicalNumber l = new LexicographicalNumber();
        List<Integer> p = l.lexicalOrder(127);
        p.stream().forEach(a -> System.out.println(a));
    }
}
