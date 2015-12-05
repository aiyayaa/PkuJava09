package test235;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
		// solution : Iterative
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		    while ((root.val - p.val) * (root.val - q.val) > 0)
		        root = p.val < root.val ? root.left : root.right;
		    return root;
		}
		// solution : Recursive
		public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		    return (root.val - p.val) * (root.val - q.val) < 1 ? root :
		           lowestCommonAncestor(p.val < root.val ? root.left : root.right, p, q);
		}
		
		
		
	}
	
	
	
	
	
	

}
