class Pair{
    int row;
    int col;
    int tm;

    public Pair(int _row, int _col, int _tm){
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count_fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    visited[i][j]=2;
                    q.add(new Pair(i, j, 0));
                }

                if(grid[i][j]==1){
                    count_fresh++;
                }
            }
        }

        int time=0;
        int[] drow = {1, 0, 0, -1};
        int[] dcol = {0, 1, -1, 0};
        int count=0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            time = Math.max(t, time);
            q.remove();

            for(int i=0;i<4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol, t+1));
                    visited[nrow][ncol]=2;
                    count++;
                }
            }
        }

        if(count==count_fresh){
            return time;
        }

        return -1;

    }
}