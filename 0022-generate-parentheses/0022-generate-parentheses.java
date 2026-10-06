
class Solution {
    private static void ansrecursion(int n, int open, int close, String curr, List<String> anslist) {
        if (open == n && close == n) {
            anslist.add(curr);
            return;
        }

        if (open < n) {
            ansrecursion(n, open + 1, close, curr + "(", anslist);
        }

        if (close < open) {
            ansrecursion(n, open, close + 1, curr + ")", anslist);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> anslist = new ArrayList<>(); 
        ansrecursion(n, 0, 0, "", anslist);
        return anslist; 
    }
}
