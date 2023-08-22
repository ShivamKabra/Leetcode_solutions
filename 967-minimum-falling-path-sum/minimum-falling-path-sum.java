class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int[][] dp = new int[m][m];

        for(int j=0;j<m;j++){
            dp[0][j] = matrix[0][j];
        }

        for(int i=1;i<m;i++){
            int ld = Integer.MAX_VALUE;
            int rd = Integer.MAX_VALUE;
            for(int j=0;j<m;j++){
                int up = matrix[i][j] + dp[i-1][j];
                if(j>0){
                    ld = matrix[i][j] + dp[i-1][j-1];
                }
                if(j<m-1){
                    rd = matrix[i][j] + dp[i-1][j+1];
                }
                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
        int mini = Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            mini = Math.min(mini, dp[m-1][i]);
        }

        return mini;
    }
}