package String;

import java.util.Arrays;

/*

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109

 */
public class LargestNumber {
    /*

    Approach 1 : Convert integer in integer array to string. create a custom comparator for comparing while
                sorting the strings and then append them using a string builder.
        Complexity Analysis :
            Time Complexity : the time complexity is dominated by the sorting step:
                O(n⋅k⋅logn) where: n is the length of the nums array. k is the average length of the numbers
                converted to strings.
            Space Complexity :
                String Array:
                    The str array stores each number as a string, giving a space complexity of O(n⋅k).
                StringBuilder: strBuilder also requires O(n⋅k) space to store the final result.
                Thus, the overall space complexity is  O(n⋅k).

     */
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int a = 0; a < nums.length; a++) {
            str[a] = String.valueOf(nums[a]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        if (str[0].equals("0")) {
            return "0";
        }
        StringBuilder strBuilder = new StringBuilder();
        for (String s : str) {
            strBuilder.append(s);
        }
        return strBuilder.toString();
    }
    /*

    Approach 2 : Quick Sort for sorting in a custom way.
     */
    /*
    class Solution {

    public String largestNumber(int[] nums) {
        // Sort the numbers using Quick Sort
        quickSort(nums, 0, nums.length - 1);
        // Concatenate sorted numbers to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (int num : nums) {
            largestNum.append(num);
        }
        // Handle the case where the largest number is zero
        return largestNum.charAt(0) == '0' ? "0" : largestNum.toString();
    }

    private void quickSort(int[] nums, int left, int right) {
        // Base case: if the range has one or no elements, it is already sorted
        if (left >= right) return;
        // Partition the array and get the pivot index
        int pivotIndex = partition(nums, left, right);
        // Recursively sort the sub-arrays
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int lowIndex = left;
        // Rearrange elements so that those greater than the pivot are on the left
        for (int i = left; i < right; ++i) {
            if (compare(nums[i], pivot)) {
                swap(nums, i, lowIndex);
                ++lowIndex;
            }
        }
        // Place the pivot in its correct position
        swap(nums, lowIndex, right);
        return lowIndex;
    }

    private boolean compare(int firstNum, int secondNum) {
        // Compare concatenated strings to decide the order
        String str1 = String.valueOf(firstNum) + String.valueOf(secondNum);
        String str2 = String.valueOf(secondNum) + String.valueOf(firstNum);
        return str1.compareTo(str2) > 0;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
     */
    /*

    Approach 3 : Merge Sort
     */
    /*

    class Solution {

    public String largestNumber(int[] nums) {
        // Sort the numbers using Merge Sort
        List<Integer> sortedNums = mergeSort(nums, 0, nums.length - 1);
        // Concatenate sorted numbers to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (int num : sortedNums) {
            largestNum.append(num);
        }
        // Handle the case where the largest number is zero
        return largestNum.charAt(0) == '0' ? "0" : largestNum.toString();
    }

    private List<Integer> mergeSort(int[] nums, int left, int right) {
        // Base case: a single element is already sorted
        if (left >= right) return List.of(nums[left]);
        int mid = left + (right - left) / 2;
        // Recursively sort the left and right halves
        List<Integer> leftHalf = mergeSort(nums, left, mid);
        List<Integer> rightHalf = mergeSort(nums, mid + 1, right);
        // Merge the sorted halves
        return merge(leftHalf, rightHalf);
    }

    private List<Integer> merge(
        List<Integer> leftHalf,
        List<Integer> rightHalf
    ) {
        List<Integer> sortedNums = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;
        // Merge the two halves based on custom comparison
        while (leftIndex < leftHalf.size() && rightIndex < rightHalf.size()) {
            if (compare(leftHalf.get(leftIndex), rightHalf.get(rightIndex))) {
                sortedNums.add(leftHalf.get(leftIndex++));
            } else {
                sortedNums.add(rightHalf.get(rightIndex++));
            }
        }
        // Append remaining elements from left half
        while (leftIndex < leftHalf.size()) sortedNums.add(
            leftHalf.get(leftIndex++)
        );
        // Append remaining elements from right half
        while (rightIndex < rightHalf.size()) sortedNums.add(
            rightHalf.get(rightIndex++)
        );
        return sortedNums;
    }

    private boolean compare(int firstNum, int secondNum) {
        // Compare concatenated strings to decide the order
        String s1 = String.valueOf(firstNum) + String.valueOf(secondNum);
        String s2 = String.valueOf(secondNum) + String.valueOf(firstNum);
        return s1.compareTo(s2) > 0;
    }
}
     */
    /*

    Approach 4 : TimSort - this is the sorting algorithm that Java uses internally for sorting.
        It is a hybrid of Merge Sort and Insertion sort and usually gives best average complexity for
        real life use cases.
     */
    /*

    class Solution {

    private static final int RUN = 32;

    public String largestNumber(int[] nums) {
        // Convert int array to Integer array for custom sorting
        Integer[] numsArray = Arrays.stream(nums)
            .boxed()
            .toArray(Integer[]::new);
        // Sort the numbers using custom Tim Sort
        timSort(numsArray);
        // Concatenate sorted numbers to form the largest number
        StringBuilder largestNum = new StringBuilder();
        for (int num : numsArray) {
            largestNum.append(num);
        }
        // Handle the case where the largest number is zero
        return largestNum.charAt(0) == '0' ? "0" : largestNum.toString();
    }

    private void insertionSort(Integer[] nums, int left, int right) {
        for (int i = left + 1; i <= right; ++i) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= left && compare(temp, nums[j])) {
                nums[j + 1] = nums[j];
                --j;
            }
            nums[j + 1] = temp;
        }
    }

    private void merge(Integer[] nums, int left, int mid, int right) {
        Integer[] leftArr = Arrays.copyOfRange(nums, left, mid + 1);
        Integer[] rightArr = Arrays.copyOfRange(nums, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (compare(leftArr[i], rightArr[j])) {
                nums[k++] = leftArr[i++];
            } else {
                nums[k++] = rightArr[j++];
            }
        }
        while (i < leftArr.length) nums[k++] = leftArr[i++];
        while (j < rightArr.length) nums[k++] = rightArr[j++];
    }

    private void timSort(Integer[] nums) {
        int n = nums.length;
        // Sort small runs with insertion sort
        for (int i = 0; i < n; i += RUN) {
            insertionSort(nums, i, Math.min(i + RUN - 1, n - 1));
        }
        // Merge sorted runs
        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                if (mid < right) {
                    merge(nums, left, mid, right);
                }
            }
        }
    }

    private boolean compare(int firstNum, int secondNum) {
        String firstStr = Integer.toString(firstNum);
        String secondStr = Integer.toString(secondNum);
        return (firstStr + secondStr).compareTo(secondStr + firstStr) > 0;
    }
}
     */
    /*
    Approach 5 : heap Sort - here we use a maxHeap which is created and while polling, the sorted
            version is generated according to the custom comparator.
     */
    /*
    class Solution {

    public String largestNumber(int[] nums) {
        // Priority queue to order numbers using the custom comparison function
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
            new Comparator<String>() {
                @Override
                public int compare(String first, String second) {
                    return (second + first).compareTo(first + second);
                }
            }
        );

        int totalLength = 0;

        // Convert integers to strings and push them into the priority queue
        for (int num : nums) {
            String strNum = Integer.toString(num);
            totalLength += strNum.length();
            maxHeap.offer(strNum);
        }

        // Build the result string from the priority queue
        StringBuilder result = new StringBuilder(totalLength);
        while (!maxHeap.isEmpty()) {
            result.append(maxHeap.poll());
        }

        // Handle edge case where the result might be "000...0"
        return result.charAt(0) == '0' ? "0" : result.toString();
    }
}

     */
}
