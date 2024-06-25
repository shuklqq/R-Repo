import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MaxNumberOfKSumPairs {
    public int maxOperation(int[] nums, int k){
//        int count = 0;
//        int a = 0;
//        int finalcounter = 0;
//        while(a < nums.length){
//            int counter = 0;
//            if(nums[a] < k && nums[a] != 0){
//                int b = a + 1;
//                while(b < nums.length && counter==0){
//                    if(nums[b] != 0){
//                        if(nums[a] + nums[b] == k){
//                            nums[a] = 0;
//                            nums[b] = 0;
//                            counter++;
//                            finalcounter++;
//                        }
//                    }
//                    b++;
//                }
//            }
//            a++;
//        }
//        return finalcounter;

        Arrays.sort(nums);
        int a = 0;
        int b = nums.length -1;
        int finalCounter = 0;
        while(nums[b] > k && b > a){
            b--;
        }
        while(a < b){
            if(nums[a] != 0 && nums[b] != 0){
                int sum = nums[a] + nums[b];
                if(sum > k){
                    b--;
                } else if (sum < k) {
                    a++;
                } else {
                    nums[a] = nums[b] = 0;
                    finalCounter++;
                }
            }
            if(nums[a] == 0){
                a++;
            }
            if(nums[b] == 0){
                b--;
            }
        }
        return finalCounter;
    }
}
