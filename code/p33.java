package code;
public class p33 {
    public int main(String[]args){
      /*
      Searching in rotated sorted array
      Ok so firstly we perform binary search the good thing with sorted rotated array is that there is simply one side is sorted
      and one side is unsorted and the divison of the unsorted side leads to a similar case -one side is sorted
      and one side is unsorted . So we use that fact. To find a target we create a sort of wall. The edge case here is that
      nums[high] or nums[low] can also be the target and so we use <= and >= while checking in which range is the target present.
      We do while(low<=high) simply because we also have to check the last element as well.
      */
      int nums[] = {3,4,5,6,7,1,2};
      int target = 7; 
      int low = 0, high = nums.length-1;
      int mid = 0;
      while(low <= high){
        mid = low+(high-low)/2; 
        if(nums[mid] == target) return mid ;
        if(nums[mid] <= nums[high]){
           //Right side sorted
           if(target<=nums[high] && target>nums[mid]){
               low=mid+1;
               //Target is present in that range
           }
           else{
               //Target not present in that range
               high=mid-1;
           } 
        }
        //Left side sorted
        else{
            if(target>=nums[low] && target<nums[mid]){
              //Target present in that range
              high = mid-1;
            }
            else{
            //Target not present in that range
              low = mid+1;
            }
        }
      }
      return -1;
    }
}
