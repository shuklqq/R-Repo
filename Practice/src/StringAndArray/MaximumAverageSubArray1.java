package StringAndArray;

import java.util.Arrays;
import java.util.Map;

public class MaximumAverageSubArray1 {
    public double findMaxAverage(int[] nums, int k){
        int sum = 0;
        double average = 0.0;
        for(int b = 0; b < k ; b++){
            sum += nums[b];
            System.out.println("sum: " + sum);
        }
        average = (double)sum/(double)k;
        System.out.println("Average outside : " + average);
        for(int a = 1 ; a <= nums.length - k ; a++){
            sum = sum - nums[a -1];
            sum = sum + nums[a + k -1];
            average = Math.max(average , ((double)sum/(double)k));
            System.out.println("Average inside : " + a + " : " + average);

        }
        return average;
    }
}
