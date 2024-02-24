public class NthFibonacciNumberUsingDP {


    static int Fib(int n){
        int[] f = new int[n+2];
        int i;

        f[0] = 0;
        f[1] = 1;

        for(i = 2;i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
    static void InvokeStart(){
        int i = 9;
        System.out.println(i+"th Fibonacci Number is : "+ Fib(i));
    }
}
