/*
There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number
of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies,
they will have the greatest number of candies among all the kids, or false otherwise.
Note that multiple kids can have the greatest number of candies.

 */

package Arrays;

public class Test{
    public boolean[] Solution(int candies[], int extraCandies){
        boolean[] ans = new boolean[candies.length];
        int max = Integer.MIN_VALUE;
        for(int a = 0 ; a < candies.length ; a++){
            if(candies[a] > max){
                max = candies[a];
            }
        }
        for(int a = 0 ; a < candies.length ; a++){
            if(candies[a]  + extraCandies >= max){
                ans[a] = true;
            }else{
                ans[a] = false;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {2,3,5,1,3};
        Test instance = new Test();
        boolean[] ans = instance.Solution(arr,3);
        for(int a = 0 ; a < ans.length ; a++){
            System.out.print(ans[a]);
        }
    }
}



//class Test {
//    private static Test instance;
//    private Test(){
//
//    }
//    public static Test getInstance(){
//        if(instance == null){
//            instance = new Test();
//        }
//        return instance;
//    }
//}
//class intanceOfTest{
//    Test a = Test.getInstance();
//}
