/*

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100

 */

package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
//        Stack<Integer> arr = new Stack<>();
//        int size = temperatures.length;
//        int[] ans = new int[size];
//        arr.add(size - 1);
//        for(int a = size - 2 ; a >= 0 ; a--){
//            int top = arr.peek();
//            if(temperatures[a] >= temperatures[top]){
//                arr.pop();
//                while(!arr.isEmpty()){
//                    top = arr.peek();
//                    if(temperatures[a] < temperatures[top]){
//                        ans[a] = top - a;
//                        break;
//                    }
//                    arr.pop();
//                }
//                arr.add(a);
//            }else{
//                ans[a] = top - a;
//                arr.add(a);
//            }
//        }
//        return ans;

// Aproach 2 : using Array Dequeue

        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }

        return answer;        
    }
}
