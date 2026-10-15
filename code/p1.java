package code;

import java.util.*;

/*
Two Sum
A simple brute force approach requires a double loop approach to check two elements at a time and if sum
is equal to target we return an array.O(n2)
An optimised approach handles via Hashmap where the keys are the numbers in the array and the values are the indices 
so that when we find it we can return the indices. map.containsKey() is an O(1) lookup method so what we do is we take a 
number and the target-number = complement. map.containsKey(complement) basically finds its complementary pair in the map. 
If it does not exist we add that element in the map itself for future reference.
*/
public class p1 {
  public int[] main(int nums[],int target){
    
     HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
     for(int i=0;i<nums.length;i++){
       if(map.containsKey(target-nums[i])){
         return new int[] {map.get(target-nums[i]), i};
       }

       map.put(nums[i], i);
     }

      return new int[2];
    }
  }
