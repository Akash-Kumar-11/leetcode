

class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] inv : invocations) {
            adj[inv[0]].add(inv[1]);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, adj, suspicious);

        for (int[] inv : invocations) {
            if (!suspicious[inv[0]] && suspicious[inv[1]]) {
                List<Integer> allMethods = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    allMethods.add(i);
                }
                return allMethods;
            }
        }

        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                remaining.add(i);
            }
        }
        return remaining;
    }

    private void dfs(int node, List<Integer>[] adj, boolean[] suspicious) {
        suspicious[node] = true;
        for (int neighbor : adj[node]) {
            if (!suspicious[neighbor]) {
                dfs(neighbor, adj, suspicious);
            }
        }
    }
}
