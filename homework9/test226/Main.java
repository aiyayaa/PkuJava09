package test226;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// ���Ǳ�����������ÿ��һ���ڵ�ͽ�������������ֵ
	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;
		TreeNode temp = invertTree(root.right);
		root.right = invertTree(root.left);
		root.left = temp;
		return root;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
