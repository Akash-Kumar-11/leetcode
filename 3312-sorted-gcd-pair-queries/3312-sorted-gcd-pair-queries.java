class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        long[] gcdPairsCount = new long[maxVal + 1];
        for (int i = maxVal; i >= 1; i--) {
            long totalMultiples = 0;
            for (int j = i; j <= maxVal; j += i) {
                totalMultiples += freq[j];
            }
            
            long possiblePairs = (totalMultiples * (totalMultiples - 1)) / 2;
            for (int j = 2 * i; j <= maxVal; j += i) {
                possiblePairs -= gcdPairsCount[j];
            }
            gcdPairsCount[i] = possiblePairs;
        }

        for (int i = 1; i <= maxVal; i++) {
            gcdPairsCount[i] += gcdPairsCount[i - 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long targetIndex = queries[i];
            int low = 1, high = maxVal;
            int finalGcd = maxVal;
            
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (gcdPairsCount[mid] > targetIndex) {
                    finalGcd = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            ans[i] = finalGcd;
        }

        return ans;
    }
}
