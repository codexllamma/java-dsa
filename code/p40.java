package code;
/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where
the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

For the solution we need to first sort the array to group the duplicates, then at every tieration we check that firstly whether
this is the first time we are using one of the duplicates, for example [1,2,2,2,5] we check wehter this is teh first time we are 
using 2 for exploring, we allow for the first time, at this moment the iterator i is equal to the index. At every other iteration 
i > index. so we use i> index as the comparison condition. and our stepthorugh logic allwo sus to skip duplicate ocmbiantions efficiently

*/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class p40 {
    public static void main(String[]args){
    int nums[] = {2,5,2,1,2};
    int target = 5;

    List<Integer> cur = new ArrayList<>();

    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(0, cur, res,nums, target);

    for(int i=0;i<res.size();i++){
      for(int j=0;j<res.get(i).size();j++){
        System.out.print(res.get(i).get(j) + "\t");
      }
      System.out.println("");
    }
  }
      
  
      public static void backtrack(int index, List<Integer> cur, List<List<Integer>> res, int[] nums, int remain){
        
        if (remain == 0){
          res.add(new ArrayList<>(cur));
          return;
        }
        
        for(int i= index;i<nums.length;i++){
            if(i>index && nums[i] == nums[i-1]) continue;

            if(nums[i] > remain) break;
            cur.add(nums[i]);
            backtrack(i+1,cur,res,nums,remain-nums[i]);
            cur.remove(cur.size() - 1);
        }
  
      }
  
    }


