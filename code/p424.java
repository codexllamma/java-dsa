package code;



public class p424 {
  public static void main(String s,int k){
    /*
     Longest Repeated Character Replacement
     We aim to do a sliding window approach the window takes in to account that the maximum number of allowed iterations is k . 
     So at any given step the size of the window - the most dominant character in that window should be less than k so that the 
     remaining characters can be replaced with that dominant character, we change the frequency of the most dominant character
     by checking whether the current scanned character can become the most dominant character if it can well and good, if not move along
     Track the maximum length at each iteration adn return it to get the final answer.
    */ 
    int freq[] = new int[26];
    int left = 0, maxRepeated = 0,maxLen = 0;
    for(int right = 0;right<s.length();right++){
      freq[s.charAt(right)-'A']++;

      maxRepeated = Math.max(maxRepeated, freq[s.charAt(right) - 'A']);

      /*
      same condition with while gives a better runtime complexity.This is becasue the 'if' approach simply wants to maintain the 
      largest size of the window found so far meanwhile, 'while' approach aims to increase the window size only if there is a legal
      window available. Thus reducing iterations.
       */
      if(((right-left+1) - maxRepeated > k)){
        freq[s.charAt(left)-'A']--; 
        left++; 
      }
      maxLen = Math.max(maxLen, right-left+1);
    }
    
    //return maxLen
  }
}
