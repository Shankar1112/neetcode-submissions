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
    Map<Integer, Integer> map = new HashMap<>();
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    TreeNode dfs(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = map.get(preorder[preorderIndex]);
        TreeNode root = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;
        root.left = dfs(preorder, left, mid - 1);
        root.right = dfs(preorder, mid + 1, right);
        return root;
    }
}
