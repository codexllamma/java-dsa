package code;
import java.util.*;
public class p567{
  public static void main(String[]args){
    /*
    Permutations of Strings. So basically what we do is we create two arrays. 
    This is very similar to rabin karp algorithm but instead of using rolling hash we use rolling histogram(frequency array).
    */
    int freq1[] = new int[26];
    int freq2[] = new int[26]; 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the first string");  
    String s1 = sc.nextLine();
    System.out.println("Enter the second string");
    String s2 = sc.nextLine();
    sc.close();
    if( s1.length() < s2.length()) // return false;
    //For creating the histogram for first pass of both strings
    for(int i=0;i<s1.length();i++){
        freq1[s1.charAt(i)-'a']++;
        freq2[s2.charAt(i)-'a']++;
    }
    if(Arrays.equals(freq1,freq2)) flag = true;
    //for creating successive histograms for second string.
    int k = s1.length(); 
    for(int i=k;i<s2.length();i++){
   
      freq2[s2.charAt(i)-'a']++;    
      freq2[s2.charAt(i-k)-'a']--;
          if(Arrays.equals(freq1,freq2)) //return true;
      
    }
    //return false;
    
  }
}