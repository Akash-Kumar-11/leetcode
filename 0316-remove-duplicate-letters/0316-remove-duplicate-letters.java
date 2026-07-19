import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26];
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        // 1. Record the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // 2. Process the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charIndex = c - 'a';

            // If the character is already in the stack, skip it
            if (inStack[charIndex]) {
                continue;
            }

            // Pop characters that are greater than the current character
            // and still appear later in the string
            while (!stack.isEmpty() && stack.peek() > c && lastOccurrence[stack.peek() - 'a'] > i) {
                char top = stack.pop();
                inStack[top - 'a'] = false;
            }

            // Push the current character and mark it as in stack
            stack.push(c);
            inStack[charIndex] = true;
        }

        // 3. Build the result string from the stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
