class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return helper(0, n, nums, dp);
    }

    public int helper(int ind, int n, int[] nums, int[] dp){
        
        if(ind>=n-1) return 0;

        if(dp[ind]!=-1) return dp[ind];
        
        int min = Integer.MAX_VALUE - 10000;
        int jump=0;
        
        for(int i=1;i<=nums[ind];i++){
            jump = 1+helper(ind+i, n, nums, dp);
            min = Math.min(min, jump);
        }

        dp[ind] = min;
        return dp[ind];
    }
}