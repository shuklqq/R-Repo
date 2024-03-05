public class EquilibriumIndexOfAnArrayUsingArraySum {

    static int Equi(int[] arr, int len){

        int leftSum = 0;
        int rightSum = 0;

        for(int i = 0 ; i < len ; i++){
            rightSum += arr[i];
        }

        for(int i = 0 ; i < len ; i++){
            rightSum -= arr[i];
            if(rightSum == leftSum){
                return i;
            }
            leftSum +=arr[i];

        }
        return -1;
    }

    static void InvokeStart(){
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        int len = arr.length;

        System.out.println("Equilibrium index of the given array is : "+Equi(arr,len));
    }
}
