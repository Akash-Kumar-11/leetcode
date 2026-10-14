class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // Edge case: Since 9 is the max digit, the absolute highest sum possible 
        // with 'num' digits is 9 * num. If the required sum is larger, it's impossible.
        if (sum > 9 * num) {
            return "";
        }

        int nine = sum / 9;
        int remain = sum % 9;
        
        // Use StringBuilder for efficient O(num) string building
        StringBuilder result = new StringBuilder(num);
        
        // 1. Add as many '9's as possible at the front
        for (int i = 0; i < nine; i++) {
            result.append('9');
        }
        
        // 2. Add the leftover remainder digit (if any)
        if (remain > 0) {
            result.append(remain);
        }
        
        // 3. Fill the remaining digit slots with zeros
        while (result.length() < num) {
            result.append('0');
        }
        
        return result.toString();
    }
}
