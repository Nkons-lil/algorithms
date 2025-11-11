/**
 * Happy Number Implementation
 *
 * Use cases:
 * - Mathematical puzzle solving
 * - Number theory problems
 * - Loop detection in number sequences
 *
 * A happy number is defined by the following process:
 * 1. Starting with any positive integer
 * 2. Replace the number by the sum of the squares of its digits
 * 3. Repeat until the number equals 1 (happy) or loops endlessly (not happy)
 *
 * Example: 19 -> 82 -> 68 -> 100 -> 1 (happy)
 */

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isHappy(int n) {
        // Time Complexity: O(log n)
        // Space Complexity: O(log n)

        Set<Integer> visited = new HashSet<>();

        while (!visited.contains(n)) {
            visited.add(n);

            if (n == 1) {
                return true;
            }

            int currentSum = 0;
            while (n > 0) {
                int digit = n % 10;
                currentSum += digit * digit;
                n /= 10;
            }
            System.out.println(currentSum);

            n = currentSum;
        }

        return false; // Cycle detected
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 2;
        System.out.println(num + " is happy? " + solution.isHappy(num));
    }
}
