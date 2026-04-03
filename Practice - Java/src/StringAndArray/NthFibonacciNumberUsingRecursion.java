package StringAndArray;

public class NthFibonacciNumberUsingRecursion {

    static int fibonacciNumber(int Num){
        if(Num <= 1)
            return Num;

        return fibonacciNumber(Num-1)+fibonacciNumber(Num-2);
    }
    static void InvokeStart(){
        int n = 9;
        System.out.println(n +"th Fibonacci Number is : "+ fibonacciNumber(n));
    }
}
