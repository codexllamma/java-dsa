package code;
/*
So it is roughly the same mechanics as jump game 2, we simply do this, if at any point we are exploring an index that we cant
explore based on the indices before, basically index>farthest. and when we know that the farthest index we can reach is greter than 
n-1 at any point that means we done and there exists a path, so we reach there and get it over with. And return true;
*/ 


public class p55 {
    public boolean canJump(int[] nums) {
       int n = nums.length;
       int farthest = 0;

       for(int i=0;i<n;i++){
           
           if(i>farthest){
              return  false;
           }

           farthest = Math.max(farthest, i + nums[i]);

           if(farthest > n -1) return true;
       }

     return true;
    }
}

