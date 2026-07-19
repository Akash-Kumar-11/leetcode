import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charIndex = c - 'a';

            if (inStack[charIndex]) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && lastOccurrence[stack.peek() - 'a'] > i) {
                char top = stack.pop();
                inStack[top - 'a'] = false;
            }

            stack.push(c);
            inStack[charIndex] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
