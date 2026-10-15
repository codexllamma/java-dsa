package code;
/*
Roughly the same concept as p46 but since we need to handle duplicates as well. We firslty sort the array this helps us to handle 
duplicates by getting them side by side. Then we make sure that ther exists only a single entry if there are duplicates in there.
if(i>0 && nums[i] == nums[i-1] && !cur.contains(i-1)) continue; using this check this allows the first dupplicate but disallows all
other occurences of that element.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;


public class p47 {
  public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
      
        LinkedHashSet<Integer> cur = new LinkedHashSet<>();
        Arrays.sort(nums);
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
                    if(i>0 && nums[i] == nums[i-1] && !cur.contains(i-1)) continue;
                    cur.add(i);
                    
                    create_perm(cur, res, nums);

                    cur.remove(i);
                }
              
        }
}
