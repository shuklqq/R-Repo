public class LongestSubArrayOfOnesAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int a = 0, b = a+1, maxLength = 0;
        int counter = 1;
        if(nums[a]==0){
            nums[a] = 2;
            counter--;
        }
        while(b < nums.length){
            if(nums[b] == 1){
                b++;
            }else{
                if(counter == 1){
                    nums[b] = 2;
                    counter--;
                    b++;
                }else{
                    if(nums[a] == 2){
                        nums[a] = 0;
                        a++;
                        counter++;
                    } else if (nums[a] == 1) {
                        a++;
                    }
                }
            }
            maxLength = Math.max(maxLength, b-a);
        }
        return maxLength-1;
    }
}
