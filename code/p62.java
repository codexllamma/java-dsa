package code;
/*
So what we are doign is basically at each cell we are asking the question what is the way to reach this cell. Its either from left 
or from up, because we are allowed to go right or down. so then we look at those cells and that cell has the number of ways to reach 
that as well. SO we do that up until we reach the last one . and that will be our answer. We can also do a 1d array space optimisation
Basically see the i =0 column and i = 0 row, all the values in these is gonna be 1.

1       1       1       1       1       1       1
1       2       3       4       5       6       7
1       3       6       10      15      21      28

This is how a standard table looks, for 3 x 7. Now we can do this
1    1    1    1    1    1    1
Initialize a 1d array start iteration from i =1, in this case i = 0 ha the left value and i =1 has the top value.
Now we are filling values for row 2 ( j =1 ) keep that in mind.
So if we are at i = 1 we are essentially at 1,1 we need the values of 0,0 stored on the left and 0,1 stored on i =1 sicnce value
has not been updated and the array represents the row jsut above. 
Now i =1 becomes dp[0] + dp[1] = 2. 
1    2    1    1    1    1    1
Now we are at i =2, which means 1,2 we need 1,1 and 0,2 to find this. 1,1 we jsut calculated i = 1 represents that. because that 
part basically the part right befor the index is the new row, and from the index we are at to the end is the old row.
So at i = 1 we have 1,1 and i = 2 we have 0,2 . We calculate that and so on.
The implementation can be shown as:

for( int i=1;i<m;i++){
  for(int j = 1;j<n;j++){
     dp[j] += dp[j-1] ;
  }
}

Assuming dp[] values has been initialised to 1.

Also have a look at the tabulation implementation which is much easier to explain and imagine.
*/

public class p62 {
  public static void main (String[]args){
  int m = 3, n = 7;
      int[][] dp = new int[m][n];
      dp[0][0] = 1;
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
               if(i==0 && j==0) continue;
               if( i == 0 ){
                    dp[i][j] = dp[i][j-1];
                    continue;
               }
               if( j == 0){
                    dp[i][j] = dp[i-1][j];
                    continue;
               }
               dp[i][j] = dp[i-1][j] + dp[i][j-1];
               
               
          }
      }

      for(int k = 0;k<m;k++){
                    for(int l = 0;l<n;l++){
                         System.out.print("\t" + dp[k][l]);
                    }
                    System.out.println("");
     }
}
}
/* 
public static int minCostClimbingStairs(int[] nums) {
        
        int n = nums.length;

        int[] dp = new int[n];


        dp[1] = nums[1];
        dp[0] = nums[0];

             for(int j=0;j<dp.length;j++){
                System.out.print("\t " + dp[j]);
             }

        for(int i=2;i<dp.length;i++){
             System.out.println(" ");
             
                 dp[i] = nums[i] + Math.min(dp[i-1], dp[i-2]);
             
             for(int j=0;j<dp.length;j++){
                System.out.print("\t " + dp[j]);
             }
        }
    
        return Math.min(dp[n-1], dp[n-2]);

    }
*/