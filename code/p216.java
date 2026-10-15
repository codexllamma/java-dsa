package code;
/*
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

when you reaad combination 1 and 2 this will feel easy as hell. No further explanation needed.
*/

import java.util.ArrayList;
import java.util.List;

public class p216 {
   public static void main(String[]args){
  List<Integer> cur = new ArrayList<>();

    List<List<Integer>> res = new ArrayList<>();
    backtrack(1, cur, res,target, k);

    for(int i=0;i<res.size();i++){
      for(int j=0;j<res.get(i).size();j++){
        System.out.print(res.get(i).get(j) + "\t");
      }
      System.out.println("");
    }
   }
      
  
      public static void backtrack(int index, List<Integer> cur, List<List<Integer>> res, int remain, int k){
        
        if(cur.size() > k || remain<0) return;

        if (cur.size() == k && remain == 0){
          res.add(new ArrayList<>(cur));
          return;
        }
        
        for(int i= index;i<10;i++){
          
            cur.add(i);
            backtrack(i+1,cur,res,remain-i,k);
            cur.remove(cur.size() - 1);
        }
  
      }
    }
  
  
