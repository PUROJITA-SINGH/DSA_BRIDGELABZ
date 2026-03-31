import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem 4: Sliding Window Maximum
 * Given an array and a window size k, find the maximum element in each
 * sliding window of size k.
 *
 * Approach:
 * - Use a Deque to store indices of useful elements (in decreasing order of value).
 * - Remove indices that are out of the current window from the front.
 * - Remove smaller elements from the back (they can never be the max).
 * - The front of the deque always holds the index of the current window's max.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Remove indices outside the current window from the front
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove indices of smaller elements from the back
            // (they won't be maximum for any future window)
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Start recording results once the first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Window size k = " + k);
        System.out.println("Max in each window: " + Arrays.toString(maxSlidingWindow(nums, k)));
        // Expected: [3, 3, 5, 5, 6, 7]

        // Another test
        int[] nums2 = {2, 1, 5, 3, 6, 4, 8, 7};
        int k2 = 4;
        System.out.println("\nArray: " + Arrays.toString(nums2));
        System.out.println("Window size k = " + k2);
        System.out.println("Max in each window: " + Arrays.toString(maxSlidingWindow(nums2, k2)));
        // Expected: [5, 6, 6, 8, 8]
    }
}
