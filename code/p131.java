package code;
import java.util.*;
public class p131{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.next();
        //The below part is the manachers algorithm implementation.

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for(int i=0;i<s.length();i++){
             sb.append(s.charAt(i));
             sb.append("#");
        }
        String t = sb.toString();
        int r = 0,c = 0;
        int[] p = new int[t.length()];

        for(int i=0;i<t.length();i++){
            if(i<r){
                p[i] = Math.min(r-i,p[2*c - i]);

            }

            int left = i- (p[i]+1)  , right = i+ (p[i]+1);

            while(left>=0 && right<t.length() && t.charAt(left) == t.charAt(right)){
                 left--;
                 right++;
                 p[i]++;
            }

            if(i+p[i] > r){
                c = i;
                r = i+p[i];
            }
        
        }

        // the p[] array for manachers has been calculated and ready to be used.
        

        List<List<String>> res = new ArrayList<>();
        backtrack(new ArrayList<>(), res, s, 0,p);

        
        
      

    }

    
    public static void backtrack(List<String> cur, List<List<String>> res , String s, int start, int[] p){
        
        if(start == s.length()){
            
            res.add(new ArrayList<>(cur));
            return;
        }
        
        
        
        for(int end = start; end < s.length(); end++){
            
            int center = start+end+1;
            int length = end-start+1;
            
            if(p[center] >= length){
                
                cur.add(s.substring(start,end+1));
                
                backtrack(cur,res,s,end+1,p);
                cur.remove(cur.size()-1);
                
            }
        }     
    }
}


/*

This is the standard implementation of the backtracking procedure.
The call starts from backtrack(cur,res,s,0);

public static boolean isPalindrome(String s,int left, int right){
      while(left <= right){

          if(s.charAt(left)== s.charAt(right)){
             left++;
             right--;
          }
          else{
            return false;
          }
      }
      return true;
}

public static void backtrack(List<String> cur, List<List<String>> res , String s, int start){

        if(start == s.length()){
            
            res.add(new ArrayList<>(cur));
            return;
        }

        
        
        for(int end = start; end < s.length(); end++){
        
            if(isPalindrome(s, start, end)){
        
                cur.add(s.substring(start,end+1));

                backtrack(cur,res,s,end+1);
                cur.remove(cur.size()-1);
        
            }
       }     
    }

*/

