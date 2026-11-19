package InterviewPrep.Implementation.Math;

import java.util.Arrays;

/*
Statement
You are given two integers n and k.

Initially, an array a of length n is initialized where a[i] = 
1
1
 for all 
0
≤
i
<
0≤i<
 n.

Every second, the array is updated such that each element at index i is replaced by the sum of all elements from index 
0
0
 to index i from the previous second.

Return the value of the element at index n 
−
1
−1
 after k seconds.

Note: Since the answer can be large, return the result modulo 
1
0
9
+
7
10 
9
 +7
.

Constraints:

1
≤
1≤
 n, k 
≤
1000
≤1000

*/
public class FindtheNthValueAfterKSeconds {

    private static final int MOD = 1_000_000_007;

    public int valueAfterKSeconds(int n, int k) {
        return (int) binomial(n - 1 + k, Math.min(n - 1, k));
    }

    // C(total, r) mod MOD: build top and bottom in one pass, invert the bottom once at the end
    private long binomial(int total, int r) {
        long num = 1, den = 1;
        for (int i = 1; i <= r; i++) {
            num = num * (total - r + i) % MOD;   // (k+1)(k+2)... or n(n+1)..., whichever is shorter
            den = den * i % MOD;                 // r!
        }
        return num * modPow(den, MOD - 2) % MOD; // dividing = multiplying by the inverse (Fermat)
    }

    // base^exp mod MOD by repeated squaring: O(log exp)
    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
   /*public int valueAfterKSeconds(int n, int k)
    {
        
        
        /*
        int[] a = new int[n];
        Arrays.fill(a , 1);
        int modulo = 1_000_000_007;
        for(int i = 0 ; i < k ; i++){
            for(int j = 1 ; j < n ;j++){
                a[j] = (a[j] + a[j-1]) % modulo;
            }
        }
        return a[n-1];
        
    }
        */
}
