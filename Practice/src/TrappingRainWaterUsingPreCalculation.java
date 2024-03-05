public class TrappingRainWaterUsingPreCalculation {
    static long Trap(int arr[], int n){
        int left[] = new int[n];
        int right[] = new int[n];
        int max1 = 0;
        int max2 = 0;
        long sum = 0;

        for(int i = 0, j = n-1  ; i < n  ; i++ , j--){
            left[i] = Math.max(max1, arr[i]);
            max1 = left[i];
            right[j] = Math.max(max2, arr[j]);
            max2 = right[j];
        }
        for(int k = 0; k < n; k++){
            sum = sum + (Math.min(left[k],right[k]) - arr[k]);
        }
        return sum;
    }
    static void InvokeStart(){
        int[] arr = {3,0,0,2,0,4};
        int len = arr.length;

        System.out.println("Total water amount saved: "+ Trap(arr,len));
    }
}
