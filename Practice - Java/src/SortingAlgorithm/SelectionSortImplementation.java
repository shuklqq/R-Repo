package SortingAlgorithm;

public class SelectionSortImplementation {
    public int[] selectionSort(int[] arr){
        for(int a = 0 ; a < arr.length ; a++){
            int max_index = 0;
            int b = 0;
            while(b < arr.length - a){
                if(arr[b] > arr[max_index]){
                    max_index = b;
                }
                b++;
            }
            b--;
            if(max_index != b){
                int temp = arr[max_index];
                arr[max_index] = arr[b];
                arr[b] = temp;
            }

        }
        return arr;
    }

}
