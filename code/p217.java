package code;
import java.util.*;

public class p217{
  public boolean main(int nums[]){
    /*
    Contains Duplicate
    set.add() returns false if the element already exists in the hashset.
     */
    HashSet<Integer> set = new HashSet<Integer>();
    for(int x:nums){
        if(!set.add(x)){
          return true;
        }     
    }
    return false;
  }
}