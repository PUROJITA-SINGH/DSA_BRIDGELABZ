/**
 * Problem 9: Implement a Custom Hash Map
 * Design and implement a basic HashMap class with operations for
 * insertion, deletion, and retrieval.
 *
 * Approach:
 * - Use an array of LinkedList buckets (separate chaining for collision handling).
 * - A hash function maps keys to bucket indices.
 * - Each bucket stores key-value pairs as nodes in a linked list.
 *
 * Time Complexity: Average O(1) for get/put/remove; O(n) worst case (all in one bucket)
 * Space Complexity: O(n)
 */
public class CustomHashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    // Node for the linked list in each bucket
    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size;

    public CustomHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    // Hash function: maps key to a bucket index
    private int hash(int key) {
        return Math.abs(key) % buckets.length;
    }

    // Insert or update a key-value pair
    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        // Check if key already exists — update the value
        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        // Key not found — insert new node at the head of the chain
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
        size++;
    }

    // Retrieve a value by key; returns -1 if not found
    public int get(int key) {
        int index = hash(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }
        return -1; // Key not found
    }

    // Remove a key-value pair; returns true if removed, false if not found
    public boolean remove(int key) {
        int index = hash(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    buckets[index] = current.next; // Remove head
                } else {
                    prev.next = current.next;      // Bypass the node
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false; // Key not found
    }

    public boolean containsKey(int key) {
        return get(key) != -1;
    }

    public int size() {
        return size;
    }

    // Print the state of the hash map
    public void display() {
        System.out.println("HashMap (size=" + size + "):");
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("  Bucket[" + i + "]: ");
                Node current = buckets[i];
                while (current != null) {
                    System.out.print("[" + current.key + "=" + current.value + "]");
                    if (current.next != null) System.out.print(" -> ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(17, 1700); // Same bucket as key=1 (17 % 16 = 1) -> collision!
        map.put(3, 300);

        map.display();

        System.out.println("\nget(1) = " + map.get(1));   // 100
        System.out.println("get(17) = " + map.get(17));  // 1700 (collision handled)
        System.out.println("get(5) = " + map.get(5));    // -1 (not found)

        // Update
        map.put(1, 999);
        System.out.println("After update, get(1) = " + map.get(1)); // 999

        // Remove
        System.out.println("\nremove(2): " + map.remove(2)); // true
        System.out.println("remove(99): " + map.remove(99)); // false
        System.out.println("get(2) after removal = " + map.get(2)); // -1

        map.display();
    }
}
