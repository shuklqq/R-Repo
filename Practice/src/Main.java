import java.io.File;

public class Main {
    public static void main(String[] args) {

////Greatest Common DivisorOfStrings
//    /*
//    * Variable Declarations
//    * */
//        String str1 = "ABCABC";
//        String str2 = "ABC";
//        String result = "";
//
//    /*
//    * Method calls
//    *
//    * */
//        GreatestCommonDivisorOfStrings a  = new GreatestCommonDivisorOfStrings();
//        result = a.gcdOfStrings(str1,str2);
//
//    /*
//    * Response Print
//    *
//    * */
//
//        System.out.println("Result of the Method = "+ result);
//

////SubArrayWithZeroSum
//    SubArrayWithZeroSumUsingHashMap a = new SubArrayWithZeroSumUsingHashMap();
//    a.InvokeStart();
//

////Nth Fibonacci Number using Recursion
//        NthFibonacciNumberUsingRecursion a = new NthFibonacciNumberUsingRecursion();
//        a.InvokeStart();
//
//

//// Nth Fibonacci Number using DDynamic Programming
//        NthFibonacciNumberUsingDP a = new NthFibonacciNumberUsingDP();
//        a.InvokeStart();
//

//EquilibriumIndexOfArrayUsingArraySum
//        EquilibriumIndexOfAnArrayUsingArraySum a = new EquilibriumIndexOfAnArrayUsingArraySum();
//        a.InvokeStart();
//

//Trapping Rain Water Using pre calculation
//        TrappingRainWaterUsingPreCalculation a  = new TrappingRainWaterUsingPreCalculation();
//        a.InvokeStart();
//

// Trapping  Rain water using Stack
//          TrappingRainWaterUsingStack a = new TrappingRainWaterUsingStack();
//          a.InvokeStart();
//

// Array Subset of Another Array using hashmap
//        ArraySubsetofAnotherArrayUsingHashmap a = new ArraySubsetofAnotherArrayUsingHashmap();
//        a.InvokeStart();

// Methode to do File Handling.
//        FileHandling a = new FileHandling();
//        a.InvokeStart();
//        a.InvokeRead();
//  test
//        TestApplication test = new TestApplication();
//        test.InvokeMain();
//
//  Flower Bed
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        int[] a = {0};
        int n = 1;
        boolean b = cpf.canPlaceFlowers(a,n);
        System.out.println(b);
    }
}