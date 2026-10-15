package code;
/*
   ok so we are basically using a recursion+backtrackign where we use a linkedhashset. as soon as that hashset becomes equal to array
   size that means a permutaiotn ahs been created so we taeka snapshot and then clear the element we had added for that recursion.
   We run the recursion using a simple loop. If that element exists then we skip that element. WE store indices first and then 
   in the end for a permutaiton we use the indices to get the elements.
*/

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class p46 {
       public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
      
        LinkedHashSet<Integer> cur = new LinkedHashSet<>();
                
        create_perm(cur, res, nums);

        return res;
        }
    

        private void create_perm(LinkedHashSet<Integer> cur, List<List<Integer>> res,int[] nums ){
                
                if(cur.size() == nums.length){
                  List<Integer> ele = new ArrayList<>();
                  for(int x: cur){
                     ele.add(nums[x]);
                  }
                  res.add(ele);
                  return;
                } 

                for(int i=0;i<nums.length;i++){
                   
                    if(cur.contains(i)) continue;

                    cur.add(i);
                    
                    create_perm(cur, res, nums);

                    cur.remove(i);
                }
              
        }
}
