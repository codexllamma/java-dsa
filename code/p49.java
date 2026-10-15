package code;
import java.util.*;

public class p49 {
  public void main(String[] strs){
    /*
    Group Anagrams
    For each anagram its charcterwise sorted array is the common key.
    So we us that.And group the anagrams via a nested list.
     */
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strs){
          char chars[] = str.toCharArray();
          Arrays.sort(chars); 
          String key = new String(chars);
          if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
          }
          map.get(key).add(str);
        }

        List<List<String>> result= new ArrayList<>(map.values());
        System.out.println(result);
  }
}
