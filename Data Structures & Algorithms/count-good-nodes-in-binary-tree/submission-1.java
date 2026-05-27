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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> curr = queue.poll();
            TreeNode currNode = curr.getKey();
            int maxVal = curr.getValue();
            if (currNode.val >= curr.getValue()) {
                res++;
                maxVal = currNode.val;
            }
            if (currNode.left != null) {
                queue.offer(new Pair(currNode.left, maxVal));
            }
            if (currNode.right != null) {
                queue.offer(new Pair(currNode.right, maxVal));
            }
        }

        return res;
    }
}
