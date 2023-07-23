class Solution {
    public void dfs(int i, int j, int[] drow, int[] dcol, int[][] visited, int[][] grid){
        visited[i][j] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for(int a=0;a<4;a++){
            int nrow = i+drow[a];
            int ncol = j+dcol[a];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow, ncol, drow, dcol, visited, grid);
            }
        }

        return;
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] drow = {1, 0, 0, -1};
        int[] dcol = {0, 1, -1, 0};

        for(int j=0;j<m;j++){
            if(visited[0][j]==0 && grid[0][j]==1){
                dfs(0, j, drow, dcol, visited, grid);
            }

            if(visited[n-1][j]==0 && grid[n-1][j]==1){
                dfs(n-1, j, drow, dcol, visited, grid);
            }
        }

        for(int i=0;i<n;i++){
            if(visited[i][0]==0 && grid[i][0]==1){
                dfs(i, 0, drow, dcol, visited, grid);
            }

            if(visited[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i, m-1, drow, dcol, visited, grid);
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }

        return count;
    }
}