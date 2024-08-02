package SortingAlgorithm;

public class QuickSortImplementation {
    public void sort(int[] arr, int leftIndex, int rightIndex){
        int rightIndexTemp = rightIndex;
        if(leftIndex >= rightIndex){
            return;
        }
        int pivotIndex = rightIndex;
        rightIndex--;
        while(leftIndex <= rightIndex){
            if(arr[leftIndex] >= arr[pivotIndex]){
                if(arr[rightIndex] <= arr[pivotIndex]){
                    int temp = arr[leftIndex];
                    arr[leftIndex] = arr[rightIndex];
                    arr[rightIndex] = temp;
                    leftIndex++;
                }else{
                    rightIndex--;
                }
            }else{
                leftIndex++;
            }
        }
        int temp = arr[leftIndex];
        arr[leftIndex] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        sort(arr, 0, leftIndex-1);
        sort(arr, leftIndex+1, rightIndexTemp);
        return;
    }
}
