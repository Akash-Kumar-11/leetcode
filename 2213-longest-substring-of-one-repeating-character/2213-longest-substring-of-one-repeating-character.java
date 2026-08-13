class Solution {
    static class Node {
        int maxLen;
        int prefLen;
        int suffLen;
        char prefChar;
        char suffChar;

        Node() {}
    }

    private Node[] tree;
    private char[] chars;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        this.chars = s.toCharArray();
        this.tree = new Node[4 * n];
        
        // Initialize tree nodes
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }

        // Build the Segment Tree initially
        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] result = new int[k];

        // Process each update query
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char val = queryCharacters.charAt(i);
            
            // Perform point update in segment tree
            update(1, 0, n - 1, idx, val);
            
            // The root node (index 1) always maintains the global maximum
            result[i] = tree[1].maxLen;
        }

        return result;
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node].maxLen = 1;
            tree[node].prefLen = 1;
            tree[node].suffLen = 1;
            tree[node].prefChar = chars[start];
            tree[node].suffChar = chars[start];
            return;
        }

        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        
        // Merge left child and right child states into parent
        merge(node, start, end, mid);
    }

    private void update(int node, int start, int end, int idx, char val) {
        if (start == end) {
            chars[idx] = val;
            tree[node].prefChar = val;
            tree[node].suffChar = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        
        // Push changes up to recalculate current node state
        merge(node, start, end, mid);
    }

    private void merge(int node, int start, int end, int mid) {
        Node left = tree[2 * node];
        Node right = tree[2 * node + 1];
        Node parent = tree[node];

        // Inherit default characters from children boundaries
        parent.prefChar = left.prefChar;
        parent.suffChar = right.suffChar;
        
        // Set standard baseline window values
        parent.prefLen = left.prefLen;
        parent.suffLen = right.suffLen;
        parent.maxLen = Math.max(left.maxLen, right.maxLen);

        // If adjacent boundary characters cross-match, we bridge the segment gap
        if (left.suffChar == right.prefChar) {
            int crossBridgeLen = left.suffLen + right.prefLen;
            parent.maxLen = Math.max(parent.maxLen, crossBridgeLen);

            int leftTotalCells = mid - start + 1;
            int rightTotalCells = end - mid;

            // If left side is entirely composed of one uniform character
            if (left.prefLen == leftTotalCells) {
                parent.prefLen = leftTotalCells + right.prefLen;
            }
            // If right side is entirely composed of one uniform character
            if (right.suffLen == rightTotalCells) {
                parent.suffLen = rightTotalCells + left.suffLen;
            }
        }
    }
}

