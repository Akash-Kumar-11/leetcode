class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // If count > 0, this '(' is NOT an outermost parenthesis
                if (count > 0) {
                    result.append(ch);
                }
                count++;
            } else { // ch == ')'
                count--;
                // If count > 0 after decrementing, this ')' is NOT an outermost parenthesis
                if (count > 0) {
                    result.append(ch);
                }
            }
        }
        
        return result.toString();
    }
}
