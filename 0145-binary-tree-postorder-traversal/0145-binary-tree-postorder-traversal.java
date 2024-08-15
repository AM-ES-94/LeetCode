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
    private static void postOrder(List<Integer> order, TreeNode root){
        if (root == null) return;
        postOrder(order, root.left);
        postOrder(order, root.right);
        order.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> order = new ArrayList<>();
        postOrder(order, root);
        return order;  
    }
}