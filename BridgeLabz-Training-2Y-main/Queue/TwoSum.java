import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem 10: Two Sum Problem
 * Given an array and a target sum, find the indices of two elements
 * such that their values add up to the target. Each input has exactly one solution.
 *
 * Approach:
 * - Use a HashMap to store each element and its index as we iterate.
 * - For each element, compute complement = target - current.
 * - If complement already exists in the map, return [map.get(complement), i].
 * - Otherwise, store current element with its index in the map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Maps element value -> its index
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {
                return new int[]{indexMap.get(complement), i};
            }

            indexMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two-sum solution found for target: " + target);
    }

    public static void main(String[] args) {
        // Test 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Array: " + Arrays.toString(nums1) + ", Target: " + target1);
        System.out.println("Indices: " + Arrays.toString(result1));
        System.out.println("Values:  " + nums1[result1[0]] + " + " + nums1[result1[1]] + " = " + target1);
        // Expected: [0, 1]

        System.out.println();

        // Test 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Array: " + Arrays.toString(nums2) + ", Target: " + target2);
        System.out.println("Indices: " + Arrays.toString(result2));
        System.out.println("Values:  " + nums2[result2[0]] + " + " + nums2[result2[1]] + " = " + target2);
        // Expected: [1, 2]

        System.out.println();

        // Test 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Array: " + Arrays.toString(nums3) + ", Target: " + target3);
        System.out.println("Indices: " + Arrays.toString(result3));
        System.out.println("Values:  " + nums3[result3[0]] + " + " + nums3[result3[1]] + " = " + target3);
        // Expected: [0, 1]
    }
}
