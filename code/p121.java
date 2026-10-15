package code;
public class p121{
  public static void main(String[]args){
    /*
    Best time to buy and sell stock
    We iterate over the prices array and maintain two variables, one for the minimum price we have encountered till that point
    and one for the maximum profit, and at each iteration we ask two questions, and in the end return maxProfit.
    TC: O(n)
    SC: O(1)
    */  
    int p[] = {1,2,3,4};
      int maxProfit = 0;
      int minPrice = Integer.MAX_VALUE;
      for(int i =0;i<p.length;i++){
        if(p[i] < minPrice) minPrice = p[i];
        if(p[i] - minPrice > maxProfit) maxProfit = p[i] - minPrice;
      }
  }
}
