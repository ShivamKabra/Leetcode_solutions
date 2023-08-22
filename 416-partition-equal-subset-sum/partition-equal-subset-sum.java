class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for(int ele : nums){
            sum+=ele;
        }
        if(sum%2!=0) return false;
        int k = sum/2;
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return helper(n-1, k, nums, dp)==1;
        
    }
    public int helper(int index, int target, int[] nums, int[][] dp){
        if(target==0) return 1;

        if(index==0){
            if(nums[0]==target){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[index][target]!=-1){
            return dp[index][target];
        }

        int not_take = helper(index-1, target, nums, dp);
        int take = 0;
        if(target>=nums[index]){
            take = helper(index-1, target - nums[index], nums, dp);
        }
        int ans = take | not_take;
        if(ans==1){
            dp[index][target] = 1;
        }else{
            dp[index][target] = 0;
        }

        return dp[index][target];
    }
}