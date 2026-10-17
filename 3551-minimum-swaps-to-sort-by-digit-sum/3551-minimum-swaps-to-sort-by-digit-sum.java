import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Create an array of boxed Integers to easily sort with a custom comparator
        Integer[] sortedNums = new Integer[n];
        for (int i = 0; i < n; i++) {
            sortedNums[i] = nums[i];
        }
        
        // Sort based on custom rules: 1st by Digit Sum, 2nd by numeric value
        Arrays.sort(sortedNums, (a, b) -> {
            int sumA = getDigitSum(a);
            int sumB = getDigitSum(b);
            if (sumA != sumB) {
                return Integer.compare(sumA, sumB);
            }
            return Integer.compare(a, b);
        });
        
        // Map each number to its target index in the sorted array
        Map<Integer, Integer> targetIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetIndexMap.put(sortedNums[i], i);
        }
        
        // Use cycle decomposition to find the minimum number of swaps
        boolean[] visited = new boolean[n];
        int totalSwaps = 0;
        
        for (int i = 0; i < n; i++) {
            // Skip if the element is already visited or already in its correct spot
            if (visited[i] || targetIndexMap.get(nums[i]) == i) {
                continue;
            }
            
            // Traverse the cycle
            int cycleSize = 0;
            int currentIdx = i;
            
            while (!visited[currentIdx]) {
                visited[currentIdx] = true;
                // Move to the index where the current element belongs
                currentIdx = targetIndexMap.get(nums[currentIdx]);
                cycleSize++;
            }
            
            // A cycle of size k contributes (k - 1) swaps
            if (cycleSize > 0) {
                totalSwaps += (cycleSize - 1);
            }
        }
        
        return totalSwaps;
    }
    
    // Helper method to compute the sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
