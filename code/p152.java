package code;
public class p152{
  public static void main(String[]args){
    /*
    Maximum Product subarray
    Ok think about the logic we can clearly not have the same way as the Kadane's algorithm. Ok so we cannot outright reject 
    if we do get a negative value beccasue if there is another even value then there might be an issue there.We can use kind of
    a sliding window approach where if we encounter a negative number the left side of the window stays right at that negative 
    numebr and if we encounter a 0 then the left side of the window comes at the element right after the 0. We calculate the product
    till the zero and update maxProduct if it is greater than the runningProduct.
    Ok so we store two variables curMax and curMin. Because a negative product still has the power to switch to a positive number
    when mulitplied with a negative number so. 

    */
   int nums[] = {-2,3,4};
   int curMax, curMin, ans, temp;
   curMax = curMin = ans = nums[0];
   for(int i=1;i<nums.length;i++){
       if(nums[i] < 0){
          temp = curMax;
          curMax = curMin;
          curMin = temp;
       }
       curMax = Math.max(nums[i], curMax*nums[i]);
       curMin = Math.min(nums[i], curMin*nums[i]);
       ans = Math.max(curMax, ans);
   }
   System.out.println(ans);
  }
}