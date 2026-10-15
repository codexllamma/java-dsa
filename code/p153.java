package code;
public class p153{
  public static void main(String[]args){
   /*
   Minimum in Rotated Sorted Array
   Binary Search implied as constraint is to achieve O(log n)
   we dont need a minElement to track the minimum running. Binary search naturally converges to the minimum element
   in the end nums[low] has the correct minimum element no issues there.
   */  
   int nums[] = {1,2,3,4,5};
     int low = 0, high = nums.length-1;
     while(low<high){
         int mid = low+(high-low)/2;
          //Right side sorted
         if(nums[mid]< nums[high]){
          //Include mid in the search as it might be a part of it.  
          high = mid;
         }
         else{
            //dont include mid in search since mid is a bigger number so it cannot be minimum
            low = mid+1;
         }

     }
     return nums[low];
     
  }
}