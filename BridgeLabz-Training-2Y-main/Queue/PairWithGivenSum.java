import java.util.HashMap;
import java.util.Map;

/**
 * Problem 7: Check for a Pair with Given Sum in an Array
 * Given an array and a target sum, find if there exists a pair of elements
 * whose sum equals the target. Print the pair if found.
 *
 * Approach:
 * - Iterate through the array.
 * - For each element, compute complement = target - current.
 * - Check if complement already exists in the HashMap.
 * - If yes, we found a valid pair. If no, store current element in the map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        // Maps a number to its index
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (seen.containsKey(complement)) {
                System.out.println("Pair found: (" + complement + ", " + arr[i] + ")"
                        + " at indices (" + seen.get(complement) + ", " + i + ")");
                return true;
            }
            seen.put(arr[i], i);
        }

        System.out.println("No pair with sum " + target + " found.");
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {8, 7, 2, 5, 3, 1};
        int target1 = 10;
        System.out.print("Array: {8, 7, 2, 5, 3, 1}, Target: " + target1 + " => ");
        hasPairWithSum(arr1, target1); // Pair: (8, 2) or (7, 3)

        int[] arr2 = {1, 4, 45, 6, 10, 8};
        int target2 = 16;
        System.out.print("Array: {1, 4, 45, 6, 10, 8}, Target: " + target2 + " => ");
        hasPairWithSum(arr2, target2); // Pair: (6, 10)

        int[] arr3 = {1, 2, 3, 4, 5};
        int target3 = 20;
        System.out.print("Array: {1, 2, 3, 4, 5}, Target: " + target3 + " => ");
        hasPairWithSum(arr3, target3); // No pair
    }
}
