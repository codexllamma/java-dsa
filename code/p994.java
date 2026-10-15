package code;
import java.util.ArrayDeque;
import java.util.Deque;

public class p994 {
  
public static void main(String[] args){
     
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int result = orangesRotting(grid);
     }

    public int orangesRotting(int[][] grid) {
        
        
        int minutes = 0, fresh = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int rows = grid.length;
        int columns = grid[0].length;


        Deque<int[]> queue = new ArrayDeque<>();

        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(grid[r][c] == 2){
                    queue.offerLast(new int[] { r,c});
                }
                if(grid[r][c] == 1) fresh++;
            }
        }

        if(fresh == 0) return 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                int[] selected = queue.pollFirst();
                int r = selected[0], c = selected[1];
             
                for(int j=0;j<4;j++){
                    int newR = r + dr[j];
                    int newC = c + dc[j];

                    if(newR < 0 || newC < 0 || newR == rows || newC == columns) continue;

                    if(grid[newR][newC] == 2 || grid[newR][newC] == 0) continue;
                    

                    if(grid[newR][newC] == 1){
                      grid[newR][newC] = 2;
                      fresh--;  
                      queue.offerLast(new int[] {newR, newC});
                    }
                }
                
            }

            if(!queue.isEmpty()) minutes++;

        }

        if(fresh > 0){
            return -1;
        }
        else{
            return minutes;
        }
    }
}
