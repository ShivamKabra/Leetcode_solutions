class Pair{
    int row;
    int col;
    int steps;
    public Pair(int _row, int _col, int _steps){
        this.row=_row;
        this.col=_col;
        this.steps=_steps;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    visited[i][j]=1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        int[] drow = {1, 0, 0, -1};
        int[] dcol = {0, 1, -1, 0};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int steps = q.peek().steps;
            distance[row][col] = steps;
            q.remove();

            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]!=1 && mat[nrow][ncol]==1){
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow, ncol, steps+1));
                }
            }
        }

        return distance;

    }
}