package code;
/*
Longest substring without repeating characters
Well the brute force approach involves using a double loop to find all possible subsequences and then comparing them 
both and getting the longest substring without repeating characters.

Ok so a sliding window approach huh.Well lets start coding and maybe we will get soemthing.
*/
import java.util.*;

public class p3{
  public int longest(String s){
     

     HashMap<Character,Integer> map = new HashMap<>();
     int left = 0, right =0,maxLen=0;
     while(right<s.length()){
         if(map.containsKey(s.charAt(right))){
           left = Math.max(left, (map.get(s.charAt(right)))+1);
          }
          map.put(s.charAt(right), right);
          maxLen = Math.max(maxLen, right-left+1);
          right++;
     }
     return maxLen
  }
}