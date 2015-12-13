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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return null;
            
        TreeNode cur = root;
        
        while(cur != null) {
            
            if((p.val > cur.val) && (q.val > cur.val))
                cur = cur.right;
                
            if((p.val < cur.val) && (q.val < cur.val))
                cur = cur.left;
                
            else return cur;
        }
       return root; 
    }
}