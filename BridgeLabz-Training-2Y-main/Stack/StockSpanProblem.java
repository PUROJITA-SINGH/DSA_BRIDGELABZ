import java.util.Arrays;
import java.util.Stack;

/**
 * Problem 3: Stock Span Problem
 * For each day in a stock price array, calculate the span — the number of
 * consecutive days (including today) for which the stock price was less than
 * or equal to today's price.
 *
 * Approach:
 * - Use a stack to store indices of days in decreasing price order.
 * - For each day, pop indices from the stack while the price at those
 *   indices is <= current price.
 * - The span is (current index - index of the last greater price element).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class StockSpanProblem {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Pop elements from the stack while stack top price <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            // If stack is empty, all previous prices were <= current price
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = calculateSpan(prices);

        System.out.println("Stock Prices: " + Arrays.toString(prices));
        System.out.println("Span Values:  " + Arrays.toString(result));
        // Expected:        [1,   1,  1,  2,  1,  4,  6]
    }
}
