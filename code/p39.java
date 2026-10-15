package code;
/*
Q.Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates 
where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at
least one of the chosen numbers is different.
Ok so basically we want to geneerate unique combinations. Now the recursion is simple the base case is if your array sum equals to 
target. WE use the step-through method to avoid duplicates for the recursion tree pruning, we basically allow, only the numbers 
which we havent already explored int he previous level fo the recurison tree to be explored, so we pass the index that we have added
in the recursion and then we only check for the elements in front of that index.
We sort the array that means if one numebr is gereater thatn target then lla the number folloowing it is greateer than traget so we 
break that iteration itself.
*/

import java.util.ArrayList;
import java.util.List;

public class p39 {
    public List<List<Integer>> comb()  
         int nums = { 1,2,3,4};
         int target = 7;
  
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
    

    public static void backtrack(int index, List<Integer> cur, List<List<Integer>> res, int[] nums, int remain){
      if(remain < 0) return;
      if (remain == 0){
        res.add(new ArrayList<>(cur));
        return;
      }
      
      for(int i= index;i<nums.length;i++){
          if(nums[i] > remain) break;;
          cur.add(nums[i]);
          backtrack(i,cur,res,nums,remain-nums[i]);
          cur.remove(cur.size() - 1);
      }

    }

  }