package StringAndArray;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            if(nums[left] == val){
                if(nums[right] != val){
                    int a = nums[right];
                    nums[right] = nums[left];
                    nums[left] = a;
                    left++;
                    right--;
                    count--;
                }else{
                    right--;
                    count--;
                }
            }else{
                left++;
            }
        }
        return count;
    }
}
