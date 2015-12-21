/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        
        boolean isLeft = isSymmetric(left.left, right.right);
        boolean isRight = isSymmetric(left.right, right.left);
        return isLeft && isRight;
    }
}*/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        
        leftStack.push(root.left);
        rightStack.push(root.right);
        
        while(leftStack.size() > 0 && rightStack.size() > 0) {
            
            TreeNode left = leftStack.pop();
            TreeNode right = rightStack.pop();
            
            if(left == null && right == null) continue;
            if(left == null || right == null) return  false;
            if(left.val == right.val) {
                leftStack.push(left.left);
                leftStack.push(left.right);
                rightStack.push(right.right);
                rightStack.push(right.left);
            }else{
                return false;
            }
            
        }
        return true;
    }
}