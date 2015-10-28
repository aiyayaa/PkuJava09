package test94;


// solution 1 µü´ú
// public List<Integer> inorderTraversal(TreeNode root) {
//    List<Integer> list = new ArrayList<Integer>();
//
//    Stack<TreeNode> stack = new Stack<TreeNode>();
//    TreeNode cur = root;
//
//    while(cur!=null || !stack.empty()){
//        while(cur!=null){
//            stack.add(cur);
//            cur = cur.left;
//        }
//        cur = stack.pop();
//        list.add(cur.val);
//        cur = cur.right;
//    }
//
//    return list;
//}
//}

// solution 2 µÝ¹é
//public List<Integer> inorderTraversal(TreeNode root) {
//    List<Integer> res = new ArrayList<>();
//   helper(root, res);
//    return res;
//    
//    private void helper(TreeNode root, List<Integer> res) {
//        if (root != null) {
//            if (root.left != null) {
//                helper(root.left, res);
//            }
//            res.add(root.val);
//            if (root.right != null) {
//                helper(root.right, res);
//           }
//       }
//   }
   