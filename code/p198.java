package code;
/*
The first standard version included standard recursion, but it included a lot of redundant calls the value for which had already 
been calculated in the previous recursive calls, so we utilise memoization, which is basically storing the values during the 
recursive calls and then for consequent recursive calls we can just use the cached values.
This was for the dp and memoization part in general, for this problem at every index we are either taking the value or skipping 
the value, and whatever returns the maximum possible value from this we are considering that.
We are starting from backtrack(0), O(n) time complexity.;
And also in the commented code below. We are doing tabulation, it is used in the case where there is a linear predicatable dependency 
on related elements which can be used to write iterative code.
*/ 

public class p198 {
     public static void main(String[]args){
         int[] nums = {2,7,9,3,1};
         int n = nums.length;
         
         int[] dp = new int[n];
         for(int i=0;i<n;i++) dp[i] = -1;
         int sum = backtrack(0, nums, dp);
         System.out.println("Sum:" + sum);

     }

     public static int backtrack(int index, int[] nums, int[] dp){   
       if(index < 0 || index > nums.length-1 ) {         
         return 0;  
       }
       
       if(dp[index] != -1) {
        return dp[index];
       }

        int l1 = nums[index] + backtrack(index+2, nums,dp);
        int l2 = backtrack(index+1, nums,dp);
        int ans = Math.max(l1,l2);
        dp[index] = ans;
        return ans;

     }
}  

/*
        int n = nums.length;
         
         int[] dp = new int[n+2];
         

         for(int i = n-1;i>=0;i--){
            int rob = nums[i] + dp[i+2];
            int skip = dp[i+1];

            dp[i] = Math.max(rob, skip);
            for(int j=0;j<n+2;j++){
                System.out.print(dp[j] + "\t");
            }
            System.out.println("");
         }

*/