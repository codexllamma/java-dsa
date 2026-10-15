package code;
import java.util.*;
/*
 Instead of computing the entire reverse string we compute half reversed string while(n>rev) and then 
 we do two checks(n == rev || n == rev/10) this is to handle even vs odd
 1221 
 n = 12 rev = 21 then n== rev
 12321
 n = 12 rev = 123 then n == rev /10 plain and simple.
*/
public class test {
    public boolean palindrome(int n){

      if(n < 0 || n % 10 == 0 && n!= 0 ) return false;
      int rev = 0;
      while(n>rev){
         rev = rev*10 + n%10;
         n /= 10;
      }

      if(n == rev || n == rev/10) return true;
      return false;

    }
}
