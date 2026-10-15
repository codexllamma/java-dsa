package code;
import java.util.*;

public class p51 {
    public static void main(String[]args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the n: ");
       int n = sc.nextInt();
       int pos[] = new int[n];      
       List<List<String>> res = new ArrayList<>();
       nqueens(n, 0, res,pos);
       


       for(int i=0;i<res.size();i++){
        System.out.println(res.get(i) + "\t");
       }
    }
    
    public static void nqueens(int k,int index, List<List<String>> res, int[] pos){
        if(index == k){
            List<String> cur = new ArrayList<>();
            for(int i=0;i<k;i++){
                  StringBuilder sb = new StringBuilder();
                  
                  for(int j=0;j<k;j++){
                      if(pos[i] == j){
                         sb.append('Q');
                         continue;
                      }
                      sb.append('.');
                  }
                  cur.add(sb.toString());
            }
            res.add(cur);
            return;
        }
        
        for(int i=0;i<k;i++){
                if(place(index, i, pos)){
                    pos[index] = i; 
                    nqueens(k, index+1,res,pos);
                    pos[index] = -1;
                }
        }

    }

    public static boolean place(int r, int c, int[] pos){
         //column check  
         //diagonal check
         for(int i=0;i<r;i++){
            if(pos[i] == c) return false;
            if( Math.abs(pos[i] - c) == Math.abs(i-r)) return false;
         }

         return true;
    }
}

/*
// the optimised approach 
  the columsn one is pretty straightforward but the diagonal one is the real check.. 
  the number of major diagonals as well as minor diagonals on a n*n board is 2n -1 . plain and simple. 
  Try to draw it otu yourself whenever you want.
  |\|\| | |
  |\|\|\| |
  | |\|\|\|
  | | |\|\|

  These are the 3 diagonals something like this only so two more will be there.

  |\|\|\|\|
  |\|\|\|\|
  |\|\|\|\|
  |\|\|\|\|

  so the math checks out. now what we do is we track the indices. on a diagonal for each cell there is a formula 
  that gives us the same number as the result.

  When we take a top left to bottom right(major) diagonal we are essentially goign down one rwo and going down one column.
  so the difference between the row and column remains the same.
  but for a digonal above the center line the difference comes out to be negative so what we do is add k-1.
  because the lowest value we can get is -(k-1) for a major diagonal operation.

  now for the minor diagoal we go one row down and one column left so the sum of row+col remains constant. so thats that
  when we place a queen we mark all the possibel columns and digaonals which it attacks. and whicl ebacktracking we remove it.

  now we dont remove the value of pos[index] like we did in the above solutoin because we are not doing checks based on the pos
  array but we ahve 3 more arrays to do the checks and int eh enxt iteration it gets ooverwritten so no issues there.
  
  List<List<String>> res = new ArrayList<>();
       
       int pos[] = new int[n];      
       boolean[] cols = new boolean[n];
       boolean[] diag1 = new boolean[2*n-1];
       boolean[] diag2 = new boolean[2*n-1];

       nqueens(n, 0, res,pos,cols,diag1,diag2);

 public static void nqueens(int k,int index, List<List<String>> res, int[] pos, boolean[] cols, boolean[] diag1, boolean[] diag2){
        
        if(index == k){
            List<String> cur = new ArrayList<>();
            for(int i=0;i<k;i++){
                  StringBuilder sb = new StringBuilder();
                  for(int j=0;j<k;j++){
                         sb.append(pos[i] == j ? 'Q' : '.');
                  }
                  cur.add(sb.toString());
            }
            res.add(cur);
            return;
        }
        
        for(int i=0;i<k;i++){
            int d1 = index - i + k-1;
            int d2 = index + i;    
            
            if(!cols[i] && !diag1[d1] && !diag2[d2]){
                    pos[index] = i; 
                    cols[i] = true;
                    diag1[d1] = true;
                    diag2[d2] = true;

                    nqueens(k, index+1,res,pos,cols,diag1,diag2);

                    cols[i] = false;
                    diag1[d1] = false;
                    diag2[d2] = false;

            }
        }

    }

*/