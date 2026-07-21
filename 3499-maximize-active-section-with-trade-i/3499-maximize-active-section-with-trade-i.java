class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int totalOnes = 0;
        int maxMergedZeros = 0;
        int prevZero = Integer.MIN_VALUE;
        
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int blockSize = j - i;
            
            if (s.charAt(i) == '1') {
                totalOnes += blockSize;
            } else {
                if (prevZero != Integer.MIN_VALUE) {
                    maxMergedZeros = Math.max(maxMergedZeros, prevZero + blockSize);
                }
                prevZero = blockSize;
            }
            
            i = j;
        }
        
        return totalOnes + maxMergedZeros;
    }
}
