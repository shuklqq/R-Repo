package SortingAlgorithm;

public class InsertionSortImplementation {
    public int[] insertionSort(int[] arr){
        for(int a = 1 ; a < arr.length ; a++){
            int b = a;
            while(b >= 1 && arr[b] < arr[b-1]){
                int temp = arr[b];
                arr[b] = arr[b-1];
                arr[b-1] = temp;
                b--;
            }
        }
        return arr;
    }
}
