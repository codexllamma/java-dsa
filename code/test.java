package code;
import java.util.*;
public class test {
   public static void main(String[] args){
        int[] nums = {3,2,1,0,4};   
        Scanner sc = new Scanner(System.in);
        boolean result = false;

        System.out.println("result"+ result);
        
        int n = nums.length;
        int[] ways = new int[n];
        
        for(int i=0;i<n;i++){
          ways[i] = i+nums[i];
        }

        System.out.println("nums array\n");
        for(int i=0;i<n;i++) System.out.print("\t" + nums[i]); 
        System.out.println("\nways array\n");
        for(int i=0;i<n;i++) System.out.print("\t" + ways[i]); 

        int n1 = n-1;
        int i = n-2;
        while(i >=0 ){
          System.out.println("\nn1 " + n1 + "\t i " + i);
          if(ways[i] >= n1){
            System.out.println("ways[i]: " + ways[i] + " >= n1: " + n1);
            n1 = i;
            System.out.println("Assigning n1 as:  " + i  );
          }
            i--;
        }
        
        if(n1 == 0) result = true;
        System.out.println("n1: " + n1);
        
        //2 3 1 0 4
        //0 -> 2
        //1 -> 4
        //2 -> 3
        //3 -> 3
        //2 2 0 3 1 0 4
   }    //2 3 2 6 4 5 
        
}
