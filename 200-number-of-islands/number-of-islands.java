class Solution {

    public void dfs(int a, int b, int[] drow, int[] dcol, int[][] grid2, int[][] visited){
        visited[a][b]=1;
        int m = grid2.length;
        int n = grid2[0].length;
        for(int i=0;i<4;i++){
            int nrow = a+drow[i];
            int ncol = b+dcol[i];

            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid2[nrow][ncol]==1 && visited[nrow][ncol]!=1){
                dfs(nrow, ncol, drow, dcol, grid2, visited);
            }
        }

        return;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] grid2 = new int[m][n];
        for(int i=0;i<m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    grid2[i][j]=1;
                }else{
                    grid2[i][j]=0;
                }
            }
        }

        int count=0;
        int[][] visited = new int[m][n];
        int[] drow = {1, 0, 0, -1};
        int[] dcol = {0, 1, -1, 0};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && visited[i][j]==0){
                    dfs(i, j, drow, dcol, grid2, visited);
                    count++;
                }
            }
        }

        return count;
    }
}