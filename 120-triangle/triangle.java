class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return helper(0, 0, triangle, dp, n);
    }

    public int helper(int i, int j, List<List<Integer>> triangle, int[][] dp, int n){
        if(i==n-1) return triangle.get(n-1).get(j);

        if(dp[i][j]!=-1) return dp[i][j];

        int down = triangle.get(i).get(j) + helper(i+1, j, triangle, dp, n);
        int diag = triangle.get(i).get(j) + helper(i+1, j+1, triangle, dp, n);

        dp[i][j] = Math.min(down, diag);

        return dp[i][j];
    }
}