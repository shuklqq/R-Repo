package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test4 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        int zeroIndex = 0;
        for(int a = 0 ; a < size ; a++){
            System.out.println("1");
            if(nums[a] >= 0){
                zeroIndex = a;
                System.out.println("2");
                break;
            }
        }
        if(nums[zeroIndex] == 0 && ((zeroIndex == 0) ||(zeroIndex == size - 1))){
            return ans;
        }
        System.out.println("3");
        int leftIndex = zeroIndex - 1;
        int rightIndex = zeroIndex;
        while(leftIndex > 0 && rightIndex < size){
            int twoSum = nums[leftIndex] + nums[rightIndex];
            System.out.println("4  = " + twoSum);
            if( twoSum > 0){
                System.out.println("5  = " + twoSum);
                if(nums[leftIndex - 1] + twoSum == 0){
                    System.out.println("6  = " + nums[leftIndex - 1] + " | " + twoSum);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[leftIndex - 1]);
                    temp.add(nums[leftIndex]);
                    temp.add(nums[rightIndex]);
                    ans.add(temp);
                }
                leftIndex--;
            }else{
                if(nums[rightIndex + 1] + twoSum == 0){
                    System.out.println("7  = " + nums[rightIndex + 1] + " | " + twoSum);
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[leftIndex]);
                    temp.add(nums[rightIndex]);
                    temp.add(nums[rightIndex + 1]);
                    ans.add(temp);
                }
                rightIndex++;
            }
            System.out.println("8  = " + leftIndex + " | " + rightIndex);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] a = {-1,0, 1, 2, -1, -4};
        Test4 b = new Test4();
        List<List<Integer>> ans = b.threeSum(a);
        ans.stream().forEach(x -> {
            System.out.println("List");
            x.stream().forEach(y -> System.out.println(y));
        });
        char m = 'A';
        int m1 = m;
        System.out.println(m1);
    }
}
