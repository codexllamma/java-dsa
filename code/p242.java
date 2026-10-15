package code;

public class p242{
  public boolean main(String s,String t){
    //Valid anagram problem
    //This is the first approach but a little too heavy even for a brute force.O(N log N)
    /*
    String sortS, sortT;
    sortS = Stream.of(s.split("")).sorted().collect(Collectors.joining());
    sortT = Stream.of(t.split("")).sorted().collect(Collectors.joining());
    
    if(sortT.equals(sortS)){
         return true;
    }
    return false;
     */

   //This is my second approach.Still brute force. Does the same thing but primtiive types are faster. 
   //Edge case: If length not equal then no angaram anyways.O(N log N)
  
   /*
   if(s.length() != t.length()) return false;

   char sortS[] = s.toCharArray();
   char sortT[] = t.toCharArray();

   Arrays.sort(sortS);
   Arrays.sort(sortT);

   if(sortS.equals(sortT)) return true;
   return false;
    */
  
   /*This is an attempt at the optimised approach.We create an array of 26 chars, and maintain frequency table.
   For the first string we increment frequency for a character for the seocn dstrign we decrement frequency for the char.
   In the end if all elements of the array are 0, valid anagram. Since we are passing through array it is O(n);
   Now this array thing works nicely for small datasets like we havev a lowercase English alphabets constraint over here.
   But for larger datasets hashmap becmes much better ,logic of incrementing for one string and decrementing for other remains the same.
   */
   if(s.length() != t.length()) return false;
   
   int freq[] = new int[26];
   for(int i = 0; i<s.length();i++)
      freq[s.charAt(i)-'a']++;  
   for(int i = 0; i<t.length();i++)
      freq[t.charAt(i)-'a']--;  

   for(int x: freq)
      if(x!=0) return false;
    return true;
    
  }
}