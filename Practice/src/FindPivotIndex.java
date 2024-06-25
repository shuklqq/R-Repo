import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int leftsum = 0, rightSum = Arrays.stream(nums).sum() - nums[0];
        for(int a = 0; a < nums.length - 1; a++){
            if(leftsum == rightSum){
                return a;
            }else{
                leftsum += nums[a];
                rightSum -= nums[a+1];
            }
        }
        if(leftsum == 0){
            return nums.length - 1;
        }
        return -1;
    }
}
