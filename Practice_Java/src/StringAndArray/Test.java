package StringAndArray;

public class Test {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int a = m - 1;
//        int b = n - 1;
//        int c = m + n - 1;
//        while( a>=0 && b >= 0){
//            if(nums1[a] > nums2[b]){
//                nums1[c] = nums1[a];
//                a--;
//                c--;
//            }else{
//                nums1[c] = nums2[b];
//                b--;
//                c--;
//            }
//        }
//        while(a >= 0){
//            nums1[c] = nums1[a];
//            a--;
//            c--;
//        }
//        while(b >= 0){
//            nums1[c] = nums2[b];
//            b--;
//            c--;
//        }
//    }

//    public int removeDuplicates(int[] nums) {
//        if(nums.length == 0){
//            return 0;
//        }
//        if(nums.length == 1){
//            return 1;
//        }
//        if(nums.length == 2){
//            if(nums[0] == nums[1]){
//                return 1;
//            }else{
//                return 2;
//            }
//        }
//        int k = 2
//                ;
//        for(int a = 2 ; a < nums.length ; a++){
//            System.out.println(nums[a] + " " + nums[a-1] + " " + nums[a-2]);
//            if(nums[a] != nums[k-1]){
//                nums[k] = nums[a];
//                k++;
//            }else{
//                if(nums[a] != nums[k-2]){
//                    nums[k] = nums[a];
//                    k++;
//                }
//            }
//        }
//        return k;
//    }

    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] arr = s.trim().split("\\s+");
        for(int x = arr.length - 1; x >= 0 ; x--){
            ans.append(arr[x]);
            if(x > 0) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
