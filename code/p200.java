package code;
public class p200 {
    public static void main(String[] args){
         
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        int result = numIslands(grid);

        System.out.println("Result: " + result);
    }

    public static int numIslands(char[][] grid) {
        
        int count = 0;

        for(int r = 0;r<grid.length;r++){
            for(int c = 0;c<grid[0].length;c++){
                 if(grid[r][c] == '1'){
                    count++;
                    dfs(r,c,grid);
                 }
            }
        }

        return count;
    }

    public static void dfs(int r, int c, char[][] grid){
        
        if(r < 0 || c < 0 || c >= grid[0].length || r >= grid.length || grid[r][c] == '0') return;
        
        grid[r][c] = '0';
        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c+1,grid);
        dfs(r,c-1,grid);
    }

}
