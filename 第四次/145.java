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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode p=root;
        TreeNode pre=p;
        s.push(p);
        while(!s.empty()){
             p=s.peek();
             if(pre!=p.left&&pre!=p.right){
                 if(p.right!=null) s.push(p.right);
                 if(p.left!=null) s.push(p.left);
             }
             if((p.left==null&&p.right==null)||pre==p.left||pre==p.right){
                 result.add(p.val);
                 p=s.pop();  
             }
             pre=p;
         }
        return result;
    }
}