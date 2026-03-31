import java.util.Stack;

/**
 * Problem 2: Sort a Stack Using Recursion
 * Given a stack, sort its elements in ascending order using recursion
 * (smallest element on top).
 *
 * Approach:
 * - Pop the top element, recursively sort the remaining stack,
 *   then insert the popped element at the correct sorted position.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) — recursive call stack
 */
public class SortStackRecursion {

    // Sort the stack so smallest is on top
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);          // Sort the remaining stack
            insertSorted(stack, top);  // Insert top at correct position
        }
    }

    // Insert an element into the correct position of an already sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: stack is empty or element is greater than top
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        // Pop top, recurse, then push top back
        int top = stack.pop();
        insertSorted(stack, element);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Before sorting: " + stack);
        sortStack(stack);
        System.out.println("After sorting (top = smallest): " + stack);
        // Expected: [98, 92, 34, 31, 23, 3]  <-- 3 is at top
    }
}
