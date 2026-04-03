package SortingAlgorithm;


public class BubbleSortImplementation {
    public int[] bubbleSort(int[] arr){
        for(int a = 0 ; a < arr.length - 1; a++){
            for(int b = 0 ; b < arr.length - 1 - a ; b++){
                if(arr[b] > arr[b+1]){
                    int temp = arr[b];
                    arr[b] = arr[b+1];
                    arr[b+1] = temp;
                }
            }
        }
        return arr;
    }
}
