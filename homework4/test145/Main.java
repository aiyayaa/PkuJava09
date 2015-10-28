package test145;

//
//	public class Solution {
//	    public List<Integer> postorderTraversal(TreeNode root) {
//	    LinkedList<Integer> result = new LinkedList<Integer>();
//	    Stack<TreeNode> leftChildren = new Stack<TreeNode>();
//	    while(root != null) {
//	        result.addFirst(root.val);
//	        if (root.left != null) {
//	            leftChildren.push(root.left);
//	        }
//	        root = root.right;
//	        if (root == null && !leftChildren.isEmpty()) {
//	            root = leftChildren.pop();
//	        }
//	    }
//	    return result;
//	    }
//	}
//}
