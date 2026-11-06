/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: If the current node is null, no path exists.
        if (root == null) {
            return false;
        }
        
        // Check if we are at a leaf node (both left and right children are null).
        // If so, check if the remaining targetSum matches the leaf's value.
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        // Recurse into the left and right subtrees. 
        // Subtract the current node's value from targetSum for the next level.
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}
