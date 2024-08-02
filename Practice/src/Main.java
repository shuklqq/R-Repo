import LinkedList.DeleteTheMiddleNode;
import LinkedList.ListNode;
import LinkedList.MaximumTwinSumOfALinkedList;
import LinkedList.OddEvenLinkedList;
import Tree.*;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
//        PredictPartyVictory ppv = new PredictPartyVictory();
//        String s = "DDDRRRRR";
//        System.out.println(ppv.predictPartyVictory(s));

// Delete the Middle node of the LinkedList
//        DeleteTheMiddleNode dm = new DeleteTheMiddleNode();
//        ListNode listNode7 = new ListNode(7,null);
//        ListNode listNode6 = new ListNode(6,listNode7);
//        ListNode listNode5 = new ListNode(5,listNode6);
//        ListNode listNode4 = new ListNode(4,listNode5);
//        ListNode listNode3 = new ListNode(3,listNode4);
//        ListNode listNode2 = new ListNode(2,listNode3);
//        ListNode listNode1 = new ListNode(1,listNode2);
//
//        ListNode final1 = dm.deleteMiddle(listNode1);
//        while(final1 != null){
//            System.out.println(final1.getValue());
//            final1 = final1.getNext();
//        }

// OddEvenLinkedList
//        OddEvenLinkedList oe = new OddEvenLinkedList();
//        ListNode listNode4 = new ListNode(1,null);
//        ListNode listNode3 = new ListNode(3,listNode4);
//        ListNode listNode2 = new ListNode(4,listNode3);
//        ListNode listNode1 = new ListNode(5,listNode2);
//
//        ListNode final1  = oe.oddEvenList(listNode1);
//
//        while(final1 != null){
//            System.out.println(final1.getValue());
//            final1 = final1.getNext();
//        }

// Maximum twin sum of a linked list
//        MaximumTwinSumOfALinkedList ma = new MaximumTwinSumOfALinkedList();
//        ListNode listNode4 = new ListNode(1,null);
//        ListNode listNode3 = new ListNode(3,listNode4);
//        ListNode listNode2 = new ListNode(4,listNode3);
//        ListNode listNode1 = new ListNode(5,listNode2);
//
//        int final1  = ma.pairSum(listNode1);
//        System.out.println("Sum : " + final1);

// Leaf Similar Tree
//        LeafSimilarTree lf = new LeafSimilarTree();
//        TreeNode t1 = new TreeNode(6, null,null );
//        TreeNode t2 = new TreeNode(7, null,null );
//        TreeNode t3 = new TreeNode(9, null,null );
//        TreeNode t4 = new TreeNode(4, null,null );
//        TreeNode t5 = new TreeNode(8, null,null );
//        TreeNode t6 = new TreeNode(2, t2,t3 );
//        TreeNode t7 = new TreeNode(1, t4,t5 );
//        TreeNode t8 = new TreeNode(5, t1,t6 );
//        TreeNode t9 = new TreeNode(3, t8,t7 );
//
//        TreeNode p1 = new TreeNode(6, null,null );
//        TreeNode p2 = new TreeNode(7, null,null );
//        TreeNode p3 = new TreeNode(4, null,null );
//        TreeNode p4 = new TreeNode(9, null,null );
//        TreeNode p5 = new TreeNode(8, null,null );
//        TreeNode p6 = new TreeNode(2, p4,p5 );
//        TreeNode p7 = new TreeNode(1, p3,p6 );
//        TreeNode p8 = new TreeNode(5, p1,p2 );
//        TreeNode p9 = new TreeNode(3, p8,p7 );
//
//        System.out.println(lf.leafSimilar(t9,p9));

// Count Good Nodes
//        CountGoodNodes cg = new CountGoodNodes();

// Path Sum
//        PathSum3 ps = new PathSum3();

//LongestZigZag Path
//        LongestZigZag2 lz = new LongestZigZag2();

// Lowest Common Ancestor
//        LowestCommonAncestor lc = new LowestCommonAncestor();
//        TreeNode p1 = new TreeNode(6, null,null );
//        TreeNode p2 = new TreeNode(7, null,null );
//        TreeNode p3 = new TreeNode(4, null,null );
//        TreeNode p4 = new TreeNode(0, null,null );
//        TreeNode p5 = new TreeNode(8, null,null );
//        TreeNode p6 = new TreeNode(2, p2,p3);
//        TreeNode p7 = new TreeNode(5, p1,p6 );
//        TreeNode p8 = new TreeNode(1, p4,p5 );
//        TreeNode p9 = new TreeNode(3, p7,p8 );
//
//        System.out.println(lc.lowestCommonAncestor(p9, p7, p8).val);

// Binary Tree Right Side view
//        BinaryTreeRightSideView bt = new BinaryTreeRightSideView();
//        TreeNode p1 = new TreeNode(5, null,null );
//        TreeNode p2 = new TreeNode(4, null,null );
//        TreeNode p3 = new TreeNode(2, null,p1 );
//        TreeNode p4 = new TreeNode(3, null,p2 );
//        TreeNode p5 = new TreeNode(1, p3,p4 );
//
//        List<Integer> arr = bt.rightSideView(p5);
//        for(int a = 0 ; a < arr.size() ; a++){
//            System.out.println(arr.get(a));
//        }

//Binary Search Tree Deletion
        DeleteNodeInBST dn = new DeleteNodeInBST();
        TreeNode p1 = new TreeNode(2, null, null);
        TreeNode p2 = new TreeNode(4, null, null);
        TreeNode p3 = new TreeNode(7, null, null);
        TreeNode p4 = new TreeNode(3, p1, p2);
        TreeNode p5 = new TreeNode(6, null, p3);
        TreeNode p6 = new TreeNode(5, p4, p5);
        TreeNode result = dn.deleteNode(p6,3);
        System.out.println("Returned from function");
        inorderPrint(result);
   }

    private static void inorderPrint(TreeNode result) {
        Queue<TreeNode> print = new LinkedList<>();
        print.add(result);
        while(!print.isEmpty()){
            TreeNode temp = print.poll();
            System.out.println(temp.val);
            if(temp.getLeft() != null){
                print.add(temp.getLeft());
            }
            if(temp.getRight() != null){
                print.add(temp.getRight());
            }
        }
    }
}