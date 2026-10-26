class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // Fill frequency array for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Slide the window across s2
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(count1, count2)) return true;

            // Remove the left character of the window and add the next right character
            count2[s2.charAt(i) - 'a']--;
            count2[s2.charAt(i + s1.length()) - 'a']++;
        }

        // Check the last window
        return matches(count1, count2);
    }

    private boolean matches(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }
}
