class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}}; //down,up,right,left

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs (grid,i,j,dir);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid,int row,int col,int[][] dir){
        int m=grid.length;
        int n=grid[0].length;

        //Base case
        if(row<0 || col<0 || row>=m || col>=n || grid[row][col]=='0'){
            return;
        }

        grid[row][col]='0'; //visited

        for(int[] d : dir){
            int nrow=row+d[0];
            int ncol=col+d[1];
            dfs(grid,nrow,ncol,dir);
        }
    }
}