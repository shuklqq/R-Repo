package StringAndArray;

import java.util.Arrays;

public class RotateArray {
//        k = k % nums.length;
//        System.out.println("k : " + k);
//        if(k != 0) {
//            int[] arr = new int[k];
//            int i = 0;
//            for (int a = nums.length - k ; a < nums.length; a++) {
//                System.out.println("a : " + a + " | i : " + i);
//                arr[i] = nums[a];
//                i++;
//            }
//            i = nums.length - 1;
//            for (int a = nums.length - k - 1; a >= 0; a--) {
//                System.out.println("i : " + i + " | a : " + a);
//                nums[i] = nums[a];
//                i--;
//            }
//            for (int a = 0 ; a < arr.length; a++) {
//                nums[a] = arr[a];
//            }
//        }


    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);

    }

    public static void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

