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
//        CanPlaceFlowers cpf = new CanPlaceFlowers();
//        int[] a = {0};
//        int n = 1;
//        boolean b = cpf.canPlaceFlowers(a,n);
//        System.out.println(b);

// ReverseVowels
//        ReverseVowels rv = new ReverseVowels();
//        String s = "haeiowuo";
//        System.out.println(rv.reverseVowels(s));

// Reverse Words
//        ReverseWords rw = new ReverseWords();
//        String s = "  hello world ";
//        System.out.println(rw.reverseWords(s));

// Product of Array except self
//        ProductOfArrayExceptSelf poaes = new ProductOfArrayExceptSelf();
//        int [] arr = {1,2,3,4};
//        int [] result = poaes.productExceptSelf(arr);

// Increasing Triplet Subsequesnce
//        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
//        int[] nums = {1,2,3,4,5};
//        System.out.println(its.increasingTriplet(nums));

// StringCompression
//         StringCompression sc = new StringCompression();
//        char[] ch = {'a','b','c'};
//        String s = "aabbccc";
//        System.out.println(sc.compress(ch));
//        System.out.println(ch);

// Move Zeroes
//        MoveZeroes mz = new MoveZeroes();
//        int[] nums = {0,1,0,3,12};
//        mz.moveZeroes(nums);

// Is Subsequence
//        IsSubsequence is = new IsSubsequence();
//        String s = "axc";
//        String t = "ahbgdc";
//        System.out.println(is.isSubsequence(s,t));

// MaxArea of container
//        ContainerWithMostWater cwmw = new ContainerWithMostWater();
//        int[] a = {76,155,15,188,180,154,84,34,187,142,22,5,27,183,111,128,50,58,2,112,179,2,100,111,115,76,134,120,118,103,31,146,58,198,134,38,104,170,25,92,112,199,49,140,135,160,20,185,171,23,98,150,177,198,61,92,26,147,164,144,51,196,42,109,194,177,100,99,99,125,143,12,76,192,152,11,152,124,197,123,147,95,73,124,45,86,168,24,34,133,120,85,81,163,146,75,92,198,126,191};
//        System.out.println(cwmw.maxArea(a));
//        System.out.println(a.length);

// Max Number of K - Sum Pairs
//        MaxNumberOfKSumPairs mnksp = new MaxNumberOfKSumPairs();
//        int a[] = {3,4};
//        int k = 5;
//        System.out.println(mnksp.maxOperation(a,k));

//Maximum Average Subarray
//        MaximumAverageSubArray1 ma = new MaximumAverageSubArray1();
//        int[] ar = {1,12,-5,-6,50,3};
//        int k = 4;
//        System.out.println(ma.findMaxAverage(ar,k));

// Maximum vowels in a Substring
//        MaximumNumberOfVowels mnv = new MaximumNumberOfVowels();
//        String s = "weallloveyou";
//        int k = 7;
//        System.out.println(mnv.maxVowels(s,k));

// Maximum Consecutive Ones
//        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
//        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
//        int k = 2;
//        System.out.println(mco.longestOnes(nums,k));

// Longest Subarray of ones after Deleting one element
//        LongestSubArrayOfOnesAfterDeletingOneElement lsa = new LongestSubArrayOfOnesAfterDeletingOneElement();
//        int[] nums = {1,1,0,1};
//        System.out.println(lsa.longestSubarray(nums));

//  FindThe Highest Altitude
//        FindTheHighestAltitude fth = new FindTheHighestAltitude();
//        int[] nums = {-4,-3,-2,-1,4,3,2};
//        System.out.println(fth.largestAltitude(nums));

// Find Pivot Index
//        FindPivotIndex fpi = new FindPivotIndex();
//        int[] a = {1,7,3,6,5,6};
//        System.out.println(fpi.pivotIndex(a));

// Difference of Two Arrays
//        DifferenceOfTwoArrays dot = new DifferenceOfTwoArrays();
//        int[] a = {1,2,3};
//        int[] b = {2,4,6};
//        System.out.println(dot.findDifference(a,b));

// Unique Number of Occurrences
//        UniqueNumberOfOccurrences uno = new UniqueNumberOfOccurrences();
//        int[] arr = {26,2,16,16,5,5,26,2,5,20,20,5,2,20,2,2,20,2,16,20,16,17,16,2,16,20,26,16};
//        System.out.println(uno.uniqueOccurrences(arr));

// Determine if two strings are close
//        DetermineIfTwoStringsAreClosed2 dit = new DetermineIfTwoStringsAreClosed2();
//        String s1 = "idepikndmiddzcdcdahncdcvhnifhbizrdyyicwnijcmscszdgtlnyonishuiiqdxhic";
//        String s2 = "axxkhxlphcsycywsigilhsixdiuclqlxzbcexkcllfyocxcjklpnvxxixytixmccyclr";
//        System.out.println(dit.closeStrings(s1,s2));

// Equal Rows And Column Pairs
//        EqualRowsAndColumnPairs2 er = new EqualRowsAndColumnPairs2();
//        int[][] grid = {{11,1},{1,11}};
//        System.out.println(er.equalPairs(grid));

// Remove Stars from a string
//        RemoveStarsFromAString rs = new RemoveStarsFromAString();
//        String s = "leet**cod*e";
//        System.out.println(rs.removeStars(s));

// Astroid Collision
//        AstroidCollision ac = new AstroidCollision();
//        int[] arr = {-2,-1,1,2};
//        int[] b = ac.asteroidCollision(arr);
//        for(int a = 0 ; a < b.length ; a++){
//            System.out.println(b[a]);
//        }

// Decode String
//        DecodeString ds = new DecodeString();
//        String s = "100[leetcode]";
//        System.out.println(ds.decodeString(s));

// Predict Party Victory
        PredictPartyVictory ppv = new PredictPartyVictory();
        String s = "DDDRRRRR";
        System.out.println(ppv.predictPartyVictory(s));
   }
}