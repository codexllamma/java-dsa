package code;

import java.util.*;

/*
Would recommend having a look at minimum winodow substring before solving this soelely by yourself you will get a mcuh better understanding
We maintain a hashmap in which we stre frequencies, if window.size() > 2 it is invalid so we shrink until it becomes valid.Then
we compare with the global maximum and then get to it.
The entire problem can be shortened down to maximum sliding window with two distinct values.
*/

public class p904{
    public static void main(String[]args){
    
    int[] fruits = {1,2,3,2,2};
    String result = totalFruit(fruits);
    System.out.println("Result: " + result);
  }

  public static int totalFruit(int[] fruits) {
        int maxLen = 0,left=0;
        
        HashMap<Integer,Integer> window = new HashMap<>();

        for(int right=0;right<fruits.length;right++){
              
              

              window.put(fruits[right], window.getOrDefault(fruits[right], 0) + 1);

              
              
              while(window.size() > 2){
                   
                   window.put(fruits[left] , window.getOrDefault(fruits[left], 0) - 1);
                   
                   if(window.get(fruits[left] ) == 0){
                      window.remove(fruits[left]);
                   }

                   left++;
             }
             
             maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;

  }

}


