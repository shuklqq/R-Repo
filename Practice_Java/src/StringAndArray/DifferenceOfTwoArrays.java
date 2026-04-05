package StringAndArray;

import java.util.*;

public class DifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//        ArrayList<Integer> n1 = new ArrayList<>();
//        ArrayList<Integer> n2 = new ArrayList<>();
//        ArrayList<Integer> n3 = new ArrayList<>();
//        int a = 0;
//        while(a < nums1.length && a < nums2.length){
//            n1.add(nums1[a]);
//            n3.add(nums2[a]);
//            a++;
//        }
//        if(nums1.length < nums2.length){
//            while( a < nums2.length){
//                n3.add(nums2[a]);
//                a++;
//            }
//        }else{
//            while(a < nums1.length){
//                n1.add(nums1[a]);
//                a++;
//            }
//        }
//        System.out.println(n1 + " : " + n3);
//        for(a = 0 ; a < nums2.length; a++){
//            if(!n1.contains(nums2[a]) && !n2.contains(nums2[a])){
//                n2.add(nums2[a]);
//            }
//        }
//        n1 = new ArrayList<>();
//        for(a = 0 ; a < nums1.length ; a++){
//            if(!n3.contains(nums1[a]) && !n1.contains(nums1[a])){
//                n1.add(nums1[a]);
//            }
//        }
//        List<List<Integer>> arr = new ArrayList<>();
//        arr.add(n1);
//        arr.add(n2);
//        return arr;

        Set<Integer> n1 = new HashSet<>();
        Set<Integer> n3 = new HashSet<>();
        for(int a : nums1){
            n1.add(a);
        }
        ArrayList<Integer> n2 = new ArrayList<>();
        for(int b : nums2){
            if(!n1.contains(b) && !n2.contains(b)){
                n2.add(b);
            }else{
                n3.add(b);
            }
        }
        n1.removeAll(n3);
        ArrayList<Integer> n4 = new ArrayList<>(n1);
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(n4);
        arr.add(n2);
        return arr;
    }
}
