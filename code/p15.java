package code;
import java.util.*;

public class p15 {
  public static void main(String[]args){
    /*
    3 Sum. Lets see so what we did was basically our main goal is to get A+B+c=0 and return these valid triplets from an array.
    SO what we do is we run a double loop, we select A one by one and try to find the pairs, (b,c) such that b+c = -a;
    Now we firstly sort the array this is necesssary to achieve O(n2) time complexity. SO we dont need a hashset for the two 
    sum logic for finding the pair- (b,c) . We can simply do a similar logic to what we do in binary search. 
    if(sum<target) left++;
    if(sum>target) right--;
    The main part is handling duplicates. SO what we do is we need to check the previous entries. IN the outer for loop.
    We check if(nums[i-1] == nums[i]) for duplicate and we also add a condition i>0 so that we dont get out of boudns exception .
    As for handling the left/right duplicates we add nums[left-1] == nums[left] check to skip left duplicates.
    and nums[right] == nums[right+1] check to skip right duplicates, and a left<right check to prevent runtime errors in the success
    block.
    */
    int nums[]  = {-1,0,1,2,-1,-4};
    //-4,-1,-1,0,1,1,2
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    int n = nums.length-1;
    for(int i=0;i<n;i++){
       int a = nums[i]*-1;
       int left = i+1, right = n;
       if(i>0 && nums[i-1] == nums[i]) continue;
       while(left<right){
          if(nums[left]+nums[right] == a){
            
            list.add(Arrays.asList(nums[right--], nums[left++], a*-1));
            //Reducing sliding window as well as skipping duplicates while doing it as well as ensuring left<right
            while(nums[right] == nums[right+1] && left<right) right--;
            while(nums[left] == nums[left-1] && left<right) left++;
            
          }

          else if(nums[left]+nums[right] > a){
             right--;
          }
          else if(nums[left]+nums[right] < a){
             left++;
          }   
       }
       
    }
    
  }
}
