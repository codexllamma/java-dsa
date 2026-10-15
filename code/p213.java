package code;
/*
Same as house robber 1, but since there is a circular dependency there is a need to break it down into two linear dependencies,
one in which the first house is forbidden one in which the last house is forbidden. Also the edge case that there is only one house
then it is the first and the last house so we should return the single number itself.
*/
public class test {
     public static void main(String[]args){   
         int[] nums = { 1,2,3,1};
         int n = nums.length;
         
         if(n==1) {
           int ans = nums[i];
         }
         
         int[] dp1 = new int[n+2];
         int[] dp2 = new int[n+2];

         System.out.println("\nDP1 (Excluding first house) ");
         for(int i = n-1;i>=1;i--){
            int rob = nums[i] + dp1[i+2];
            int skip = dp1[i+1];

            dp1[i] = Math.max(rob, skip);

            for(int j =0;j<n+2;j++){
              System.out.print(dp1[j] + "\t");
            }
            System.out.println("");
         }

         System.out.println("\nDP2 (Including first house) ");
         for(int i = n-2;i>=0;i--){
            int rob = nums[i] + dp2[i+2];
            int skip = dp2[i+1];

            dp2[i] = Math.max(rob, skip);

            for(int j =0;j<n+2;j++){
             System.out.print(dp2[j] + "\t");
            }
            System.out.println("");
         }


         System.out.println("\nDP1 (Excluding first house) ");
         for(int j =0;j<n+2;j++){
           System.out.print(dp1[j] + "\t");
         }


         System.out.println("\nDP2 (Including first house) ");
         for(int j =0;j<n+2;j++){
           System.out.print(dp2[j] + "\t");
         }

         int dp1_ans = dp1[1];
         int dp2_ans = dp2[0];

         int final_ans = Math.max(dp1_ans,dp2_ans);
         System.out.println("\nFinal: " + final_ans);
         

     }
}     
