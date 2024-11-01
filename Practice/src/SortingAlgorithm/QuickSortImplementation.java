package SortingAlgorithm;

import java.util.Arrays;

public class QuickSortImplementation {
    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        System.out.println(" ");
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    public static void main(String[] args){
        int[] arr = {2,5,7,3,4,5,1,15,67,22,5,23,1,99,32,35,63,29};
        QuickSortImplementation q = new QuickSortImplementation();
        q.quickSort(arr, 0, arr.length - 1);
    }
}
