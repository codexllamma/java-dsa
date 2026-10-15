package code;
/*
We use the expand-around-center approach instead of checking all substrings.
Every index is treated as a potential center, and for each index we consider both odd (i, i) and even (i, i+1) length palindromes.
From each center, we expand outward while the characters match, which gives us the maximum palindrome for that center in O(n).
Instead of constructing substrings repeatedly, we only track the length of the palindrome. When we find a longer palindrome, we compute its starting index using:
start = i - (len - 1) / 2
This formula works for both odd and even lengths because (len - 1) / 2 correctly represents the left offset from the center.
Finally, we return the substring using the tracked start and maximum length.
Time complexity is O(n²), since we expand around each center, and space complexity is O(1).

The Manachers Algorithm
Instead of calculating palindrome info in a redundant manner we use the precomputed information to our advantage and do the expansion
and checking only when necessary.

At any given iteration we keep track of the center and the rightmost boundary of the rightmost reaching string. using c and r.
p[i] represents the length of the longest palindrome at i. 

Now there are two cases. Eithe we can calculate the value of p[i] at a given interation using the precomputed info or we cant.
Case 1:
if(i <r)
Basically we can compute the value of that i using preocmputed info and symmetry. 
Now we need to make sure we are using symmetry only upto the point we know. 
so math.min(r-i, p[mirror]);
we cant assume unless verified if we know behind r or not.

Case 2:
i > r in that case we will do the expansion basically the expand around center part.
compute the p[i] info

Now we will have computed the p[i] so the next step is to use this to find the longest palindromic substring.
So we iterate through the p array and keep track of the maxVal and maxIndex basically the max p[i] and the i correspodign to it
So we have info for exmaple at index 4 we have lps with length 3. 4-3/2 = 1.
startIndex = maxIndex-maxval/2

#a#b#b#a#




*/ 
public class p5{    
   public static int expandaroundCenter(String s, int left, int right){
    
    while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            
    }
    return right-left-1;
   }
    public String longestPalindrome(String s){

    int maxLen = 0;
    int start = 0;
    for (int i = 0; i < s.length(); i++) {
    int len1 = expandaroundCenter(s, i, i);       // odd
    int len2 = expandaroundCenter(s, i, i + 1);   // even
    int len = Math.max(len1, len2);

    if (len > maxLen) {
        maxLen = len;
        start = i - (len - 1) / 2;
    } 
    }
    return s.substring(start, start + maxLen);
    /*
    The Manacher's algorithm
    StringBuilder sb = new StringBuilder();
      sb.append('#');
      
      for(int i=0;i<s.length();i++){
          sb.append(s.charAt(i));
          sb.append('#');
      }

      String t = sb.toString();
      int n = t.length();
      int p[] = new int[n];
      int r = 0, c = 0;
      for(int i=0;i<n;i++){
         if(i<r){
            int mirror =  2*c - i;
            p[i] = Math.min(r-i, p[mirror]);
         }
         int left = i - (p[i]+1), right = i + (p[i]+1);

         
         while(left>=0  && right<n && t.charAt(left) == t.charAt(right)){
            left--;
            right++;
            p[i]++;
         }

        if(i+p[i] > r){
            c = i;
            r = i + p[i];
        }
      
      }

      int maxIndex = 0;
      int maxVal = 0;
      for(int i=0;i<p.length;i++){
         if(maxVal < p[i]){
            maxVal = p[i];
            maxIndex = i;
         }
      }

      int start = (maxIndex - maxVal)/2;
      String result = s.substring(start, start + maxVal);
    */
    
   }
}

