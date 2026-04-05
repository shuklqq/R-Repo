/*
There are n houses in line. indexed 0 to n-1. and input[i] is the height of the ith house.
Assume you are standing on the terrace of the house. Give an index of the closest house which is bigger than the current
house on the left side. If there is no house which is greater than the current house then print -1.
Print this output for all the houses.

input : [5,4,6,7,2,3]
output : [-1,0,-1,-1,3,3]

input : [4,3,2,1,2,3,4]
output : [-1,0,1,2,1,0,-1]

5,4,3

 */

package Interview;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Test1 {
    public static void main (String[] args){
        int arr[] = {8,10,6,7,9};
        int ans[] = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int a = 0 ; a < arr.length ; a++){
            while(!stack.isEmpty() && arr[a] >= arr[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[a] = stack.peek();
            }else{
                ans[a] = -1;
            }
            stack.add(a);
        }
        Arrays.stream(ans).forEach(a -> System.out.println(a));
    }
}
