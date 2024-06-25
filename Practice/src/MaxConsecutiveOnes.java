public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int counterForK = k;
        int a = 0, b = 1;
        int leftIndex = a, rightIndex = b;
        while (nums[a] == 0) {
            if (counterForK > 0) {
                nums[a] = 2;
                counterForK--;
                System.out.println("1 st - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
            } else {
                a++;
                b++;
                if (a >= nums.length) {
                    return 0;
                }
                System.out.println("1.5 st - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
            }
        }
        while (b < nums.length) {

            if (nums[b] == 1) {
                b++;
                System.out.println("2nd - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
            } else {
                if (counterForK > 0) {
                    nums[b] = 2;
                    counterForK--;
                    b++;
                    System.out.println("3rd - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
                } else if (counterForK == 0) {
                    if (nums[a] == 2) {
                        nums[a] = 0;
                        a++;
                        counterForK++;
                        System.out.println("4th - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
                    } else if (a < b - 1) {
                        a++;
                        System.out.println("5th - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
                    } else if (a == b - 1) {
                        a++;
                        b++;
                        System.out.println("6th - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
                    }

                }
            }
            if (b - a >= rightIndex - leftIndex && b <= nums.length) {
                leftIndex = a;
                rightIndex = b;
                System.out.println("7th - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
            }

        }
        if(nums[leftIndex] == 0){
            leftIndex++;
        }
        System.out.println("8th - || a : " + a + "|| b : " + b + "|| counter : " + counterForK + "|| lefIndex : " + leftIndex + "|| rightIndex : " + rightIndex);
        return rightIndex - leftIndex;
    }
}
