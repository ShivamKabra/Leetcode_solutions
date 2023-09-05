class Solution {
    public int get_count(int i, int j, int m, int n, int[][] board){
        int count=0;
        if(j+1<n){
            if(board[i][j+1]==1){
                count++;
            }
        }
        if(i+1<m){
            if(board[i+1][j]==1){
                count++;
            }
        }
        if(i+1<m && j+1<n){
            if(board[i+1][j+1]==1){
                count++;
            }
        }
        if(j-1>=0){
            if(board[i][j-1]==1){
                count++;
            }
        }
        if(i-1>=0){
            if(board[i-1][j]==1){
                count++;
            }
        }
        if(i-1>=0 && j-1>=0){
            if(board[i-1][j-1]==1){
                count++;
            }
        }

        if(i+1<m && j-1>=0){
            if(board[i+1][j-1]==1){
                count++;
            }
        }
        if(i-1>=0 && j+1<n){
            if(board[i-1][j+1]==1){
                count++;
            }
        }

        return count;

    }
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] new_board = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count_live = get_count(i,j, m, n, board);
                if(board[i][j]==0){
                    if(count_live==3){
                        new_board[i][j] = 1;
                    }
                }else{
                    if(count_live<2){
                        new_board[i][j]=0;
                    }else if(count_live>3){
                        new_board[i][j]=0;
                    }else if(count_live==2 || count_live==3){
                        new_board[i][j] = 1;
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = new_board[i][j];
            }
        }
    }
}