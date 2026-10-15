package code;
/*
  Ok so for this we have 3 approaches, either you do bit manipulation. Create 2^n binary numbers, and then if the value is 1 then add 
  that element, else leave it.
  But the backtracking method is the one we need to focus on.

  Now you see this, this is the damn 

        int nums[] = {1,2,3};
        
        List<List<Integer>> result = new ArrayList<>();
        
        
        int n = (int)Math.pow(2, nums.length);
        for(int i=0;i<n;i++){
          List<Integer> cur = new ArrayList<>();
          String bin = convert_bin(i, nums.length);
          System.out.println(" " + bin);
          for(int j =0;j<nums.length;j++){
             if(bin.charAt(j) == '1'){
               cur.add(nums[j]);
             }
          }
          result.add(cur);
        }
        
        for(int i=0;i<n;i++){
          for(int j=0;j<result.get(i).size();j++){
            System.out.print(result.get(i).get(j) + "\t");
          }
          System.out.println("");
        }

        
    }
    public static String convert_bin(int n, int bits){
      String binary = "";
      while(n > 0){
          binary = n%2 + binary;
          n/=2;
      }

      if (binary.equals("")) {
            binary = "0";
      }

        // prepend zeroes
      while (binary.length() < bits) {
            binary = "0" + binary;
      }
      
      return binary;
    }


    This is the implmentation using bitwise operators you do not need to make the binaries from scratch.
    for(int i=0;i<n;i++){
          List<Integer> cur = new ArrayList<>();
          for(int j=0;j<nums.length;j++){
            int mask = 1 << j;      
            
              if((mask & i) != 0){
                cur.add(nums[j]);
              }
           }
           result.add(cur);
        }


*/

// This is te actual backtracking logic.Essentially at every step we decide whether to include or exclud ethat lemetnthen we 
// recurse down the branch. ONly thign we need to keep in mins iwhen using local variables we need to pass it through the 
// recursion, secondly we need to create a new list<integer> object simply beacause objects are jsut memorey references and in 
// case we need to create a new reference or else all the elements in the result list will be referencing the same array. got it.

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
        
        int n = (int)Math.pow(2, nums.length);
        List<Integer> cur = new ArrayList<>();
        
        
        create_subset(0, cur, res, nums);

        
        for(int i=0;i<n;i++){
          for(int j=0;j<res.get(i).size();j++){
            System.out.print(res.get(i).get(j) + "\t");
          }
          System.out.println("");
        }
    }

        public static void create_subset(int index, List<Integer> cur, List<List<Integer>> res,int[] nums ){
              if (index == nums.length){
                res.add(new ArrayList<>(cur));
                return;
              } 

              cur.add(nums[index]);
              create_subset(index + 1, cur, res, nums);
              
              cur.remove(cur.size() - 1);
              create_subset(index + 1, cur, res, nums);
              
            
        }
    }
