/**
 * Problem 5: Circular Tour Problem
 * Given a set of petrol pumps where each pump has petrol[i] litres of petrol
 * and distance[i] to the next pump, find the starting pump index from which
 * a truck can complete the circular tour.
 *
 * Approach:
 * - Track the current surplus (petrol - distance) as we traverse.
 * - If the surplus goes negative at pump i, reset the starting point to i+1
 *   and reset the current surplus to 0.
 * - Track total surplus; if total >= 0, a valid start exists.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class CircularTourProblem {

    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int totalSurplus = 0;
        int currentSurplus = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int net = pumps[i].petrol - pumps[i].distance;
            currentSurplus += net;
            totalSurplus += net;

            // If current surplus is negative, this starting point won't work
            // Reset start to the next pump
            if (currentSurplus < 0) {
                start = i + 1;
                currentSurplus = 0;
            }
        }

        // If total surplus >= 0, start is valid; else no solution exists
        return totalSurplus >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int result = findStartingPoint(pumps);
        if (result == -1) {
            System.out.println("No valid starting point exists.");
        } else {
            System.out.println("Start the tour from pump index: " + result);
            // Expected: 1 (0-indexed), i.e., start at pump with petrol=6
        }

        // Test case with no solution
        PetrolPump[] pumps2 = {
            new PetrolPump(1, 5),
            new PetrolPump(1, 5),
            new PetrolPump(1, 5)
        };
        System.out.println("Result for impossible case: " + findStartingPoint(pumps2));
        // Expected: -1
    }
}
