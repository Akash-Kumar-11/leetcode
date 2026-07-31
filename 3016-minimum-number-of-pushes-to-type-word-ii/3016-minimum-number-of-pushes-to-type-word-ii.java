import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int count = 0;
        int[] arr = new int[26];

        for (char c : word.toCharArray()) {
            arr[c - 'a']++;
        }
        
        Arrays.sort(arr); 

        int pressRank = 0;
        for (int i = 25; i >= 0; i--) {
            if (arr[i] == 0) break; 

            int press = pressRank / 8 + 1;
            count += press * arr[i];
            pressRank++;
        }

        return count;
    }
}
