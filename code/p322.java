package code;
/*
There are two valid implementations for this.
*/

public class p322 {
  public static void main(int[] coins, int amount){
          int[] coins = {1,2,5};
          int amount = 11;
          
          int final_ans = -1;
          int[] dp = new int[amount+1];

          for(int i=0;i<amount+1;i++) dp[i] = Integer.MAX_VALUE;

          dp[0] = 0;
          
          for(int coin: coins){
               for(int i=coin;i<amount+1;i++){
                    if(dp[i-coin] != Integer.MAX_VALUE){
                         dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                    }
               }
          }

          if(dp[amount] != Integer.MAX_VALUE) final_ans = dp[amount];
          

          System.out.println("Final Answer: " + final_ans);
     }
}

/*

int inf = amount + 1;
        
        int[] dp = new int[amount+1];

        for(int i=1;i<n;i++) dp[i] = inf;
        
        for(int rem=1;rem<amount+1;rem++){
            
            for(int i=0;i<coins.length;i++){
                // if(rem-coins[i] < 0) continue;
                // Make sure yousee how this is derived we are basically sayign negatiev values are suppsoed ot be impossibel so we skip them
                // that means that only take equla to or postiive values init;
                
                if(rem >= coins[i]) {
                    dp[rem] = Math.min(1 + dp[rem-coins[i]], dp[rem]);

                }
            }
        }


        ans = dp[amount];
        if(ans > amount) return -1;
        else return ans;


*/