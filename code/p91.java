package code;
/*
 The first attempt at it of 25 minutes is printed below then saw the solution and implemented the recursion o(2^n) which caused the 
 tiem limit to be exceeded then did memoisation + recursion, which is shown below and below that attempt you will find the dp is also 
 implemeneted.
*/

public class p91 {
  public static void main(String[] args){
       String s = "11106";
       
       int result = numDecodings(s);
       System.out.println("Result: " + result);
   }


   public static int numDecodings(String s) {
      Integer[] mem = new Integer[s.length() +1];
      
      return s.length() == 0 ? 0 : backtrack(0, s,mem);

   }

   public static int backtrack(int p , String s, Integer[] mem){
      int n = s.length();
      if(p == n) return 1;
      if(s.charAt(p) == '0') return 0;
      if(mem[p] != null) return mem[p];
      int res = backtrack(p+1, s,mem);
      if(p<n-1 && (s.charAt(p) == '1' || (s.charAt(p) == '2' && s.charAt(p+1) < '7'))) res+= backtrack(p+2, s, mem);
      return mem[p] =res;
   }
}

/*

public static int backtrack(int index, int count, String s, int flag){
      if(flag == 1) return 0;
      if(index == s.length()){
         return count+1;
      }

      if(index > s.length()) return 0;
       
      
      if(s.charAt(index) == '0'){
         if(index>0 && s.charAt(index-1) != '1' && s.charAt(index) != '2' ){
            flag = 1;
            return 0;
         } 
      }

      int count1 = backtrack(index + 1, count, s,flag);
      int count2 = backtrack(index+2, count, s, flag);

      return count1+count2;
   }
*/


/*
DP Solution
public int numDecodings(String s) {
        int n=s.length();
        int[] dp=new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--)
            if(s.charAt(i)!='0') {
                dp[i]=dp[i+1];
                if(i<n-1&&(s.charAt(i)=='1'||s.charAt(i)=='2'&&s.charAt(i+1)<'7')) 
					dp[i]+=dp[i+2];
            }
        return dp[0];   
    }
*/

 