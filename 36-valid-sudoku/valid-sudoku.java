class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }else{
                    if(set.contains("row"+i+board[i][j])) return false;
                    else{
                        set.add("row"+i+board[i][j]);
                    }
                    if(set.contains("col"+j+board[i][j])) return false;
                    else{
                        set.add("col"+j+board[i][j]);
                    }

                    if(set.contains("box"+(i/3)*3+(j/3)+board[i][j])) return false;
                    else{
                        set.add("box"+(i/3)*3+(j/3)+board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}