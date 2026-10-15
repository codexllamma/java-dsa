package code;
public class p518 {
  public static void main(String[]args){
          int[] coins = {1,2,5};
          int amount = 11;
        

          int[] dp = new int[amount+1];
          dp[0] = 1;
          for(int coin: coins){
               for(int i=coin;i<amount+1;i++){
                         dp[i] += dp[i-coin];  
               }
          }
          return dp[amount];
}


