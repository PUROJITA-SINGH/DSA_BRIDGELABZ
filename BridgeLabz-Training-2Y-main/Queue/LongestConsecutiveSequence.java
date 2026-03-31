import java.util.HashSet;
import java.util.Set;

/**
 * Problem 8: Longest Consecutive Sequence
 * Given an unsorted array of integers, find the length of the longest
 * sequence of consecutive numbers (e.g., 1, 2, 3, 4 has length 4).
 *
 * Approach:
 * - Put all elements in a HashSet for O(1) lookup.
 * - For each number, check if it is the START of a sequence
 *   (i.e., num - 1 is NOT in the set).
 * - If it is a start, expand the sequence forward and track the length.
 * - Keep track of the maximum length seen.
 *
 * Time Complexity: O(n)  — each element is visited at most twice
 * Space Complexity: O(n)
 */
public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;
        int bestStart = Integer.MIN_VALUE;

        for (int num : numSet) {
            // Only start counting if num is the beginning of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    bestStart = num;
                }
            }
        }

        // Print the actual sequence
        System.out.print("Longest sequence: ");
        for (int i = bestStart; i < bestStart + maxLength; i++) {
            System.out.print(i + (i < bestStart + maxLength - 1 ? " -> " : ""));
        }
        System.out.println();

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Array: {100, 4, 200, 1, 3, 2}");
        System.out.println("Length: " + longestConsecutive(arr1)); // Expected: 4 (1,2,3,4)

        System.out.println();

        int[] arr2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Array: {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}");
        System.out.println("Length: " + longestConsecutive(arr2)); // Expected: 9 (0-8)
    }
}
