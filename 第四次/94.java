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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode p = root;   //pointer
        
        while(!stack.empty() || p !=null) {    //judge to be unempty;
            if(p != null) {
                stack.push(p);
                p = p.left;
            }
            else {
                TreeNode t = stack.pop();
                res.add(t.val);
                p = t.right;
                
            }
        }
        return res;
    }
}
/*public class Solution {
    List<Integer> result = new ArrayList<Integer>();
 
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root !=null){
            helper(root);
        }
 
        return result;
    }
 
    public void helper(TreeNode p){
        if(p.left!=null)
            helper(p.left);
 
        result.add(p.val);
 
        if(p.right!=null)
            helper(p.right);
    }
}*/