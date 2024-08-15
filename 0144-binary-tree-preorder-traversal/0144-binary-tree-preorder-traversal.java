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
    private static void preOrder(List<Integer> order, TreeNode root){
        if (root == null) return;
        order.add(root.val);
        preOrder(order, root.left);
        preOrder(order, root.right);
    }

    private static void preOrderIterative(List<Integer> order, TreeNode root){
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()){
            TreeNode node = st.pop();

            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);

            order.add(node.val);
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        //preOrder(order, root);
        preOrderIterative(order, root);
        return order;        
    }
}