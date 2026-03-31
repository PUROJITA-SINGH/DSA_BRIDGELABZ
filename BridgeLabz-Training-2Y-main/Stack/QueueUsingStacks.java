import java.util.Stack;

/**
 * Problem 1: Implement a Queue Using Stacks
 * Design a queue using two stacks such that enqueue and dequeue
 * operations are performed efficiently.
 *
 * Approach:
 * - stack1 is used for enqueue (push)
 * - stack2 is used for dequeue (pop/peek)
 * - Transfer elements from stack1 to stack2 only when stack2 is empty
 *
 * Time Complexity: Enqueue O(1), Dequeue Amortized O(1)
 * Space Complexity: O(n)
 */
public class QueueUsingStacks {

    private Stack<Integer> stack1; // for enqueue
    private Stack<Integer> stack2; // for dequeue

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element to the back of the queue
    public void enqueue(int val) {
        stack1.push(val);
    }

    // Remove element from the front of the queue
    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");
        transferIfNeeded();
        return stack2.pop();
    }

    // Peek at the front element without removing it
    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty!");
        transferIfNeeded();
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Transfer all elements from stack1 to stack2 only if stack2 is empty
    private void transferIfNeeded() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Peek: " + q.peek());       // 10
        System.out.println("Dequeue: " + q.dequeue()); // 10
        System.out.println("Dequeue: " + q.dequeue()); // 20

        q.enqueue(40);
        System.out.println("Dequeue: " + q.dequeue()); // 30
        System.out.println("Dequeue: " + q.dequeue()); // 40
        System.out.println("Is Empty: " + q.isEmpty()); // true
    }
}
