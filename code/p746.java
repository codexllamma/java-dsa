package code;
/*
Simple probelm that can be sovled through recursion, memoization and tabulation. The code for tabulation is given below, its like
4 lines of code.
*/

public class p746 {
    public static void main(String[] args) {
          int[] nums = {10,15,20};
          int n = nums.length;
          int dp[] = new int[n];
          for( int i =0;i<n;i++) dp[i] = -1;
          
          System.out.println("Recursion tree by starting with index 0.");
          int sum1 = backtrack(0, nums,dp);
          System.out.println("Recursion tree by starting with index 1.");
          int sum2 = backtrack(1, nums,dp);

          System.out.println("The final minimum cost is: " + Math.min(sum1,sum2));
     }

     public static int backtrack(int index, int[] nums, int[] dp){
          for(int i=0;i<dp.length;i++){
               System.out.print(dp[i] + "\t");
          }
           System.out.println(" ");

          System.out.println("Entering recursion with index " + index);
          
          if(index >= nums.length){
               System.out.println("Out of bounds.Returning via index " + index);
               return 0;
          } 

          if(dp[index] != -1){
               System.out.println("Returning via cached value through DP array: " + dp[index]);
               return dp[index];
          }


          int l1 = nums[index] + backtrack(index+1, nums,dp);
          int l2 = nums[index] + backtrack(index+2, nums,dp);

          System.out.println("Backtracking with index " + index + ". Cost of 1 step up " + l1 + ". Cost of 2 step up " + l2);
          int final_ans = Math.min(l1,l2);
          System.out.println("Returning with final answer: " + final_ans);
          dp[index] = final_ans;
          return final_ans;

    }
}

/*
This is the tabulation code.
int dp[] = new int[n+2];

          for(int i=n-1;i>=0;i--){
               dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
          }
*/