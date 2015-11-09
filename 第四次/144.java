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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.empty()) {
            TreeNode t = stack.pop();
            res.add(t.val);
            
            if(t.right != null) {
                stack.push(t.right);
            }
            
            if(t.left != null) {
                stack.push(t.left);
            }
        }
        return res;
    }
}
/*public class Solution {
    List<Integer> result = new ArrayList<Integer>();
 
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root !=null){
            helper(root);
        }
 
        return result;
    }
 
    public void helper(TreeNode p){
        
        result.add(p.val);
        if(p.left!=null)
            helper(p.left);
 

 
        if(p.right!=null)
            helper(p.right);
    }
}*/