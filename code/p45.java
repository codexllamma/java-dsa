package code;
/*
So the question exists of a simple thing, how many jumps does it take to reach the end. so at every index we check which is the
farthest index we can reach, and if the farthest at that index is the farthest index we can reach from any previous index we have
seen before.As soon as we reach that farthest index and there are not further farthest index, then we count that as a jump, and 
then repeat the same thing. As soon as we reach n-2, we will have our last jump and then we will reach the last index. In the question
it is guaranteed that the indices will take us to nums[n-1] so we can rely on this property and get going on that.
*/

public class p45{
    
    public static void main(String[]args){
       int[] nums = {1,2,3};
       int n = nums.length;
       
       int current_jump_end = 0;
       int farthest = 0;
       int jumps = 0;
       
       for(int i=0;i<n-1;i++){
           
           farthest = Math.max(farthest, i + nums[i]);

           if(i == current_jump_end){
              jumps++;
              current_jump_end = farthest;
           }
       }

       System.out.println("Total jumps: " + jumps);
    }
   

}
