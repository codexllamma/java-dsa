package code;
public class p79 {
    
    static int flag = 0;
    public static void main(String[]args){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        int[][] visited = new int[3][4]; 

        System.out.println("String length: " + word.length());
        
        print_arr(board);
        System.out.println("");
        print_arr(visited);
        
       boolean flag = false;

        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                if(word.charAt(0) == board[r][c] ){
                    System.out.println("Found" + word.charAt(0) + "at" + r + "," + c);
                    System.out.println("Recursing:");
                    
                    flag = backtrack(r,c,board,visited,word,0);
                    if(flag) break;
                }
            }
            if(flag) break;
            System.out.println("");
        }

        if(flag){
            System.out.println("Occurence found");
        }
        else{
            System.out.println("No Ocuurence found");
        }
    }

    public static boolean backtrack(int r, int c,char[][] board, int[][] visited, String word, int index){
            System.out.println("Index:" + index);
            System.out.println("Cell - " + r + "," + c);

            print_arr(board);
            System.out.println("");
            print_arr(visited);    

            
            if(r == -1 || r == board.length || c == -1 || c == board[0].length) return false;
            if(visited[r][c] == 1 ) return false;
            if(word.charAt(index) != board[r][c]) return false;
            if (index == word.length() - 1) return true;
            
            

            visited[r][c] = 1;
            if(backtrack(r+1,c,board,visited,word,index+1) ||
            backtrack(r-1,c,board,visited,word,index+1) ||
            backtrack(r,c+1,board,visited,word,index+1) ||
            backtrack(r,c-1,board,visited,word,index+1)
            ) {
                return true;
            }
            
            visited[r][c] = 0;
            
            return false;
    }

    public static void print_arr(int[][] visited) {
        for(int r=0;r<visited.length;r++){
            for(int c=0;c<visited[0].length;c++){
                System.out.print("\t" + visited[r][c]);
            }
            System.out.println("");
        }
    }

    public static void print_arr(char[][] board) {
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[0].length;c++){
                System.out.print("\t" + board[r][c]);
            }
            System.out.println("");
        }
    }
}

/*

We slightly modify the function for better efficiency basically we dont create another 2d array to track the visited cells,
instead we store the character temporarily, mark it as visited in the board array itself,  do the backtracking and then go ahead 
and put it back in its place after backtracking is done.
char seenChar = board[r][c];
board[r][c] = VISITED;
            if(backtrack(r+1,c,board,visited,word,index+1) ||
            backtrack(r-1,c,board,visited,word,index+1) ||
            backtrack(r,c+1,board,visited,word,index+1) ||
            backtrack(r,c-1,board,visited,word,index+1)
            ) {
                return true;
            }
          
board[r][c] = seenChar;
*/
    


