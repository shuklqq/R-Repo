package StringAndArray;

public class TwoSum2 {
    //    public int[] twoSum(int[] numbers, int target) {
//        int[] ans = new int[2];
//        int a = 0;
//        int b = 1;
//        while(a < b){
//            if(numbers[a] + numbers[b] == target){
//                ans[0] = a+1;
//                ans[1] = b+1;
//                return ans;
//            }
//            if(numbers[a] + numbers[b] < target){
//                if(b < numbers.length-1){
//                    b++;
//                    if(numbers[a] + numbers[b] > target){
//                        b--;
//                        a++;
//                    }
//                }else{
//                    a++;
//                }
//            } else if (numbers[a] + numbers[b] > target) {
//                b--;
//            }
//        }
//        return ans;
//    }
    public int[] twoSum(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (true) {
            int currentSum = nums[start] + nums[end];

            if (currentSum == target) {
                return new int[]{start + 1, end + 1};
            }

            int middle = (start + end) / 2;

            if (currentSum < target) {
                if (nums[middle] + nums[end] < target) {
                    start = middle;
                } else {
                    ++start;
                }
            } else {
                if (nums[middle] + nums[start] > target) {
                    end = middle;
                } else {
                    --end;
                }
            }
        }
    }
}
