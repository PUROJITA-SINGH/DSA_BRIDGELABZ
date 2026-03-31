import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem 6: Find All Subarrays with Zero Sum
 * Given an array, find all subarrays whose elements sum up to zero.
 *
 * Approach:
 * - Maintain a cumulative (prefix) sum as we iterate.
 * - Use a HashMap to store each cumulative sum and all indices where it occurred.
 * - If the same cumulative sum appears at index i and j (i < j), then the
 *   subarray from i+1 to j has a sum of zero.
 * - Also, if the cumulative sum itself is 0 at index j, then the subarray
 *   from index 0 to j sums to zero.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SubarraysWithZeroSum {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        // Map from cumulative sum -> list of indices where it occurred
        Map<Integer, List<Integer>> sumIndexMap = new HashMap<>();

        // -1 represents a virtual index before the array starts
        sumIndexMap.computeIfAbsent(0, k -> new ArrayList<>()).add(-1);

        int cumSum = 0;
        for (int j = 0; j < arr.length; j++) {
            cumSum += arr[j];

            if (sumIndexMap.containsKey(cumSum)) {
                // Every previous index with the same cumulative sum gives a zero-sum subarray
                for (int i : sumIndexMap.get(cumSum)) {
                    result.add(new int[]{i + 1, j}); // subarray from i+1 to j (inclusive)
                }
            }

            sumIndexMap.computeIfAbsent(cumSum, k -> new ArrayList<>()).add(j);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays (start index, end index):");
        for (int[] pair : subarrays) {
            System.out.print("  [" + pair[0] + ", " + pair[1] + "] => { ");
            for (int k = pair[0]; k <= pair[1]; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println("}");
        }

        // Simple test
        System.out.println("\nSimple test: {1, 2, -3, 4, -4}");
        int[] arr2 = {1, 2, -3, 4, -4};
        List<int[]> result2 = findZeroSumSubarrays(arr2);
        for (int[] pair : result2) {
            System.out.print("  [" + pair[0] + ", " + pair[1] + "] => { ");
            for (int k = pair[0]; k <= pair[1]; k++) {
                System.out.print(arr2[k] + " ");
            }
            System.out.println("}");
        }
    }
}
