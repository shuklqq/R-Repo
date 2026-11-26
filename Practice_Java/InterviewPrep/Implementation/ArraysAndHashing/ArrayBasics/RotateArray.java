package InterviewPrep.Implementation.ArraysAndHashing.ArrayBasics;
/*
You are given an array of integers nums and a whole number k. Rotate the array to the right by k steps and return it.

One step moves every element one position to the right, and the last element wraps around to the front. So after one step, [1, 2, 3, 4] becomes [4, 1, 2, 3].

Do it in place: change nums itself and use only O(1) extra memory.

Example 1
Input: nums = [3, 8, -1, 6, 2, 9], k = 2

Output: [2,9,3,8,-1,6]
Explanation: The last two elements, 2 and 9, wrap around to the front and keep their order. The other four move two places to the right.

Example 2
Input: nums = [5, -7, 0, 4], k = 10

Output: [0,4,5,-7]
Explanation: Four steps bring a four-element array back to where it started, so ten steps end in the same place as two steps.

Example 3
Input: nums = [1000000000, -1000000000, 7], k = 3

Output: [1000000000,-1000000000,7]
Explanation: Three steps move every element of a three-element array all the way round, back to its start.

✦
Check your understanding
Work out the answer for this input before you write any code.

1
2
nums = [1, 2, 3, 4, 5], k = 2

[4,5,1,2,3]

[3,4,5,1,2]

[2,1,5,4,3]

[5,4,1,2,3]
Constraints
1 ≤ nums.length ≤ 105
-109 ≤ nums[i] ≤ 109
0 ≤ k ≤ 109
Clarifying questions
What you would ask an interviewer before writing any code.


Which way is to the right?

Can k be larger than the length of the array?

Can k be 0?

Can I build a new array and return that?

Can values repeat or be negative?
Hints

Hint 1
Rotating by one step is easy: save the last element, shift everything else one place right, and put the saved element at the front. Doing that k times is far too slow when k is large.

Hint 2
Rotating an array of length n by n steps changes nothing. How many steps do you really need for any k?

Hint 3
After the rotation, the last k mod n elements sit at the front and the rest follow. Each of those two blocks keeps its order. Can reversals produce that?

Hint 4
Reverse the whole array. The two blocks are now in the right places, but each one is backwards. Reverse each block on its own.
Interview follow-ups

Rotate the array to the left by k steps instead. What changes?

Rotate in place by moving each element exactly once, following where it has to go. How many separate cycles does that walk make?

Rotate a singly linked list to the right by k places.

Given two arrays, decide whether one is a rotation of the other.

Topics
Array
Two Pointers
Math
*/
public class RotateArray {
    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        int steps = k % n;

        reverseRange(nums, 0, n-1);
        reverseRange(nums, 0, steps - 1);
        reverseRange(nums, steps, n - 1);
        return nums;
    }
    private void reverseRange(int[] nums, int left, int right){
        while (left < right) {
            int held = nums[left];
            nums[left] = nums[right];
            nums[right] = held;
            left++;
            right--;
        }
    }
}
