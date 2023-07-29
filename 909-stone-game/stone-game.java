class Solution {

    public int helper(int l, int r, int[] piles, int[][] dp){
        if(dp[l][r]!=-1){
            return dp[l][r];
        }
        if(l==r){
            return piles[r];
        }

        int left = piles[l] - helper(l+1, r, piles, dp);
        int right = piles[r] - helper(l, r-1, piles, dp);

        dp[l][r] = Math.max(left, right);

        return dp[l][r];
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, n-1, piles, dp)>=0;
    }
}