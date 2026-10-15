package code;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class p103{
  public static void main(String[]args){
    
  }  
  
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        List<List<Integer>> result = new ArrayList<>();
        int levelCount = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            if(levelCount % 2 == 0){
                for(int i=0;i<size;i++){
                    TreeNode selected = queue.pollFirst();
                    if(selected.right != null) queue.offerLast(selected.right);
                    if(selected.left != null) queue.offerLast(selected.left);
                    level.add(selected.val);
                }
            }
            else{
                for(int i=0;i<size;i++){
                    TreeNode selected = queue.pollFirst();
                    if(selected.left != null) queue.offerLast(selected.left);
                    if(selected.right != null) queue.offerLast(selected.right);
                    level.add(selected.val);
                    
                }
            }
            result.add(level);
            levelCount++;
        }
        return result;
    }
  
}
    
