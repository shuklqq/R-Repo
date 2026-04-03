package StringAndArray;

import java.util.Stack;

public class TrappingRainWaterUsingStack {
    public int Trap(int arr[], int n){
        int sum = 0;

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while((!st.isEmpty()) && (arr[st.peek()] < arr[i])){
                int stackTop = arr[st.peek()];
                st.pop();

                if(st.isEmpty())
                    break;

                int distance = i-st.peek() - 1;

                int min = Math.min(arr[st.peek()], arr[i]) - stackTop;

                sum += distance * min;
            }
            st.push(i);
        }
        return sum;
    }
    public void InvokeStart(){
        int[] a = {3,0,0,2,0,4};
        int len = a.length;

        System.out.println("The total amount of rain water stored is : " + Trap(a,len));
    }
}
