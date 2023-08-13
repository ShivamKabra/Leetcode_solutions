class Solution {
    public int climbStairs(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return helper(n, dp); 
    }

    public int helper(int n, int[] dp){
        if(n==0){
            return 1;
        }
        if(n==1) return 1;
        if(dp[n]!=-1){
            return dp[n];
        }
        int op1 = helper(n-1, dp);
        int op2 = helper(n-2, dp);

        dp[n] = op1+op2;

        return dp[n];
    }
}