package code;
public class p53 {
  public int main(String[]args){
    //Maximum subarray
    /*
    So in this problem there is an algorithm called Kadane's algorithm bascialy we say that if we have a streak running. So
    runningTotal + nextElement< nextElement then there is no poin in keeping the current runnign total simply because the new 
    element has a larger running total and so will be a part of the maximum subarray total. so we intialise the runningtotal to zero.
    and then add the next element so if we subtract next elemnt from both sides of the equation we get running total <0 and hence the 
    condition.Also we use maxsum value is initialised to Integer.Min_value to handle negative arrays properly as well.
    */
    int nums[] = {1,3,-2,4};
    
    
    int runningTotal = 0;
    int maxSum = Integer.MIN_VALUE;
    for(int x:nums){
       if(runningTotal<0){  
        runningTotal = 0;
       }
       runningTotal+=x;
       if(runningTotal > maxSum) maxSum = runningTotal;  
          
       }
       return maxSum;
    }
}
