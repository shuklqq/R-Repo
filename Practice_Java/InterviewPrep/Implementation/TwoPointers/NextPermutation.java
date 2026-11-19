package InterviewPrep.Implementation.TwoPointers;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1, 2, 3], the following are all the permutations of arr: [1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

Examples:

The next permutation of arr = [1, 2, 3] is [1, 3, 2].
The next permutation of arr = [2, 3, 1] is [3, 1, 2].
The next permutation of arr = [3, 2, 1] is [1, 2, 3] because [3, 2, 1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

*/
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int pivot = findPivot(nums);
        if (pivot >= 0) {
            swap(nums, pivot, findSuccessor(nums, pivot));
        }
        reverse(nums, pivot + 1, nums.length - 1);
    }
    private int findPivot(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        return i;
    }
    private int findSuccessor(int[] nums, int pivot) {
        int j = nums.length - 1;
        while (nums[j] <= nums[pivot])
            j--;
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right)
            swap(nums, left++, right--);
    }

    /*
    public void nextPermutation(int[] nums) {

        
        int iterator = nums.length - 2;
        boolean swapped = false;
        int leftSmallest;
        while(!swapped && iterator >= 0){
            if(nums[iterator] < nums[iterator + 1]){
                leftSmallest = iterator + 1;
                for(int a = iterator+1 ; a < nums.length ; a++){
                    if(nums[a] <= nums[leftSmallest] && nums[a] > nums[iterator]){
                        leftSmallest = a;
                    }
                }                
                int c = nums[iterator];
                nums[iterator] = nums[leftSmallest];
                nums[leftSmallest] = c;
                swapped = true;
                // Suffix is still descending after the swap; reverse it to make it the smallest arrangement.
                for(int left = iterator + 1, right = nums.length - 1; left < right; left++, right--){
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }
            iterator--;
        }
        if(!swapped){
            Arrays.sort(nums);
        }


        // int len = nums.length;
        // int pointer1 = len-1;
        // boolean swapped = false;
        // int pointer2;
        // while(!swapped && pointer1 >= 0){
        //     pointer2 = pointer1-1;
        //     while(!swapped && pointer2 >= 0){
        //         if(nums[pointer2] < nums [pointer1]){
        //             int c = nums[pointer1];
        //             nums[pointer1] = nums[pointer2];
        //             nums[pointer2] = c;
        //             swapped = true;
        //         }
        //         pointer2--;
        //     }
        //     pointer1--;
        // }
        // if(!swapped){
        //     Arrays.sort(nums);
        // }
        Arrays.stream(nums).forEach(System.out::print);
    }
    */
    public static void main(String[] args){
        int[] number = new int[]{1,2,3,4,5};
        NextPermutation next = new NextPermutation();
        next.nextPermutation(number);
    }
}
