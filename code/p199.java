package code;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
public class p199 {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        queue.offerLast(root);

        while(!queue.isEmpty()){
             int size = queue.size();
             result.add(queue.peekLast().val);
             for(int i=0;i<size;i++){
                 TreeNode selected = queue.pollFirst();
                 if(selected.left != null) queue.offerLast(selected.left);
                 if(selected.right != null) queue.offerLast(selected.right);
             }

        }

        return result;

    }
}
