class Solution {
    public int maximumLengthSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        // Frequency array to store counts of characters 'a' through 'z'
        int[] count = new int[26];

        // Move the right pointer to expand the sliding window
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            count[rightChar - 'a']++;

            // If a character frequency exceeds 2, shrink the window from the left
            while (count[rightChar - 'a'] > 2) {
                char leftChar = s.charAt(left);
                count[leftChar - 'a']--;
                left++;
            }

            // Calculate and track the maximum valid window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
