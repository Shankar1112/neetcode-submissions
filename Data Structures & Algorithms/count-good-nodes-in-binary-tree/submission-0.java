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

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, Integer.MIN_VALUE));
        int goodNodes = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode,Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int maxValue = pair.getValue();
            if (node.val >= maxValue) {
                goodNodes++;
                maxValue = node.val;
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, maxValue));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, maxValue));
            }
        }
        return goodNodes;
        
    }
}
