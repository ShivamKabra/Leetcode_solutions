class Solution {
    public void dfs(int i, int j, int[] drow, int[] dcol, int[][] visited, char[][] board){
        visited[i][j] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int a=0;a<4;a++){
            int nrow = i+drow[a];
            int ncol = j+dcol[a];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow, ncol, drow, dcol, visited, board);
            }
        }

        return;        
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] drow = {1, 0, 0, -1};
        int[] dcol = {0, 1, -1, 0};
        int[][] visited = new int[n][m];

        for(int j=0;j<m;j++){
            if(visited[0][j]==0 && board[0][j]=='O'){
                dfs(0,j, drow, dcol, visited, board);
            }

            if(visited[n-1][j]==0 && board[n-1][j]=='O'){
                dfs(n-1, j, drow, dcol, visited, board);
            }
        }

        for(int i=0;i<n;i++){
            if(visited[i][0]==0 && board[i][0]=='O'){
                dfs(i, 0, drow, dcol, visited, board);
            }

            if(visited[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i, m-1, drow, dcol, visited, board);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }

        return;

    }
}