package StringAndArray;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3)
        {
            return false;
        }
        Integer i = null;
        Integer j = null;
        Integer k = null;
        Integer temp1 = null;
        Integer temp2 = null;

        for (int a = nums.length - 1; a >= 0; a--) {
            if (k == null) {
                k = nums[a];
                System.out.println("K : " + k + " nums " + a + " : " + nums[a]);
            } else {
                if (j == null) {
                    if (nums[a] > k) {
                        k = nums[a];
                        System.out.println("K : " + k + " nums " + a + " : " + nums[a]);
                    } else if (nums[a] < k) {
                        j = nums[a];
                        System.out.println("J : " + j + " nums " + a + " : " + nums[a]);
                    }
                } else {
                    if (i == null) {
                        if (nums[a] < j) {
                            i = nums[a];
                            System.out.println("I : " + i + " nums " + a + " : " + nums[a]);
                        } else if (nums[a] > j && nums[a] < k) {
                            j = nums[a];
                            System.out.println("J : " + j + " nums " + a + " : " + nums[a]);
                        }
                        if (temp1 == null) {
                            if (nums[a] > k) {
                                temp1 = nums[a];
                                System.out.println("Temp1 : " + temp1 + " nums " + a + " : " + nums[a]);
                            }
                        } else {
                            if (nums[a] < temp1 && temp2 == null) {
                                temp2 = nums[a];
                                System.out.println("Temp2 : " + temp2 + " nums " + a + " : " + nums[a]);
                            } else if (nums[a] < temp2) {
                                i = nums[a];
                                System.out.println("Temp2 : " + temp2 + " nums " + a + " : " + nums[a]);
                            }
                        }
                    }
                }
            }
        }
        return i != null;
    }
}
