package test101;

import java.util.Stack;

public class Main {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	// solution 1 µÝ¹é
	public boolean isSymmetric(TreeNode root) {
		if(root==null) return true;
		return isMirror(root.left,root.right);
	}
	public boolean isMirror(TreeNode p, TreeNode q) {
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		return (p.val==q.val) && isMirror(p.left,q.right) && isMirror(p.right,q.left);
	}
	// solution 2 µü´ú
	public boolean isSymmetric1(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return true;
		Stack<TreeNode> L = new Stack<TreeNode>();
		Stack<TreeNode> R = new Stack<TreeNode>();
		L.push(root.left);
		R.push(root.right);

		while(!L.isEmpty() && !R.isEmpty()) {
			TreeNode left = L.pop();
			TreeNode right = R.pop();
			if (left == null && right == null) continue;
			if (left != null && right != null && left.val == right.val) {
				L.push(left.left);
				R.push(right.right);
				L.push(left.right);
				R.push(right.left);
				continue;
			}
			return false;
		}
		return true;
	}
}