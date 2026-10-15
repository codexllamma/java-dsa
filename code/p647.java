package code;
/*
Each center contributes palindromes equal to the number of odd expansion layers, which is (p[i] + 1) / 2. we implement manacehers
as we always do. But every alternate expansion is a valid palindrome, because there is a '#' present. 
*/
import java.util.*;
public class p647{
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append('#');
        }
        String t = sb.toString();
        int p[] = new int[t.length()];
        int r=0, c=0;
        for(int i=0;i<t.length();i++){
            if(i<r){
                p[i] = Math.min(r-i, p[2*c-i]);
            }
        int left = i-(p[i]+1);
        int right = i+(p[i]+1);
        while(left>=0 && right<t.length() && t.charAt(right) == t.charAt(left)){
            left--;
            right++;
            p[i]++;
        }
        if(i+p[i] > r){
            c= i;
            r = i+p[i];
        }
        }
        int count = 0;
        for(int i=0;i<p.length;i++){
          count += (p[i]+1)/2;
        }
        System.out.println("Final Count:" + count);
    }
}