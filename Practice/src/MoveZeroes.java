public class MoveZeroes {
    public void moveZeroes(int[] nums){
        int count = 0;
        int a = 0;
        while(count<nums.length){
            if(nums[count] != 0){
                nums[a] = nums[count];
                count++;
                a++;
            }else{
                count++;
            }
        }
        while(a < nums.length){
            nums[a] = 0;
            a++;
        }
    }
}
