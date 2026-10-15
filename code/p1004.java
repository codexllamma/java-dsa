package code;

import java.util.*;

/*
Pretty straightforward. We have to keep track of the number of zeroes encountered up until now. Then if we exceed that limit, 
we simply shrink the window from the left side until we reach a zero once we do we reduce it and now we have another zero we can 
replace got it. After shrinking the window note down the maximum length. Plain and simple.
*/

public class p1004{
    public static void main(String[]args){
    
    int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
    int k = 2;
    int result = longestOnes(nums,k);
    System.out.println("Result: " + result);
  }

  public static int longestOnes(int[] nums, int k) {
        int left = 0,zeroes = 0, maxLen = 0;
        for(int right=0;right<nums.length;right++){
            if(nums[right] == 0) zeroes++;
            
            while(zeroes > k){
                if(nums[left] == 0) zeroes--;
                left++;
            }
            
            maxLen = Math.max(maxLen, right-left+1);
             
        }
        return maxLen;
  }
}


