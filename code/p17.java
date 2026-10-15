package code;
import java.util.*;
public class p17{
    static String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.next();
        
        List<String> res = new ArrayList<>();
        
        backtrack(res, new StringBuilder(), s, 0);

        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i) +"\t");
        }
    }

    public static void backtrack(List<String> res, StringBuilder cur, String s,int index){
        if(index == s.length()) {
            res.add(cur.toString());
            return;
        }

        int c = s.charAt(index) - '0';

        for(int i=0;i<map[c].length();i++){
            cur.append(map[c].charAt(i));
            backtrack(res,cur,s,index+1);
            cur.deleteCharAt(cur.length() - 1);
            
        }
    }




}