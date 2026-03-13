import java.util.Queue;
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        int minutes=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
            while(!q.isEmpty() && fresh>0){
                int size=q.size();
                for(int i=0;i<size;i++){
                    int[] curr=q.poll();
                    int row=curr[0];
                    int col=curr[1];
                //Down
                if(row+1<m && grid[row+1][col]==1){
                    grid[row+1][col]=2;
                    fresh--;
                    q.add(new int[]{row+1,col});
                }
                //Up
                if(row-1>=0 && grid[row-1][col]==1){
                    grid[row-1][col]=2;
                    fresh--;
                    q.add(new int[]{row-1,col});
                }
                //Right
                if(col+1<n && grid[row][col+1]==1){
                    grid[row][col+1]=2;
                    fresh--;
                    q.add(new int[]{row,col+1});
                }
                //Left
                if(col-1>=0 && grid[row][col-1]==1){
                    grid[row][col-1]=2;
                    fresh--;
                    q.add(new int[]{row,col-1});
                }
            }
             minutes++;
        }
        if(fresh > 0){
            return -1;
        }
        return minutes;
    }
}
