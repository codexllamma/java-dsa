package code;

import java.util.HashMap;

/*
Maintain two hashmaps one for need(substring frequency mapped initially), one for tracking window elements(Empty map while intialising). 
Now iterate over the template string. Update the frequency in the window first. Then check whether the frequency of the element we 
just tracked got satisfied. If it did increment the formed element. Now if it satsifies formed = required then we have a valid window 
we will shrink the left until we get an invalid window, once that is done. We find if it is minimum than the globalMinimum if it is store it.
In the end return the global minimum. Make sure you remember that required is number of unique required elements and not the total length
of target string.
Psuedocode

Initialise the need hashmap and fill it
Initialise the empty window hashmap

for right = 0 to s.length() {
    update frequency of right element in window map

    if(frequency gets satisfied which you check by comparing frequencies of the charcter in the window map and need map){
       formed++;
}
       while(formed == required){
          check if it is the minimum string if it is store it

          
          update the frequency map by decrementing the frequency of the left character 
          if the frequency of the element in the window map goes below the frequency of the element in the need map decrement formed
           this will break the while loop so now we can just do left++ and move along
       }
}
  return minStr;

*/

public class p76{
    public static void main(String[]args){
    
    String s = "ABA";
    String t = "AA";
    String result = minWindow( s, t);
    System.out.println("Result: " + result);
  }

  public static String minWindow(String s, String t) {
    int left = 0, minLen = Integer.MAX_VALUE;
    String minStr = "";
    HashMap<Character,Integer> need = new HashMap<>();
    HashMap<Character,Integer> window = new HashMap<>();


    for(int i=0;i<t.length();i++){
        need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);   
    }

    int formed = 0, required = need.size();
    
    for(int right=0;right<s.length();right++){
        
        char c = s.charAt(right);
        window.put(c, window.getOrDefault(c , 0) + 1);
        
        System.out.println("Need");
        need.forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("Window");
        window.forEach((key, value) -> System.out.println(key + " -> " + value));

        if(need.containsKey(c)){
            if (need.get(c).equals(window.get(c))){
            formed++;
            }
        }
        
        while(formed == required){
            
            char leftChar = s.charAt(left);
            
            if(formed == required){
                if(minLen > right-left+1){
                    minLen = right-left+1;
                    minStr = s.substring(left, right+1);
                }            
            }

            window.put(leftChar, window.get(leftChar) - 1);


            if(need.containsKey(leftChar)){
                if(need.get(leftChar) > window.get(leftChar)){
                    formed--;
                }
            }

            left++;
            
        }


    }
    return minStr;
}
}
