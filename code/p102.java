package code;
import java.util.*;

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

  public class p102{
      public static void main(String[] args){
          List<List<Integer>> result = levelOrder(root);
      }

      public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return new ArrayList<>();
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        

        queue.offerLast(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode selected = queue.pollFirst();
                if(selected.left!=null) queue.offerLast(selected.left);
                if(selected.right!=null) queue.offerLast(selected.right);
                level.add(selected.val);
            }
            result.add(level);
        }
        return result;
    }
}
  

