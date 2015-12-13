/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void invertNode(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        while(! stack.empty()) {
           TreeNode cur = stack.peek();
           if(cur.left != null  || cur.right != null) {
               invertNode(cur);
           }
           stack.pop();
           if(cur.right != null) {
               stack.push(cur.right);
           }
           if(cur.left != null) {
               stack.push(cur.left);
           }
        }
        
        return root;
    }
} 