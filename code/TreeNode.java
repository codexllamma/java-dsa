package code;

  public class TreeNode {
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

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // if both are true then identical
        if(p == null && q == null) return true;  
        
        // if only one of them is true then not identical
        if(p == null || q == null) return false;  
        
        // if values not equal at some point then false
        if(p.val != q.val) return false;
        
        //compare the right and left branches of both simulatnaoeusly and if at any point there is disparity then false
        return isSameTree(p.right, q.right) && isSameTree(p.left,q.left);
    }
}